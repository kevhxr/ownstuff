package corejava.concurrent.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFuture<String> completableFutureOne = new CompletableFuture<>();

        // futureA.join();
        ExecutorService cachePool = Executors.newCachedThreadPool();
        /**
         * runAsync方法不支持返回值。
         * supplyAsync可以支持返回值。
         */
        CompletableFuture<String> futureA = CompletableFuture.
                supplyAsync(() -> {
                    System.out.println("supplyAsync: " + Thread.currentThread().getName());
                    return "执行结果:" + (100 / 10);
                }, cachePool)
                .thenApply(s -> {
                    System.out.println("thenApplyAsync: " + Thread.currentThread().getName());
                    return "apply result:" + s;
                })
                .exceptionally(e -> {
                    System.out.println("执行失败！" + e.getMessage());
                    return null;
                })
                /**
                 * whenComplete：是执行当前任务的线程执行继续执行 whenComplete 的任务。
                 * whenCompleteAsync：是执行把 whenCompleteAsync 这个任务继续提交给线程池来进行执行。
                 */
                .whenComplete((s, e) -> {
                    if (e == null) {
                        System.out.println("no e:   " + s);//futureA result: 100
                    } else {
                        System.out.println("e is not empty: " + e.getMessage());//未执行
                    }
                });

        List<Shop> shops = Arrays.asList(new Shop("shop1"),
                new Shop("shop2"),
                new Shop("shop3"),
                new Shop("shop4"),
                new Shop("shop5"),
                new Shop("shop6"),
                new Shop("shop7"),
                new Shop("shop8"),
                new Shop("shop9"));

        List<CompletableFuture<String>> collect = shops.stream().parallel().map(shop -> CompletableFuture.
                supplyAsync(() -> {
                    System.out.println("supplyAsync: " + Thread.currentThread().getName());
                    ThreadLocalRandom random = ThreadLocalRandom.current();
                    boolean b = random.nextBoolean();
                    int a = 100;
                    if (b) {
                        a = a / 0;
                    } else {
                        a = a / 10;
                    }
                    return "执行结果:" + a + Thread.currentThread().getName() + "-" + shop.getName();
                }, cachePool)
                .thenApply(s -> {
                    //System.out.println("thenApplyAsync: " + Thread.currentThread().getName());
                    return "apply result:" + s;
                })
                .exceptionally(e -> {
                    System.out.println("执行失败！" + e.getMessage());
                    return null;
                })
                .whenComplete((s, e) -> {
                    if (e == null) {
                        //System.out.println("no e:   " + s);//futureA result: 100
                    } else {
                        // System.out.println("e is not empty: " + e.getMessage());//未执行
                    }
                })).collect(Collectors.toList());
        //collect.stream().map(CompletableFuture::join);
        System.out.println();
        System.out.println();
        //collect1.stream().forEach(a-> System.out.println(a));
        cachePool.shutdown();

    }

    @Test
    public void voidTest() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Void> future = completableFuture
                .thenAccept(s -> System.out.println("Computation returned: " + s));

        Void aVoid = future.get();
        System.out.println(aVoid == null);
    }

    @Test
    public void runTest() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Void> future = completableFuture
                .thenRun(() -> System.out.println("Computation finished."));

        future.get();
    }

    @Test
    public void composeTest() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"))
                .thenApply(s -> {
                    System.out.println(s);
                    return s + " apply";
                });

        System.out.println(completableFuture.get());
    }

    @Test
    public void combineTest() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCombine(
                        CompletableFuture.supplyAsync(
                                () -> " World"), (s1, s2) -> {
                            System.out.println(s1);
                            System.out.println(s2);
                            return s1 + s2;
                        }
                );
        System.out.println(completableFuture.get());
    }
}

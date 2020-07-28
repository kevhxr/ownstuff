package corejava.concurrent.jdk8;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureTest {

    static List<Shop> shops = Arrays.asList(new Shop("shop1"),
            new Shop("shop2"),
            new Shop("shop3"),
            new Shop("shop4"),
            new Shop("shop5"),
            new Shop("shop6"),
            new Shop("shop7"),
            new Shop("shop8"),
            new Shop("shop9"),
            new Shop("shop11"));

    public static void mimicException(ThreadLocalRandom random) {
        boolean bool = random.nextBoolean();
        if (bool) {
            int b = 1 / 0;
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        List<CompletableFuture<String>> collect = shops.stream().parallel().map(
                /**
                 * runAsync方法不支持返回值。
                 * supplyAsync可以支持返回值。
                 */
                shop -> CompletableFuture.supplyAsync(() -> {
                    ThreadLocalRandom random = ThreadLocalRandom.current();
                    int randInt = random.nextInt(0, 10);
                    int a = 1000;
                    if (randInt < 5) {
                        a = a / 0;
                    } else {
                        a = a / randInt;
                    }
                    return "Th:" + Thread.currentThread().getName() + "; result: " + shop.getName() + " (profit:" + a + ")";
                }, threadPool)
                        .thenApply(s -> {
                            mimicException(ThreadLocalRandom.current());
                            return "apply: " + s;
                        })
                        .exceptionally(e -> {
                            System.out.println("failure: " + e.getMessage());
                            return null;
                        })
                        .whenComplete((s, e) -> {
                            if (e == null) {
                                System.out.println("Complete success:   " + s);
                            } else {
                                System.out.println("Complete failure: " + e.getMessage());
                            }
                        }))
                .collect(Collectors.toList());

        List<String> finalList = collect.stream()
                .map(CompletableFuture::join)
                .filter(shop -> shop != null)
                .collect(Collectors.toList());

        System.out.println();
        System.out.println();
        finalList.stream().forEach(a -> System.out.println(a));
        threadPool.shutdown();
    }

    @Test
    public void testWhenCompleteException() {
        TreeMap<String, String> resMap = new TreeMap<>(Comparator.comparingInt(o -> Integer.parseInt(o.substring(4))));
        resMap.put("shop0", "sd");
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        shops.stream().parallel().forEach(
                shop ->
                        CompletableFuture.supplyAsync(() -> "Th:" + Thread.currentThread().getName() + " success!", threadPool)
                                .thenApply(s -> {
                                    mimicException(ThreadLocalRandom.current());
                                    return "apply: " + s;
                                })
                                .exceptionally(e -> {
                                    mimicException(ThreadLocalRandom.current());
                                    return "exception handle correctly";
                                })
                                .whenComplete((s, e) -> {
                                    if (e == null) {
                                        resMap.put(shop.getName(), "Complete success: " + s);
                                    } else {
                                        resMap.put(shop.getName(), "Complete failure: && exception handle failed: " + e.getMessage());
                                    }
                                })
        );
        resMap.entrySet().forEach(s -> System.out.println("() -- " + s.getKey() + " --- " + s.getValue()));
        threadPool.shutdown();

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

    @Test
    public void multipleFutureTest() throws Exception {

        String out = "";
        HashMap<String, Integer> teamMap = new HashMap<>();
        teamMap.put("Timberwolf", 1);
        teamMap.put("wizard", 2);
        teamMap.put("Magic", 3);
        List<CompletableFuture<String>> futures = new ArrayList<>();
        teamMap.entrySet().iterator().forEachRemaining(map ->
                futures.add(CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(100 * map.getValue());
                        System.out.println(map.getKey() + map.getValue());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    return map.getKey();
                })));
        CompletableFuture<Void> combinedF = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        combinedF.get();
        System.out.println("block done");
/*
        String combined = Stream.of(futures.toArray((new CompletableFuture[0])))
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));
        System.out.println(combined);*/
    }


    @Test
    public void handleTest() throws ExecutionException, InterruptedException {

        String name ;
        Random random = new Random();
        boolean b = random.nextBoolean();
        System.out.println(b);
        name = !b ? null : "sd";

        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((result, ex) -> {
            System.out.println(result);
            if(ex != null && ex instanceof RuntimeException){
                return result != null ? result : "Hello, runtime stranger!";
            }
            System.out.println(ex);
            return result != null ? result : "Hello, Stranger!";
        });

        String s = completableFuture.get();
        System.out.println(s);
    }

    @Test
    public void doTestMultiPram() {
        List<String> strList = new ArrayList<>();
        strList.add("www");
        strList.add("www2");
        strList.add("www1");

        testMultiPram(strList.toArray(new String[0]));
    }

    public static void testMultiPram(String... strArr) {
        Arrays.stream(strArr).forEach(a -> System.out.println(a));
    }
}
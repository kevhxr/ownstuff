package corejava;


import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExceptionTest {


    public static void main(String[] args) {
        try {

            Class<?> aClass = Class.forName("corejava.ExceptionTest");
            Method[] preMethod2 = aClass.getDeclaredMethods();
            Arrays.stream(preMethod2).forEach(a->{
                System.out.println(a.getName());
                if(a.getName().equals("preMethod2")){
                    System.out.println(a.getName()+" "+a.getParameterCount());
                }
            });
            System.out.println();
            Method dd = aClass.getDeclaredMethod("preMethodTwo",String.class,String.class);
            aClass.getDeclaredMethod("preMethod").setAccessible(true);
            ExceptionTest exce = (ExceptionTest) aClass.newInstance();
            exce.preMethod();

            System.out.println();
            ExceptionTest o = new ExceptionTest();
            Method preMethod = ExceptionTest.class.getDeclaredMethod("preMethod", null);
            preMethod.setAccessible(true);
            preMethod.invoke(o, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preMethodTwo(String aaa, String bvbb) {
        System.out.println("sadsdsadsadsadsa");
    }

    private void preMethod() {
        System.out.println("sadsdsadsadsadsa");
    }

    public void tsest() {
        try {

            TreeSet<Integer> a1 = new TreeSet<>();
            a1.add(1);

            int a = 4;
            System.out.println(a >> 1);
            List<Integer> copy = new ArrayList<>();
            copy.add(1);
            System.out.println(copy);

            Random rand = new Random(47);
            Set<Integer> intset = new HashSet<Integer>();
            for (int i = 0; i < 10000; i++) {
                intset.add(rand.nextInt(30));
            }
            System.out.println(intset);

/*            Map<Integer,String> map = new HashMap<>();
            map.put(1,"111");
            map.put(1,"222");
            map.entrySet().forEach(a-> System.out.println(a.getKey()+a.getValue()));
            ExecutorService service = Executors.newFixedThreadPool(5);*/

/*            service.execute(() -> {
                System.out.println(Integer.parseInt("XYZ"));
            });*/

/*            Future<?> test = service.submit(() -> {
                System.out.println(Integer.parseInt("XYZ"));
            });

            try {
                Object o = test.get();
            }catch (Exception e){
                System.out.println(e);
            }


            service.shutdown();
            test();*/
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    public static void test() throws Exception {
        try {
            System.out.println("start");
            throw new Exception("we");
        } catch (Exception e) {
            System.out.println("catch ee");
            throw new Exception("catch exception");
        } finally {
            System.out.println("finally");
            //throw new Exception("final exception");
        }
    }
}

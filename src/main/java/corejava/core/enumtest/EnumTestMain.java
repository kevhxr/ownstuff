package corejava.core.enumtest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class EnumTestMain {
    public static void main(String[] args) throws NoSuchMethodException {
        Week[] values = Week.values();
        Arrays.stream(values).forEach(a-> System.out.println(a));
        System.out.println();
        Week monday = Week.MONDAY;
        int i = monday.compareTo(Week.TUESDAY);
        System.out.println(i);
        System.out.println(monday);


        System.out.println();


        Class<?> clazz = Week.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(a-> System.out.println(a.getName()));
        Object[] enumInstances =  clazz.getEnumConstants();

        Method getWeekDay = clazz.getMethod("getWeekDay");
        System.out.println();
        try {
            System.out.println(getWeekDay.invoke(enumInstances[0]));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

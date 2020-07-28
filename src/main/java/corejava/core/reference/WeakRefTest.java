package corejava.core.reference;

import corejava.core.Teacher;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeakRefTest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher(1,"sdsad");
        WeakReference<String> weakStr = new WeakReference<>("hhhhhh");
        WeakReference<Teacher> weakTeacher = new WeakReference<>(teacher);
        WeakReference<Teacher> weakTeacher2 = new WeakReference<>(new Teacher(12, "hh"));
        SoftReference<Teacher> softTeacher = new SoftReference<>(new Teacher(122, "hh"));
        PhantomReference<Teacher> phantomTeacher
                = new PhantomReference<>(new Teacher(112, "hh"),
                new ReferenceQueue<>());

        System.out.println(weakStr.get());
        System.out.println(weakTeacher.get());
        System.out.println(weakTeacher2.get());
        System.out.println(softTeacher.get());
        System.out.println(phantomTeacher.get());
        System.out.println("+========");
        System.gc();
        System.out.println(weakStr.get());
        System.out.println(weakTeacher.get());
        System.out.println(weakTeacher2.get());
        System.out.println(softTeacher.get());
        System.out.println(phantomTeacher.get());

    }

    @Test
    public void listWeakTest(){
        List<WeakReference<Teacher>> teachers = new ArrayList<>();
        for (int i = 0; i <100000 ; i++) {
            teachers.add(new WeakReference<Teacher>(new Teacher(12, "hh")));
        }
        System.out.println(teachers.size());
        System.out.println(teachers.get(0).get());
        System.out.println("============================");
        System.gc();
        System.out.println(teachers.size());
        System.out.println(teachers.get(0).get());
    }
}

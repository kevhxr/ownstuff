package corejava.core.container;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {

        PriorityQueue<Student> students = new PriorityQueue<>((o1, o2) -> o2.age-o1.age);
        PriorityQueue<Student> students2 = new PriorityQueue<>();
        students2.offer(new Student(12));
        students2.offer(new Student(15));
        students2.offer(new Student(1));
        students2.offer(new Student(10));

        Student bb = students2.poll();
        while(bb!=null){
            System.out.println(bb);
            bb = students2.poll();
        }

        System.out.println();
        System.out.println();


        students.offer(new Student(12));
        students.offer(new Student(15));
        students.offer(new Student(1));
        students.offer(new Student(10));
        students.offer(new Student(3));

        Student a = students.poll();
        while(a!=null){
            System.out.println(a);
            a = students.poll();
        }

    }

    private static class Student implements Comparable<Student> {

        private int age;

        public Student(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    '}';
        }

        @Override
        public int compareTo(Student o) {
            return o.age-this.age;
        }
    }
}

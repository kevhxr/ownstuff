package corejava.generic;

import java.util.ArrayList;
import java.util.List;

public class TongpPei {

    public static void main(String[] args) {
        List<? super User> userList = new ArrayList<>();
        userList.add(new User());
        userList.add(new Student());
        //userList.add(new Human());
        //userList.add(new Object());
        if (userList.size() > 0) {
            //User user1 = userList.get(0);

            //ClassCastException
            //Student user1 = (Student) userList.get(0);

            User user1 = (User) userList.get(0);
            user1.human();
            user1.user();
            System.out.println();

            Human hm1 = (Human) userList.get(0);
            hm1.human();
            System.out.println();

            /*
            ClassCastException
            Student student1 = (Student) userList.get(0);
            System.out.println(student1.getClass());*/
            Object object1 = userList.get(0);
            System.out.println(object1.getClass());
        }

        List<User> users = new ArrayList<>();
        users.add(new Student());
        users.add(new User());
        User user1 = users.get(0);


        List<? extends User> userList2 = new ArrayList<>();
        //userList2.add(new User());
        //userList2.add(new Student());
        //userList2.add(new Human());
        //userList2.add(new Object());
        System.out.println();
        if (userList2.size() > 0) {
            User user = userList2.get(0);
            Human human = userList2.get(0);
            Object object = userList2.get(0);
            Student student = (Student) userList2.get(0);
        }

    }
}

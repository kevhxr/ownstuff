package algorithms.collection;

import java.util.Random;
import java.util.Stack;

public class SingleLinkedList {

    public static void main(String[] args) {
        MyLinkedList head = new MyLinkedList();
        createList(head);
        inverseList(head);
    }

    /**
     * 构建任意长度的任意数值的链表, 头插法
     */

    public static void createList(MyLinkedList head) {
        Random random = new Random(System.currentTimeMillis());
        int len = random.nextInt(10);
        len++;
        for (int i = 0; i < len; i++) {
            int data = random.nextInt(100);
            MyLinkedList next = new MyLinkedList(data);
            next.next = head.next;
            head.next = next;
        }
        /**
         * 顺序遍历输出链表
         */
        MyLinkedList head2 = head.next;
        System.out.println("顺序");
        while (head2 != null) {
            System.out.print(head2.data + "\t");
            head2 = head2.next;
        }
        System.out.println("length=" + len);
    }

    /**
     * 高效的输出链表,使用栈来存储
     */
    public static void inverseList(MyLinkedList head) {
        MyLinkedList head2 = head.next;
        Stack<Integer> stack = new Stack<>();
        System.out.println("逆序");
        while (head2 != null) {
            stack.push(head2.data);
            head2 = head2.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "\t");
        }

    }



}

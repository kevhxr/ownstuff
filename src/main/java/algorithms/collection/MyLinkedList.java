package algorithms.collection;

public class MyLinkedList {
    public int data;
    public MyLinkedList next;

    public MyLinkedList(int data) {
        this.data = data;
        this.next = null;
    }

    public MyLinkedList() {
        this.data = -1;
        this.next = null;
    }
}

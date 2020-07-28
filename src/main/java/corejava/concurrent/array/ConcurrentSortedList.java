package corejava.concurrent.array;

import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSortedList {

    private final Node head;
    private final Node tail;

    public ConcurrentSortedList() {
        Node head = new Node();
        Node tail = new Node();
        this.head = head;
        this.tail = tail;
    }

    public void insert(int value) {
        Node current = head;

        current.lock.lock();
        Node next = current.next;
        try {
            while (true) {
                next.lock.lock();
                try {
                    if (next == tail || next.value < value) {
                        Node node = new Node(value, current, next);
                        next.prev = node;
                        current.next = node;
                        return;
                    }
                } finally {
                    current.lock.unlock();
                }
                current = next;
                next = current.next;
            }
        } finally {
            next.lock.unlock();
        }
    }

    public int size() {
        Node current = tail;
        int count = 0;
        while (current.prev != head) {
            ReentrantLock lock = current.lock;
            lock.lock();
            try {
                ++count;
                current = current.prev;
            } finally {
                lock.unlock();
            }
        }
        return count;
    }

    private class Node {
        int value;
        Node prev;
        Node next;
        ReentrantLock lock = new ReentrantLock();

        Node() {
        }

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}

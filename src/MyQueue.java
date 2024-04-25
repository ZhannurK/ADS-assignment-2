public class MyQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    private class Node<T> {
        private T data;
        private Node<T> next;
        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T data = head.data;
        head = head.next;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    public int size() {
        return size;
    }
}
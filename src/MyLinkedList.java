public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    private class MyNode<E> {
        private E data;
        private MyNode<E> next;
        public MyNode(E data) {
            this.data = data;
            next = null;
        }
    }


}
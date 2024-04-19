public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    private class MyNode<E> {
        private E data;
        private MyNode<E> next;
        private MyNode<E> prev;
        public MyNode(E data) {
            this.data = data;
            next = null;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private void makeLink(MyNode<T> a, MyNode<T> b) {
        if(a != null) {
            a.next = b;
        }
        if(b != null) {
            b.prev = a;
        }
    }

    private void makeNull(MyNode<T> a) {
        a.next = a.prev = null;
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);

        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else{
            makeLink(tail, newNode);
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index > size - 1) {
        }
        else {
            MyNode<T> current = head;
            for (int i = 0; i < index; i++)
                current = current.next;

            current.data = item;
        }
    }

    @Override
    public void add(int index, T item) {
        if(index == size) {
            add(item);
        }
        else{
            checkIndex(index);
            MyNode<T> newNode = new MyNode<>(item);
            MyNode<T> current = head;
            for(int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            makeLink(newNode, current.next);
            makeLink(current, newNode);
        }
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        MyNode<T> current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        MyNode<T> current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        makeLink(current.prev, current.next);
        makeNull(current);
        size--;
    }

    @Override
    public void removeFirst() {
    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {
        Object[] objects = toArray();
        bubbleSort(objects);
        clear();
        for(var i : objects)
            add((T) i);
    }

    private void bubbleSort(Object[] objects) {
        int temp = 0;
        boolean swapped = false;
        for(int i = 0; i < objects.length - 1; i++) {
            for(int j = 0; j < objects.length - i - 1; j++) {
                temp = (int) objects[j];
                objects[j] = objects[j + 1];
                objects[j + 1] = temp;
                swapped = true;
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0 ;
    }

    @Override
    public int size() {
        return size;
    }
}
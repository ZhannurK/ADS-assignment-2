public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    private static class MyNode<E> {
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
        a.next = null;
        a.prev = null;
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);

        if (head == null) {
            head = newNode;
        }
        else{
            makeLink(tail, newNode);
        }
        tail = newNode;
        size++;
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
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
            size++;
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
        checkIndex(0);
        if (size == 1){
            head = null;
            size = 0;
        }
        else {
            head = head.next;
            size--;
        }
    }

    @Override
    public void removeLast() {
        checkIndex(size - 1);
        if (size == 0){
            head = null;
        }
        else if (size == 1) {
            head = tail = null;
            size = 0;
        }
        else {
            tail = tail.prev;
            size--;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort() {
        if (size <= 1) {
            return;
        }
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            MyNode<T> current = head;
            for (int i = 0; i < size - 1; i++) {
                if (((Comparable<T>) current.data).compareTo(current.next.data) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        if (head.data == object) {
            return 0;
        }
        else if (tail.data   == object) {
            return size - 1;
        }
        else {
            MyNode<T> current = head;
            int index = 0;
            while (current != tail) {
                if (current.data == object)
                    return index;
                current = current.next;
                index++;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        int index = -1;
        MyNode<T> current = tail;
        for (int i = 0; i < size; i++) {
            if (current.data == object)
                index = i;
            current = current.prev;
        }
        return index;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = head.data;
        }
        return newArray;
    }


    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0 ;
    }

    @Override
    public int size() {
        return size;
    }
}
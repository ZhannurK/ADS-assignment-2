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
        if (size == 0){
            head = null;
        }
        else {
            head = head.next;
            size--;
        }
    }

    @Override
    public void removeLast() {
        if (size == 0){
            head = null;
        }
        else if (size == 1) {
            head = tail = null;
            size = 0;
        }
        else {
            MyNode<T> current = head;

            for (int i = 0; i < size - 2; i++)
                current = current.next;

            tail = current;
            tail.next = null;
            size--;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort() {
        Object[] objects = toArray();
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < objects.length - 1; i++) {
                if ((int) objects[i] > (int) objects[i + 1]) {
                    Object temp = objects[i];
                    objects[i] = objects[i + 1];
                    objects[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        clear();
        for (Object obj : objects) {
            add((T) obj);
        }
    }


    @Override
    public int indexOf(Object object) {
        if (head.next == object) {
            return 0;
        }
        else if (tail.next == object) {
            return size - 1;
        }
        else {
            MyNode<T> current = head;
            int index = 0;
            while (true) { // current != null
                if (current.next == object)
                    return index;
                current = current.next;
                index++;
            }
        }
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = -1;
        MyNode<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.next == object)
                index = i;
            current = current.next;
        }
        return index;
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
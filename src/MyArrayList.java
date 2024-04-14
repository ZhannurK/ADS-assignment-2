public class MyArrayList<T> implements MyList<T> {
    private Object[] arr;
    private int size;


    public MyArrayList() {
        arr = new Object[10];
        size = 0;
    }

    @Override
    public void add(Object object) {
        arr[size] = object;
        size += 1;
    }

    @Override
    public void add(int index, Object object) {
        arr[index] = object;
        size += 1;
    }

    @Override
    public void set(int index, T item) {
    }

    @Override
    public void addFirst(T item) {
    }

    @Override
    public void addLast(T item) {
    }

    public T get(int index) {
        return (T) arr[index];
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        arr[index] = null;
        size -= 1;
    }

    @Override
    public void removeFirst() {
    }

    @Override
    public void removeLast() {
    }

    @Override
    public void sort() {
    }

    @Override
    public void clear() {
        arr = new Object[size];
        size = 0;
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

}
public class MyArrayList<T> implements MyList<T> {
    private Object[] arr;
    private int size;


    public MyArrayList() {
        arr = new Object[10];
        size = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void add(Object object) {
        if (size >= arr.length) {
            T[] bigger = (T[]) new Object[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                bigger[i] = (T) arr[i];
            }
            arr = bigger;
        }
        arr[size] = object;
        size++;
    }

    @Override
    public void add(int index, Object object) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        add(object);
        for (int i = size - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = object;
    }

    @Override
    public void set(int index, T item) {
        arr[index] = item;
        size += 1;
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
    @SuppressWarnings("unchecked")
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
        T element = get(index);
        for (int i=index; i<size-1; i++) {
            arr[i] = arr[i+1];
        }
        size--;
    }

    @Override
    public void removeFirst() {
        arr[0] = null;
        size -= 1;
    }

    @Override
    public void removeLast() {
        arr[size - 1] = null;
        size -= 1;
    }

    @Override
    public void sort() {

    }

    @Override
    public void clear() {
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
        Object[] newArray = new Object[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = arr[i];
        }
        return newArray;
    }

}
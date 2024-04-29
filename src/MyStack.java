public class MyStack<T> {
    private int top;
    private final int size;
    private final MyArrayList<T> stack;

    public MyStack() {
        top = -1;
        size = 0;
        this.stack = new MyArrayList<>();
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return size;
    }

    public void push(T item) {
        if (top == size - 1) {
            System.out.println("Stack is full");
            return;
        }
        top++;
        stack.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        T item = stack.getLast();
        top--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stack.getLast();
    }

    public void clearStack(){
        top = -1;
    }
}
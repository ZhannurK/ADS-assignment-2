public class MyStack<T> {
    private int top;
    private final int size;
    private T[] stack;

    public MyStack() {
        top = -1;
        size = 0;
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
        stack[top] = item;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        T item = stack[top];
        top--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stack[top];
    }

    public void clearStack(){
        top = -1;
    }

    public int search(Object object) {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        for (int i = 0; i < stack.length; i++) {
            if (stack[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }
}
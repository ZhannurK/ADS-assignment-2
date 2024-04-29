public class Main {
    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
        testStack();
        testQueue();
        testMinHeap();
    }

    public static <T> void printList(MyList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    private static void testStack(){
        MyStack<Integer> stack = new MyStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        stack.push(60);
        stack.push(70);

        System.out.println("Top element after pop: " + stack.peek());
        System.out.println("Size of stack: " + stack.size());
        System.out.println("Is stack empty? " + stack.isEmpty());

        stack.clearStack();
        System.out.println("Is stack empty after clear? " + stack.isEmpty());

        System.out.println("Popped element from empty stack: " + stack.pop());
        System.out.println("Top element from empty stack: " + stack.peek());
        System.out.println("Size of empty stack: " + stack.size());
        System.out.println("Is empty stack empty? " + stack.isEmpty());
    }

    private static void testQueue() {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Front element: " + queue.peek());

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());

        queue.enqueue(60);
        queue.enqueue(70);

        System.out.println("Front element after dequeue: " + queue.peek());

        System.out.println("Size of queue: " + queue.size());
        System.out.println("Is queue empty? " + queue.isEmpty());

        if (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                System.out.println("Dequeued element: " + queue.dequeue());
            }
        } else {
            System.out.println("Queue is empty. No elements to dequeue.");
        }

        System.out.println("Front element from empty queue: " + queue.peek());
        System.out.println("Size of empty queue: " + queue.size());
        System.out.println("Is empty queue empty? " + queue.isEmpty());
    }


    private static void testMinHeap(){
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();

        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(15);
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(5);

        System.out.println("Extracted min: " + minHeap.extractMin());

        System.out.println("Minimum element: " + minHeap.getMin());

        System.out.println("Size of heap: " + minHeap.size());
        System.out.println("Is heap empty? " + minHeap.isEmpty());

        while (!minHeap.isEmpty()) {
            System.out.println("Extracted min: " + minHeap.extractMin());
        }

        System.out.println("Extracted min from empty heap: " + minHeap.extractMin());
        System.out.println("Minimum element from empty heap: " + minHeap.getMin());
        System.out.println("Size of empty heap: " + minHeap.size());
        System.out.println("Is empty heap empty? " + minHeap.isEmpty());
    }

    private static void testArrayList() {
        MyList<Integer> arrayList = new MyLinkedList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.print("ArrayList: ");
        printList(arrayList);

        arrayList.add(1, 5);
        System.out.print("ArrayList after adding 5 at index 1: ");
        printList(arrayList);

        arrayList.set(2, 10);
        System.out.print("ArrayList after setting 10 at index 2: ");
        printList(arrayList);

        arrayList.remove(2);
        System.out.print("ArrayList after removing element at index 2: ");
        printList(arrayList);

        System.out.println("Index of 10: " + arrayList.indexOf(10));
        System.out.println("Does 5 exist: " + arrayList.exists(5));

        arrayList.removeFirst();
        System.out.print("ArrayList after removing first element: ");
        printList(arrayList);

        arrayList.removeLast();
        System.out.print("ArrayList after removing last element: ");
        printList(arrayList);

        arrayList.clear();
        System.out.print("ArrayList after clear: ");
        printList(arrayList);
    }

    private static void testLinkedList() {
        MyList<String> linkedList = new MyLinkedList<>();

        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");
        System.out.print("LinkedList: ");
        printList(linkedList);

        linkedList.add(1, "Mango");
        System.out.print("LinkedList after adding Mango at index 1: ");
        printList(linkedList);

        linkedList.set(2, "Grapes");
        System.out.print("LinkedList after setting Grapes at index 2: ");
        printList(linkedList);

        linkedList.remove(0);
        System.out.print("LinkedList after removing element at index 0: ");
        printList(linkedList);

        System.out.println("Index of Mango: " + linkedList.indexOf("Mango"));
        System.out.println("Does Banana exist: " + linkedList.exists("Banana"));

        linkedList.clear();
        System.out.print("LinkedList after clear: ");
        printList(linkedList);
    }
}
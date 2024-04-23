import java.util.Scanner;

public class Main {
    public static <T> void printList(MyList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
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

        arrayList.remove(0);
        System.out.print("ArrayList after removing element at index 0: ");
        printList(arrayList);

        System.out.println("Index of 10: " + arrayList.indexOf(10));
        System.out.println("Does 5 exist: " + arrayList.exists(5));

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
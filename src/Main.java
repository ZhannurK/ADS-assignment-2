import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final MyList<Integer> ls = new MyLinkedList<>();

    private static void testAdd(){
        System.out.println("To add element index and item, -1 otherwise:");
        int index = scanner.nextInt();
        if(index != -1){
            int item = scanner.nextInt();
            ls.add(index, item);
        }
    }

    private static void testPrint(){
        System.out.print("Ls elements: ");
        var a = ls.toArray();
        for(var i : a)
            System.out.print(i + " ");
        System.out.println();
    }

    private static void test(){
        while(true) {
            testAdd();
            testPrint();
        }
    }

    public static void main(String[] args) {
        test();
    }
}
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LList<Integer> list = new LList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(1);

        System.out.println(list.isPalindrome());

        enum colors {
            red , green, blue
        }

        System.out.println(colors.blue);


        //init(list);
       // list.printList();
//        list.reverseList();;
//        list.printList();

//
//        LinkedList<Integer> list1 = new LinkedList<>();
//        Integer test = list1.
//        System.out.println();


    }

    public static void init(LList<Integer> list){
        list.head = new Node<Integer>(1);
        list.head.next = new Node<Integer>(5);
        list.head.next.next = new Node<Integer>(-3);
        list.head.next.next.next = new Node<Integer>(2);
        list.head.next.next.next.next = new Node<Integer>(4);

    }
}
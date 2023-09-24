import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
//        LList<Integer> list = initRandomLinkList();
//        LList<Integer> copyList = getCopyWithrandom(list);
//        copyList.printList();

        CircularSortedList<Integer> list = new CircularSortedList<>();
        list.insert(4);
        list.insert(-1);
        list.insert(6);
        list.insert(5);
        list.insert(2);
        list.insert(5);
        list.insert(9);
        list.insert(0);
        list.printList();

    }

    public static LList<Integer> initRandomLinkList(){
        LList<Integer> list = new LList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        Node<Integer> one = list.head;
        Node<Integer> two = list.head.next;
        Node<Integer> three = list.head.next.next;
        Node<Integer> four = list.head.next.next.next;

        one.random = three;
        two.random= one;
        three.random = three;
        four.random = three;
        return list;
    }
    public static void init(LList<Integer> list){
        list.head = new Node<Integer>(1);
        list.head.next = new Node<Integer>(5);
        list.head.next.next = new Node<Integer>(-3);
        list.head.next.next.next = new Node<Integer>(2);
        list.head.next.next.next.next = new Node<Integer>(4);

    }


    public static LList<Integer> getCopyWithrandom(LList<Integer> list){
        // 1. Create a copy of every node in the list itself
        Node<Integer> temp = list.head;
        while(temp != null){
            Node<Integer> copyNode = new Node<>(temp.data);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
        // 2. copyNode.random = origNode.random.next
        Node<Integer> orig = list.head;
        Node<Integer> copy = list.head.next;

        while(orig != null){
            copy.random = orig.random.next;
            orig = orig.next.next;
            if(orig == null){
                break;
            }
            copy = copy.next.next;
        }

        // 3. Break the list

        Node<Integer> copyHead = list.head.next;
        orig = list.head;
        copy = list.head.next;
        while(orig != null){
            orig.next = orig.next.next;
            if(orig == null) {
                break;
            }
            if(copy.next == null){
                break;
            }
            copy.next = copy.next.next;
            orig = orig.next;
            copy = copy.next;

        }
        LList<Integer> copyList = new LList<>();
        copyList.head = copyHead;
        return copyList;
    }
}
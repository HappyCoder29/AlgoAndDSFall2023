import java.util.Comparator;

public class CircularSortedList<T extends Comparable<T>> implements Comparator<T> {

    public Node<T> head;
    public Node<T> tail;
    public int length;
    public CircularSortedList(){
        head = null;
        tail = null;
        length = 0;
    }

    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }

    public void insert(T data){
        Node<T> add = new Node<>(data);
        length ++;
        if(head == null){
            add.next = add;
            head = add;
            tail = add;
            return;
        }
        // add node which is smaller than head
        if(add.data.compareTo(head.data) <= 0){
            add.next = head;
            tail.next = add;
            head = add;

            return;
        }
        if(tail.data.compareTo(add.data) < 0){
            add.next = head;
            tail.next = add;
            tail = add;
            return;
        }
        Node<T> temp = head;
        while(temp.next.data.compareTo(add.data) <0){
            temp = temp.next;
        }
        add.next = temp.next;
        temp.next = add;
    }

    public void printList(){
        if(head == null){
            System.out.println("[]");
            return;
        }
        if(head == tail){
            System.out.print("[");
            System.out.print(head.data + ",");
            System.out.println("]");
            return;
        }
        System.out.print("[");

        Node<T> temp = head;
        while(temp != tail){
            System.out.print(temp.data + ",");
            temp = temp.next;
        }
        System.out.println("]");
    }

    public int count(Node<T> node){
        return 0;
    }

    public Node<T> getIntersection(Node<T> first, Node<T> second){
        int len1 = count(first);
        int len2 = count(first);
        Node<T> temp1 = first;
        Node<T> temp2 = second;
        if(len1 > len2){
            for(int i = 0 ; i < len1-len2 ; i ++){
                temp1 = temp1.next;
            }
        }
        if(len2 > len1){
            for(int i = 0 ; i < len2-len1 ; i ++){
                temp2 = temp2.next;
            }
        }

        while(temp1 != null || temp2 != null){
            if(temp1 == temp2){
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return  null;



    }
}

import java.util.Comparator;
import java.util.Stack;

class LList <T extends Comparable<T>> implements Comparator<T>{
    public Node<T> head;
    public Node<T> tail;
    public int length;
    public LList(){
        head = null;
        tail = null;
        length = 0;
    }
    public void printList(){
        System.out.print("[");
        Node<T> temp = head;
        while(temp != null){
            System.out.print(temp.data + ",");
            temp = temp.next;
        }
        System.out.println("]");
    }

    public void printList(Node<T> node){
        System.out.print("[");
        Node<T> temp = node;
        while(temp != null){
            System.out.print(temp.data + ",");
            temp = temp.next;
        }
        System.out.println("]");
    }

    public void add(T data){

        Node<T> addNode = new Node<>(data);
        addNode.next = head;
        head = addNode;
        if(head.next == null){
            tail = head;
        }
        length ++;
    }

    public void append(T data){
        Node<T> addNode = new Node<>(data);
        length ++;
        if(head == null){
            head = addNode;
            return;
        }
        Node<T> temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = addNode;
    }

    public T get(int index){
        if(index <0 || head == null){
            try {
                throw new Exception("Index Less than 0 or head is null");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        int count = 0;
        Node<T> temp = head;
        while(temp.next != null && count < index){
            temp = temp.next;
            count++;
        }
        if(count != index){
            try {
                throw new Exception("Index is more than number of elements in list");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return temp.data;
    }

    public Node<T> getNthNode(int n){
        if(n <0 || head == null){
            try {
                throw new Exception("Index Less than 0 or head is null");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        int count = 0;
        Node<T> temp = head;
        while(temp.next != null && count < n-1){
            temp = temp.next;
            count++;
        }
        if(count != n-1){
            try {
                throw new Exception("Index is more than number of elements in list");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return temp;
    }


    public Integer size(){
        Integer count = 0 ;
        Node<T> temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public T getNthFromTheEnd(Integer n){
        if(n <1 || head == null){
            try {
                throw new Exception("N Less than 1 or head is null");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        Node<T> front = head;
        Node<T> back = head;
        for(int i = 0 ; i < n; i ++){
            front = front.next;
            if(front == null){
                return (i == n-1) ? back.data : null;
            }
        }
        while(front != null){
            front = front.next;
            back = back.next;
        }
        return back.data;
    }

    public Node<T> getNthNodeFromTheEnd(Integer n){
        if(n <1 || head == null){
            return null;
        }
        Node<T> front = head;
        Node<T> back = head;
        for(int i = 0 ; i < n; i ++){
            front = front.next;
            if(front == null){
                return (i == n-1) ? back : null;
            }
        }
        while(front != null){
            front = front.next;
            back = back.next;
        }
        return back;
    }

    public void removeNthFromEnd(Integer n){
        if(n <1 || head == null){
            return;
        }
        Node<T> prev = getNthNodeFromTheEnd(n+1);
        if(prev == null){
            return;
        }
        if(prev == head){
            head = head.next;
            prev = null;
            return;
        }
        Node<T> remove = prev.next;
        prev.next = prev.next.next;
        remove = null;

    }

    public void reverseList(){
        if(head == null || head.next == null){
            return;
        }
        Node<T> back = null;
        Node<T> mid = head;
        Node<T> front = head.next;

        while(front != null){
            mid.next = back;
            back = mid;
            mid = front;
            front = front.next;
        }
        mid.next = back;
        tail = head;
        head = mid;

    }

    public Node<T> reverseList(Node<T> node){
        if(node == null || node.next == null){
            return node;
        }
        Node<T> back = null;
        Node<T> mid = node;
        Node<T> front = node.next;

        while(front != null){
            mid.next = back;
            back = mid;
            mid = front;
            front = front.next;
        }
        mid.next = back;
        return  mid;
    }


    public void reverseNFromNode(Node<T> prev, Node<T> node, int n){
        if(node == null || node.next == null || n < 2 ){
            return;
        }
        Node<T> back = prev;
        Node<T> mid = node;
        Node<T> front = node.next;

        for(int i = 0; i < n-1; i ++){
            if(front == null && i < n-1){
                return;
            }
            mid.next = back;
            back = mid;
            mid = front;
            front = front.next;
        }
        mid.next = back;
        if(prev != null){
            prev.next = mid ;
        }
        node.next = front ;
    }

    public boolean hasCycle() {
        if (head == null || head.next == null) {
            return false;
        }
        Node<T> front = head;
        Node<T> back = head;
        while(front != null && front.next != null){
            front = front.next.next;
            back = back.next;
            if(front == back) {
                return true;
            }
        }
        return  false;

    }

    public Node<T> findStartOfCycle(){
        if (head == null || head.next == null) {
            return null;
        }
        Node<T> front = head;
        Node<T> back = head;
        while(front != null && front.next != null){
            front = front.next.next;
            back = back.next;
            if(front == back) {
                break;
            }
        }
        if(front == null || front.next == null){
            return null;
        }

        // There is a cycle
        front = head;
        while(front != back){
            front = front.next;
            back = back.next;
        }

        return front;

    }

    public void breakTheCycle(){
        if (head == null || head.next == null) {
            return ;
        }
        Node<T> front = head;
        Node<T> back = head;
        while(front != null && front.next != null){
            front = front.next.next;
            back = back.next;
            if(front == back) {
                break;
            }
        }
        if(front == null || front.next == null){
            return;
        }

        // There is a cycle
        Node<T> temp = back;
        front = head.next;
        back = back.next;

        while(front != back){
            front = front.next;
            back = back.next;
            temp = temp.next;
        }
        temp.next = null;

    }

    public Node<T> breakListInHalf(){
        if(head == null || head.next == null){
            return null;
        }
        Node<T> front = head;
        Node<T> back = head;
        while(front != null){
            front = front.next;
            if(front.next == null){
                break;
            }

            front = front.next;
            back = back.next;
        }
        Node<T> temp = back.next;
        back.next = null;
        return temp;

    }

    public Node<T> getLastNode(Node<T> node){
        if(node == null || node.next == null){
            return node;
        }
        Node<T> temp = node;
        while(temp.next != null){
            temp = temp.next;
        }
        return temp;
    }

    public boolean isPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        Node<T> secondHalf = breakListInHalf();
        Node<T> lastNode = getLastNode(head);
        secondHalf = reverseList(secondHalf);


        Node<T> first = head;
        Node<T> second = secondHalf;
        boolean palindrome = true;
        while(first != null && second != null){
            if(first.data != second.data){
                palindrome = false;
                break;
            }
            first = first.next;
            second = second.next;
        }
        secondHalf = reverseList(secondHalf);
        lastNode.next = secondHalf;
        return palindrome;

    }

    public void zipMerge(){
        if(head == null || head.next == null || head.next.next == null){
            return;
        }

        Node<T> secondHalf = breakListInHalf();
        secondHalf =  reverseList(secondHalf);

        head = zipMerge(head, secondHalf, true);

    }

    public Node<T> mergeTwoSortedList(Node<T> node1, Node<T> node2){
        Node<T> result = null;
        if(node1 == null){
            return node2;
        }
        if(node2 == null){
            return node1;
        }
        if(node1.data.compareTo(node2.data) <= 0){
            result = node1;
            result.next = mergeTwoSortedList(node1.next, node2);
        }else{
            result = node2;
            result.next = mergeTwoSortedList(node1, node2.next);
        }
        return result;
    }

    private Node<T> zipMerge(Node<T> node1, Node<T> node2, boolean bSwitch){
        Node<T> result = null;
        if(node1 == null){
            return node2;
        }
        if(node2 == null){
            return node1;
        }
        if(bSwitch){
            result = node1;
            result.next = zipMerge(node1.next, node2, false);
        }else{
            result = node2;
            result.next = zipMerge(node1, node2.next, true);
        }
        return result;
    }

    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }

    public void reverseInGroupOfK(int k){
        if(head == null || head.next == null){
            return;
        }
        if(k >= length){
            reverseList();
        }
        Node<T> back = head;
        Node<T> front = head;
        Stack<T> stack = new Stack<>();
        while(front != null){
            for(int i = 0 ; i < k; i ++){
                stack.push(front.data);
                front = front.next;
                if(front == null){
                    break;
                }
            }
            while(!stack.isEmpty()){
                back.data = stack.pop();
                back = back.next;
            }
        }
        while(!stack.isEmpty()){
            back.data = stack.pop();
            back = back.next;
        }
    }

    public void rotateList(int k){
        k = k%length;
        reverseList();
        Node<T> kThNode = getNthNode(k);
        Node<T> secondHalf = kThNode.next;
        kThNode.next = null;
        Node<T> firstHalf = head;
        firstHalf = reverseList(firstHalf);
        secondHalf = reverseList(secondHalf);

        Node<T> temp = firstHalf;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = secondHalf;
        head = firstHalf;
    }
}

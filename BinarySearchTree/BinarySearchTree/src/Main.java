import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BST<Integer> bst = new BST<>();
        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);
        bst.insert(14);
        bst.insert(4);
        bst.insert(7);
        bst.insert(13);
        bst.levelOrder();
        bst.preOrder();
        bst.inOrder();
        bst.postOrder();
        bst.reverseInOrder();
        System.out.println(bst.search(14));
        System.out.println(bst.search(2));
        ArrayList<Integer> list = bst.getSortedList(false);
        System.out.println(Arrays.toString(list.toArray()));
        Integer[] arr = {1,2,3,4,5,6,7,8,9,10,11};
        Node<Integer> root = bst.getBalancedBSTFromSortedArray(arr);
        bst.levelOrder(root);

        ArrayList<Integer> path = bst.pathToElement(2);
        System.out.println(Arrays.toString(path.toArray()));
    }
}
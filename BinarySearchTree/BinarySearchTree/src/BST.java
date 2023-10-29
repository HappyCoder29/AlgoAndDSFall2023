import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class BST <T extends Comparable<T>> implements Comparator<T> {
    public Node<T> root;
    public BST(){
    }
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }
    public void preOrder(){
        preOrder(root);
        System.out.println();
    }
    private void preOrder(Node<T> node){
        if(node != null){
            System.out.print(node.data + ", ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    private void inOrder(Node<T> node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.data + ", ");
            inOrder(node.right);
        }
    }

    public void reverseInOrder(){
        reverseInOrder(root);
        System.out.println();
    }
    private void reverseInOrder(Node<T> node){
        if(node != null){
            reverseInOrder(node.right);
            System.out.print(node.data + ", ");
            reverseInOrder(node.left);
        }
    }

    public void postOrder(){
        postOrder(root);
        System.out.println();
    }
    private void postOrder(Node<T> node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + ", ");
        }
    }

    public void levelOrder(){
        if(root == null){
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(queue.size() != 0){
            Node<T> node = queue.remove();
            if(node != null){
                System.out.print(node.data + ", ");
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }else{
                System.out.println();
                if(queue.size() == 0){
                    break;
                }
                queue.add(null);
            }
        }
        System.out.println();
    }

    public void levelOrder(Node<T> rootNode){
        if(rootNode == null){
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(rootNode);
        queue.add(null);
        while(queue.size() != 0){
            Node<T> node = queue.remove();
            if(node != null){
                System.out.print(node.data + ", ");
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }else{
                System.out.println();
                if(queue.size() == 0){
                    break;
                }
                queue.add(null);
            }
        }
        System.out.println();
    }


    public void insert(T data){
        Node<T> node = new Node<>(data);
        if(root == null){
            root = node;
            return;
        }
        root.parent = root;
        Node<T> current = root;
        Node<T> parent = null;
        while(current != null){
            parent = current;
            if(current.data.compareTo(data) > 0){
                current = current.left;
            }else{
                current = current.right;
            }
            current.parent = parent;
        }
        if(parent.data.compareTo(data) > 0){
            parent.left = node;
        }else{
            parent.right = node;
        }
        node.parent = parent;
    }

    public boolean search(T data){
        if(root == null || data == null){
            return false;
        }
        Node<T> current = root;
        while(current != null){
            if(current.data.compareTo(data) == 0){
                return true;
            }
            else if (current.data.compareTo(data) > 0){
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public ArrayList<T> getSortedList(boolean ascending){
        ArrayList<T> list = new ArrayList<>();
        getSortedList(root, list, ascending);
        return list;
    }

    private void getSortedList(Node<T> node, ArrayList<T> list, boolean ascending){
        if(node != null){
            getSortedList(node.left, list, ascending);
            if(ascending){
                list.add(node.data);
            }else{
                list.add(0, node.data);
            }
            getSortedList(node.right, list, ascending);
        }
    }

    public T getMinValue(){
        if(root == null){
            return null;
        }
        Node<T> current = root;
        while(current.left != null){
            current = current.left;
        }
        return current.data;
    }

    public T getMaxValue(){
        if(root == null){
            return null;
        }
        Node<T> current = root;
        while(current.right != null){
            current = current.right;
        }
        return current.data;
    }

    public Node<T> getBalancedBSTFromSortedArray(T[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        if(arr.length == 1){
            return  new Node<>(arr[0]);
        }
        return getBalancedBSTFromSortedArray(0, arr.length -1, arr);
    }
    private Node<T> getBalancedBSTFromSortedArray(int start, int end, T[] arr){
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        Node<T> node = new Node<>(arr[mid]);
        node.left = getBalancedBSTFromSortedArray(start, mid-1, arr);
        node.right = getBalancedBSTFromSortedArray(mid+1, end, arr);
        return node;
    }

    public Node<T> getBalancedBSTFromBinaryTree(){
        ArrayList<T> list = getSortedList(true);
        T[] arr = (T[]) list.toArray() ;
        Arrays.sort(arr);
        return  getBalancedBSTFromSortedArray(arr);

    }

    public ArrayList<T> pathToElement(T data){
        if(root == null || data == null){
            return null;
        }
        ArrayList<T> list = new ArrayList<>();
        Node<T> current = root;
        while(current != null){
            list.add(current.data);
            if(current.data.compareTo(data) == 0){
                return list;
            }
            else if (current.data.compareTo(data) > 0){
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return new ArrayList<>();
    }

    public T lowestCommonAncestorParentNode(Node<T> node1, Node<T> node2){
        if(root == null || node1 == null || node2 == null){
            return null;
        }
        if(node1 == root || node2 == root){
            return root.data;
        }
        ArrayList<T> list1 = new ArrayList<>();
        ArrayList<T> list2 = new ArrayList<>();
        while(node1.parent != node1){
            list1.set(0, node1.data);
            node1 = node1.parent;
        }
        while(node2.parent != node2){
            list2.set(0, node2.data);
            node2 = node2.parent;
        }
        int index1 = 0;
        int index2 = 0;
        while(index1 < list1.size() && index2 < list2.size()){
            if(list1.get(index1).compareTo(list2.get(index2)) != 0){
                return list1.get(index1 -1);
            }
            index1++;
            index2++;
        }
        return null;
    }

}

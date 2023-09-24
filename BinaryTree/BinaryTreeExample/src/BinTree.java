import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinTree <T>{
    public Node<T> root;
    public BinTree(){
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

    public void levelOrderInOneLine(){
        if(root == null){
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() != 0){
            Node<T> node = queue.remove();
            System.out.print(node.data + ", ");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    public int size(){
        return size(root);
    }
    private int size(Node<T> node){
        if(node != null){
            return 1 + size(node.left) + size(node.right);
        }
        return 0;
    }

    public int height(){
        return height(root);
    }
    private int height(Node<T> node){
        if(node != null){
            return  1 + Math.max(height(node.left), height(node.right));
        }
        return 0;
    }

    public void printLeftView(){
        if(root == null){
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean isNodePrinted = false;
        while(queue.size() != 0){
            Node<T> node = queue.remove();
            if(node != null){
                if(!isNodePrinted){
                    System.out.println(node.data);
                    isNodePrinted = true;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }else{
                if(queue.size() == 0){
                    break;
                }
                queue.add(null);
                isNodePrinted = false;
            }
        }
        System.out.println();
    }
    public void printRightView(){
        if(root == null){
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Node<T> prevNode = null;
        while(queue.size() != 0){
            Node<T> node = queue.remove();
            if(node != null){
                prevNode = node;
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }else{
                System.out.println(prevNode.data);
                if(queue.size() == 0) {
                    break;
                }
                queue.add(null);
            }
        }
    }


    public void printZigZag(){
        if(root == null){
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean printLeftToRight = true;
        Stack<Node<T>> stack = new Stack<>();
        while(queue.size() != 0){
            Node<T> node = queue.remove();
            if(node != null){
                if(printLeftToRight){
                    System.out.print(node.data + ", ");
                }else{
                    stack.push(node);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }else{
                while(!stack.isEmpty()){
                    System.out.print(stack.pop().data + ", ");
                }
                System.out.println();
                printLeftToRight = !printLeftToRight;
                if(queue.size() == 0) {
                    break;
                }
                queue.add(null);
            }
        }
    }

    public void printBottomView(){
        HashMap<Integer, Node<T>> map = new HashMap<>();
        MaxMinClass maxMin = new MaxMinClass();
        printBottomView(map, root, 0, maxMin);
        map.forEach((key, value) -> {
            System.out.println("Key =" + key+ " Value = " + value.data);
        });
        System.out.println("******");
        for(int i = maxMin.min;i <= maxMin.max; i ++){
            System.out.print(map.get(i).data + ", ");
        }
        System.out.println();
    }
    public void printBottomView(HashMap<Integer, Node<T>> map, Node<T> node, int current, MaxMinClass maxMin){
        if(node != null){
            map.put(current, node);
            maxMin.max = maxMin.max < current ? current : maxMin.max;
            maxMin.min = maxMin.min > current ? current : maxMin.min;

            printBottomView(map, node.left, current-1, maxMin);
            printBottomView(map, node.right, current+1, maxMin);
        }
    }


    public void printTopView(){
        HashMap<Integer, Node<T>> map = new HashMap<>();
        MaxMinClass maxMin = new MaxMinClass();

        printTopView(map, root, 0, maxMin);

        System.out.println("******");
        for(int i = maxMin.min;i <= maxMin.max; i ++){
            System.out.print(map.get(i).data + ", ");
        }
        System.out.println();
    }
    public void printTopView(HashMap<Integer, Node<T>> map, Node<T> node, int current, MaxMinClass maxMin){
        if(node != null){
            if(!map.containsKey(current)){
                map.put(current, node);
            }
            maxMin.max = maxMin.max < current ? current : maxMin.max;
            maxMin.min = maxMin.min > current ? current : maxMin.min;

            printTopView(map, node.left, current-1, maxMin);
            printTopView(map, node.right, current+1, maxMin);
        }
    }

    public void printBoundary(){
        Stack<Node<T>> stack = new Stack<>();
        printBoundary(root, 0, 0, stack);
        while(!stack.isEmpty()){
            System.out.print(stack.pop().data + ", ");
        }
        System.out.println();
    }

    private void printBoundary(Node<T> node, int left, int right, Stack<Node<T>> stack){
        if(node != null){
            if(node.left == null && node.right == null){
                //leaf node
                System.out.print(node.data + ", ");
            }
            else if(right == 0){
                System.out.print(node.data + ", ");
            }else if( left == 0){
                stack.push(node);
            }
            printBoundary(node.left, left +1, right, stack);
            printBoundary(node.right, left, right +1, stack);

        }
    }

    public void printBoundaryReverse(){
        Stack<Node<T>> stack = new Stack<>();
        printBoundaryReverse(root, 0, 0, stack);
        while(!stack.isEmpty()){
            System.out.print(stack.pop().data + ", ");
        }
        System.out.println();
    }

    private void printBoundaryReverse(Node<T> node, int left, int right, Stack<Node<T>> stack){
        if(node != null){
            if(node.left == null && node.right == null){
                //leaf node
                stack.push(node);
            }
            else if(right == 0){
                stack.push(node);
            }else if( left == 0){
                System.out.print(node.data + ", ");
            }
            printBoundaryReverse(node.left, left +1, right, stack);
            printBoundaryReverse(node.right, left, right +1, stack);

        }
    }

    public void depthFirst(){
        if(root == null){
            return;
        }
        Stack<Node<T>> stack = new Stack<>();
        stack.add(root);
        while(stack.size() != 0){
            Node<T> node = stack.pop();
            System.out.print(node.data + ", ");
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        System.out.println();
    }

    public boolean isSameTree(Node<T> node1, Node<T> node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        return  node1.data.equals(node2.data) &&
                isSameTree(node1.left, node2.left) &&
                isSameTree(node1.right, node2.right);

    }

    public boolean isSymmetric(Node<T> node1, Node<T> node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        return  isSymmetric(node1.left, node2.left) &&
                isSymmetric(node1.right, node2.right);

    }




}

import com.sun.source.tree.BinaryTree;

public class Main {
    public static void main(String[] args) {

//        BinTree<Integer> tree = getTree();
//        tree.preOrder();
//        tree.inOrder();
//        tree.postOrder();
//        tree.levelOrder();
//        tree.levelOrderInOneLine();
//        System.out.println(tree.size());
//        System.out.println(tree.height());
//        tree.printLeftView();
//        tree.printRightView();
//        tree.printZigZag();
//
//        tree.printBottomView();
//        tree.printTopView();
//        System.out.println("***********");
//        tree.printBoundary();
//        tree.printBoundaryReverse();
//        tree.depthFirst();

        BinTree<Integer> tree = getTree();
        tree.mirrorTree();
        tree.levelOrder();


        System.out.println("Hello world!");
    }

    public static BinTree<Integer> getTree(){
        BinTree<Integer> tree = new BinTree<>();
        tree.root = new Node<>(1);

        tree.root.left = new Node<>(2);
        tree.root.right = new Node<>(3);

        tree.root.left.left = new Node<>(4);
        tree.root.left.right = new Node<>(5);
        tree.root.right.left = new Node<>(6);
        tree.root.right.right = new Node<>(7);

        tree.root.left.left.left = new Node<>(8);
        tree.root.left.right.left = new Node<>(9);
        tree.root.right.left.right = new Node<>(10);
        tree.root.right.right.right = new Node<>(11);
        return tree;



    }
}
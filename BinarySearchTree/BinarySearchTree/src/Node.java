public class Node <T>{

    public Node<T> left;
    public Node<T> right;
    public Node<T> parent;

    public T data;
    public Node(T data){
        this.data = data;
    }
}

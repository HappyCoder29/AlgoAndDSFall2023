import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityQueue<T extends Comparable<T>> implements Comparator<T> {

    private final List<T> list;
    private int heapSize;

    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }
    public PriorityQueue(){
        list = new ArrayList<>();
        heapSize = 0;
    }
    public boolean isEmpty(){
        return  heapSize == 0;
    }

    public T peek(){
        if(isEmpty()){
            return  null;
        }
        return list.get(0);
    }

    private int leftChild(int n){
        return  2*n + 1;
    }
    private int rightChild(int n){
        return  2*n + 2;
    }
    private int parent(int n){
        return  (n-1)/2;
    }

    public void insert(T data){
        list.add(data);
        heapSize ++;
        siftUp(heapSize -1);
    }
    private void siftUp(int index){
        if(index == 0){
            return;
        }
        int parent = parent(index);
        if(  list.get(index).compareTo(list.get(parent)) > 0  ){
            T temp = list.get(parent);
            list.set(parent, list.get(index));
            list.set(index, temp);
            siftUp(parent);
        }
    }

    public T delete(){
        if(isEmpty()){
            return null;
        }
        T maxValue = list.get(0);
        list.set(0, list.get(heapSize -1));
        list.remove(heapSize -1);
        heapSize --;
        siftDown(0);
        return maxValue;
    }

    private void siftDown(int index){
        int leftChild = leftChild(index);
        int rightChild = leftChild(index);

        int maxIndex;
        if(rightChild >= heapSize ){
            if(leftChild  >= heapSize){
                return;
            }
            else{
                // left child exists right child does not exist
                maxIndex = leftChild;
            }
        }
        else{
            // both left and right child exist
            if( list.get(leftChild).compareTo(list.get(rightChild)) > 0 ){
                maxIndex = leftChild;
            }else{
                maxIndex = rightChild;
            }
        }

        // at this point we have atleast one child
        if(list.get(index).compareTo(list.get(maxIndex)) < 0 ){
            T temp = list.get(maxIndex);
            list.set(maxIndex, list.get(index));
            list.set(index, temp);
            siftDown(maxIndex);
        }
    }


}

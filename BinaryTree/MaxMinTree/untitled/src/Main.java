public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.insert(100);
        priorityQueue.insert(19);
        priorityQueue.insert(36);
        priorityQueue.insert(17);
        priorityQueue.insert(3);
        priorityQueue.insert(25);
        priorityQueue.insert(1);
        priorityQueue.insert(2);
        priorityQueue.insert(7);
        priorityQueue.insert(120);
        Integer maxValue = priorityQueue.delete();


        System.out.println(priorityQueue.isEmpty());
        System.out.println(priorityQueue.peek());
        System.out.println(maxValue);




    }
}
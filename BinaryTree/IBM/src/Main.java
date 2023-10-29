import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1,-4,-5,2);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);


        List<List<Integer>> updates = Arrays.asList(Arrays.asList(2,4), Arrays.asList(1,2));
        List<Integer>  updated= getFinalData(data, updates);
        for (Integer i : updated) {
            System.out.print(i + ",");
        }
        System.out.println();

    }

    public static List<Integer> getFinalData(List<Integer> data, List<List<Integer>> updates){
        if(data== null || data.size() == 0){
            return data;
        }
        Integer[] arrayIndex = new Integer[data.size()];

        for (List<Integer> update: updates) {
            if (update.size() != 2) {
                continue;
            }
            Integer start = update.get(0);
            Integer end = update.get(1);
            if (start > end || start <= 0) {
                continue;
            }
            for (int i = start - 1; i < end ; i++) {
                data.set(i, data.get(i) * -1);
            }

            int test = Math.pow()
        }
        return data;
    }
}
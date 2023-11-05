import java.util.Arrays;
import java.util.Random;

public class Main {
    public static int RANGE = 10;
    public static void main(String[] args) {
//        int[] arr = {6,5,3,1,8,7,2,4};
//        //bubbleSort(arr);
//        //selectionSort(arr);
//        //mergeSort(arr);
//       // quickSort(arr);
//       // System.out.println(Arrays.toString(arr));
//       Integer kThLargest = findkThLargest(arr, 5);
//        System.out.println(kThLargest);

//        int[] arr = {1,2,3,4,5,6,7};
//        rotateArray(arr, 3);
//        System.out.println(Arrays.toString(arr));
//        int[] arr = {0,0,8,9,4,5,1,1,2,4,6,0,6,5,3};
//        countSort(arr, RANGE);
//        System.out.println(Arrays.toString(arr));

//        int[] arr = {6,5,3,1,8,7,2,4};
//        pancakeSort(arr);
//        System.out.println(Arrays.toString(arr));
//        int[] arr = {1,2,1,0,0,0,1,2,1,1,0,2,1,0};
//        dutchFlag(arr, 1);
//        System.out.println(Arrays.toString(arr));
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {0,2,4,6,8};
        //int[] result = mergeTwoSortedArrays(arr1, arr2);
        int[] merged = mergeTwoSortedArraysRecursive(arr1, arr2);
        System.out.println(Arrays.toString(merged));

    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // n^2
    private static void bubbleSort(int[] arr){
        for(int i = 0 ; i < arr.length -1; i ++){
            for(int j = 1 ; j < arr.length - i; j ++){
                if(arr[j] <arr[j-1]){
                    swap(arr, j, j-1);
                }
            }
        }
    }

    // n^2
    private static void  selectionSort(int[] arr){
        for(int i = 0 ; i < arr.length -1; i ++){
            int minIndex = i;
            for(int j = i +1; j < arr.length ; j ++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                swap(arr, minIndex, i);
            }
        }
    }

    private static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length -1);
    }

    // nlogn
    private static void mergeSort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start + end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid +1, end);
        // When we reach here we have individual elements
        merge(arr, start, end);
    }

    private static  void merge(int[] arr, int start, int end){
        int[] temp = new int[end-start +1];
        int i = start;
        int mid = (start +end)/2;
        int j = mid + 1;
        int index = 0;
        while(i <= mid && j <=end ){
            if(arr[i] < arr[j]){
                temp[index++] = arr[i++];
            }else {
                temp[index++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[index++] = arr[i++];
        }
        while(j <= end){
            temp[index++] = arr[j++];
        }
        // at this point temp has sorted elements
        // we copy elements from temp to original array
        i = start;
        for (int value : temp) {
            arr[i++] = value;
        }

    }

    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length -1);
    }

    private static void quickSort(int[] arr, int start, int end){
        if(start < end){
            int position = partition(arr, start, end);
            quickSort(arr,start, position -1);
            quickSort(arr, position +1, end);
        }
    }

    private static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int wall = start -1;
        for(int i = start; i < end; i ++){
            if(arr[i] < pivot){
                wall ++ ;
                swap(arr, i, wall);
            }
        }
        wall ++;
        swap(arr, wall, end);
        return wall;
    }


    public static int findkThLargest(int[] arr, int k){
        if(arr.length < k || k <= 1 ){
            return Integer.MIN_VALUE;
        }
        BoxValue<Boolean> bFound = new BoxValue<>();
        BoxValue<Integer> kThLargest = new BoxValue<>();
        bFound.value = false;
        findkThLargest(arr, 0, arr.length -1, k, bFound, kThLargest);
        return kThLargest.value;
    }

    private static void findkThLargest(int[] arr,
                                       int start,
                                       int end,
                                       int k,
                                       BoxValue<Boolean> bFound,
                                       BoxValue<Integer> kThLargest
    ){
        if(start < end && bFound.value == false){
            int position = partition(arr, start, end);
            if(position == k - 1){
               // System.out.println(arr[position]);
                bFound.value = true;
                kThLargest.value = arr[position];
                return;
            }
            findkThLargest(arr,start, position -1, k, bFound, kThLargest);
            findkThLargest(arr, position +1, end, k, bFound, kThLargest);
        }
    }

    private static void reverseArray(int[] arr, int start, int end){
        if(arr.length <=1 || start <0 || end >= arr.length || start >= end){
            return;
        }
        while(start < end){
            swap(arr, start, end);
            start ++;
            end --;
        }
    }

    private static void  rotateArray(int[] arr, int k){
        if(k <= 0 || arr == null || arr.length <= 1){
            return;
        }
        k = k % arr.length;
        reverseArray(arr, 0, arr.length -1);
        reverseArray(arr, 0, k-1);
        reverseArray(arr, k, arr.length -1);
    }

    public static void countSort(int[] arr, int RANGE){
        int[] countArr = new int[RANGE];
        for (int j : arr) {
            countArr[j] ++;
        }
        int index = 0;
        for(int i = 0 ; i < RANGE; i ++){
            while(countArr[i] > 0){
                arr[index ++] = i;
                countArr[i] --;
            }
        }
    }

    private static void pancakeSort(int[] arr){
        for(int i = 0 ; i < arr.length-1; i ++){
            int minIndex = i;
            for(int j = i +1; j < arr.length; j ++){
                if(arr[j] < arr[minIndex]){
                    minIndex =  j;
                }
            }
            reverseArray(arr, i, minIndex);
        }
    }

    public int majorityElement(int[] arr){
        if(arr == null || arr.length == 0) {
            return Integer.MIN_VALUE;
        }
        if(arr.length == 1){
            return arr[0];
        }
        int candidate = findCandidate(arr);
        int count = 0;
        for (int val : arr) {
            if(val == candidate){
                count++;
            }
        }
        return  count > arr.length ? candidate : Integer.MIN_VALUE;
    }

    public int findCandidate(int[] arr){
        int candidate = arr[0];
        int count = 1;
        for(int i = 1; i < arr.length; i ++){
            if(arr[i] == candidate){
                count ++;
            }else{
                count--;
                if(count == 0){
                    candidate = arr[i];
                    count = 1;
                }
            }
        }
        return candidate;
    }


    public static void dutchFlag(int[] arr, int pivot){
        if(arr == null || arr.length <= 1 ){
            return;
        }
        int low = 0;
        int mid = 0;
        int high = arr.length -1;
        while(mid < high){
            if(arr[mid] <  pivot){
                swap(arr, mid++, low++);
            }
            else if (arr[mid] == pivot){
                mid++;
            }
            else{
                swap(arr, mid, high--);
            }
        }
    }

    private static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2){
        if(arr1 == null || arr1.length == 0){
            return arr2;
        }
        if(arr2 == null || arr2.length == 0){
            return arr1;
        }
        int[] result = new int[arr1.length + arr2.length];
        int index1 = 0 ;
        int index2 = 0;
        int index = 0;
        while(index1 < arr1.length && index2 < arr1.length ){
            if(arr1[index1] < arr2[index2]){
                result[index++] = arr1[index1++];
            }else{
                result[index++] = arr2[index2++];
            }
        }
        while(index1 < arr1.length){
            result[index++] = arr1[index1++];
        }
        while(index2 < arr2.length){
            result[index++] = arr2[index2++];
        }
        return result;
    }

    private static int[] mergeTwoSortedArraysRecursive(int[] arr1, int[] arr2){
        int[] merged = new int[arr1.length + arr2.length];
        mergeTwoSortedArraysRecursive(arr1, arr2, merged, 0,0,0);
        return  merged;
    }
    private static void mergeTwoSortedArraysRecursive(int[] arr1,
                                                       int[] arr2,
                                                       int[] merged,
                                                       int index1,
                                                       int index2,
                                                       int index){
        if(index == merged.length ){
            return;
        }
        if(index1 < arr1.length && index2 < arr1.length ){
            if(arr1[index1] < arr2[index2]){
                merged[index++] = arr1[index1++];
            }else{
                merged[index++] = arr2[index2++];
            }
        }
        else if (index1 < arr1.length){
            merged[index++] = arr1[index1++];
        }
        else{
            merged[index++] = arr2[index2++];
        }
        mergeTwoSortedArraysRecursive(arr1, arr2, merged, index1, index2, index);
    }

    private static boolean binSearch(int[] arr, int k){
        if(arr == null || arr.length == 0 || k < arr[0] || k > arr[arr.length -1]){
            return false;
        }
        int start = 0;
        int end = arr.length -1;
        while(start < end){
            int mid = (start + end)/2;
            if(arr[mid] == k){
                return true;
            }
            else if(arr[mid] < k){
                start = mid +1;
            }
            else{
                end = mid -1;
            }
        }
        return false;
    }
    private static boolean binSearchRecursive(int[] arr, int k){
        if(arr == null || arr.length == 0 || k < arr[0] || k > arr[arr.length -1]){
            return false;
        }
        return  binSearchRecursive(arr, k, 0, arr.length -1);
    }
    private static boolean binSearchRecursive(int[] arr, int k, int start, int end){
        if(start > end){
            return false;
        }
        int mid = (start + end)/2;
        if(arr[mid] == k){
            return true;
        }
        else if(arr[mid] < k){
            return binSearchRecursive(arr, k, start, mid-1);
        }else{
            return binSearchRecursive(arr, k, mid +1, end);
        }
    }

}
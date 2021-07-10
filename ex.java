package Search;

import java.util.Arrays;

public class ex {
    public static void main(String[] args) {
        int[] array = new int[]{100, 15, 20, 45, 60, 85, 98, 12, 65, 43};
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        System.out.println(expSearch(array, 102));
    }
    private static void quickSort(int[] array, int from, int to){
        if (from >= to) {
            return;
        }
        int div = partition(array, from, to);
        quickSort(array, from, div - 1);
        quickSort(array, div, to);
    }
    private static int partition(int[] array, int from, int to){
        int leftIndex = from;
        int rightIndex = to;
        int mid = array [from + (to - from) / 2];
        while(leftIndex <= rightIndex){
            while(array[leftIndex] < mid){
                leftIndex++;
            }
            while(array[rightIndex] > mid){
                rightIndex--;
            }
            if(leftIndex <= rightIndex){
                swap(array, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }
    private static void swap(int[] array, int index1, int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
    private static int binarSearch(int[] array, int element, int from, int to){
        int mid = from + (to - from) / 2;
        if(array[mid] == element){
            return mid;
        } else if(array[mid] > element){
            for(int i = from; i < mid - 1; i++){
                if(array[i] == element){
                    return i;
                }
            }
        } else {
            for(int i = mid + 1; i <= to; i++){
                if(array[i] == element){
                    return i;
                }
            }
        }
        return -1;
    }
    private static int expSearch(int[] array, int element){
        int border = 1;
        while(border < array.length && array[border] < element) {
            border *= 2;
        }
        if (border >= array.length) {
            return binarSearch(array, element, border / 2, array.length - 1);
        } else {
            return binarSearch(array, element, border / 2, border);
        }
    }
}

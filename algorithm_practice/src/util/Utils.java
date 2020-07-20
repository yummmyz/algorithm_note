package util;

import java.util.Arrays;

public class Utils {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr){
        System.out.println("arr="+ Arrays.toString(arr));
    }

}

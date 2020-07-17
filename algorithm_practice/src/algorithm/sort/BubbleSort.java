package algorithm.sort;

import java.util.Arrays;

/**
 * BubbleSort（冒泡排序）
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {2, 1, 4, 3, 7, 5, 6, 9, 8};
        bubbleSort(array);
    }

    private static void bubbleSort(int[] array) {
        if (array == null || array.length <= 0) return;
        System.out.println("array=" + Arrays.toString(array));
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("bubble sort=" + Arrays.toString(array));
    }


}


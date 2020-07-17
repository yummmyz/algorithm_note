package algorithm.sort;

import java.util.Arrays;

/**
 * Quick Sort(快排)
 * 参考思路：https://juejin.im/post/5b55660ee51d4519202e2003
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 5, 7, 4, 9, 8, 0, 6};
        printArray(arr);
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (arr == null || left >= right || arr.length <= 1) return;
        int mid = partition(arr, left, right);
        quickSort(arr, left, mid - 1);
        quickSort(arr, mid + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        //三值取中
        int mid = left + (right - left) / 2;

        //保证左边较小
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        //保证中间较小
        if (arr[mid] > arr[right]) {
            swap(arr, mid, right);
        }
        //保证中间比两端都小
        if (arr[mid] > arr[left]) {
            swap(arr, mid, left);
        }

        int pivot = arr[left];

        //两指针未相遇之前循环
        while (left < right) {

            while (arr[right] >= pivot && left < right) {
                right--;
            }

            if (left < right) {
                arr[left] = arr[right];
                left++;
            }

            while (arr[left] <= pivot && left < right) {
                left++;
            }

            if (left < right) {
                arr[right] = arr[left];
                right--;
            }

        }

        arr[left] = pivot;
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr){
        System.out.println("arr="+ Arrays.toString(arr));
    }

}

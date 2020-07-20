package leetcode.sort;

import util.Utils;

import java.util.PriorityQueue;

/**
 * The Kth Element
 */
public class LC215 {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = findKthLargest2(arr, k);
        System.out.println("result=" + result);
    }

    /**
     *时间复杂度 O(NlogK)，空间复杂度 O(K)
     */
    private static int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k)  // 维护堆的大小为K
                pq.poll();
        }
        return pq.peek();
    }

    /**
     * 快速选择 ：时间复杂度 O(N)，空间复杂度 O(1)
     */
    private static int findKthLargest2(int[] arr, int k) {
        k = arr.length - k;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = partition(arr, left, right);
            if (mid == k) {
                break;
            } else if (mid < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return arr[k];
    }

    private static int partition(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        if (arr[left] > arr[right]) {
            Utils.swap(arr, left, right);
        }
        if (arr[mid] > arr[right]) {
            Utils.swap(arr, mid, right);
        }
        if (arr[mid] > arr[left]) {
            Utils.swap(arr, mid, left);
        }
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
                left++;
            }
            while (left < right && arr[left] <= pivot) {
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

}

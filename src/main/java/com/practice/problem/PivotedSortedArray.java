package com.practice.problem;

public class PivotedSortedArray {

    public static int searchOnePass(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        return searchSubArray(array, low, high, key);
    }

    private static int searchSubArray(int[] array, int low, int high, int key) {

        // If element not found
        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        // If key is present in middle, then return mid
        if (array[mid] == key)
            return mid;

        // Check if left half is sorted one
        if (array[low] <= array[mid]) {
            // If the key lies withing the left range
            if (key >= array[low] && key <= array[mid]) {
                // Recursively search for the element in the subarray
                return searchSubArray(array, low, mid, key);
            } else {
                // or else search recursively
                return searchSubArray(array, mid + 1, high, key);
            }
        } else {
            // or the other half must be sorted
            if (key >= array[mid + 1] && key <= array[high]) {
                return searchSubArray(array, mid + 1, high, key);
            } else {
                return searchSubArray(array, low, mid, key);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(searchOnePass(new int[]{7, 9, 13, 17, 1, 4, 5, 6}, 4));
    }

}

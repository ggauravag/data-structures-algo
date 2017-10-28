package com.practice.problem;

public class FindMedianOfSortedArrays {

    public static double findMedian(int[] arr1, int[] arr2) {
        if (arr1.length == 1 && arr2.length == 1) {
            return (arr1[0] + arr2[0]) * 1.0 / 2;
        }

        if (arr1.length == 2 && arr2.length == 2) {
            return (Math.max(arr1[0], arr2[0]) + Math.min(arr1[1], arr2[1])) * 1.0/ 2;
        }

        double median1 = getMedian(arr1);
        double median2 = getMedian(arr2);

        if (median1 == median2)
            return median1;

        if (median1 > median2) {
            int end1 = arr1.length % 2 == 0 ? arr1.length / 2 - 1 : arr1.length / 2;
            int[] subArray1 = getSubArray(0, end1, arr1);
            int[] subArray2 = getSubArray(arr2.length / 2, arr2.length - 1, arr2);
            return findMedian(subArray1, subArray2);
        } else {
            int end2 = arr2.length % 2 == 0 ? arr2.length / 2 - 1 : arr2.length / 2;
            int[] subArray1 = getSubArray(arr1.length / 2, arr1.length - 1, arr1);
            int[] subArray2 = getSubArray(0, end2, arr2);
            return findMedian(subArray1, subArray2);
        }
    }

    private static int[] getSubArray(int start, int end, int[] array) {
        int length = end - start + 1;
        int[] subArray = new int[length];
        System.arraycopy(array, start, subArray, 0, length);
        return subArray;
    }

    private static double getMedian(int[] arr) {
        if (arr.length % 2 == 0) {
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) * 1.0 / 2;
        } else {
            return arr[arr.length / 2];
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedian(new int[]{1}, new int[]{2}));
    }

}

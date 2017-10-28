package com.practice.problem;

import java.util.Arrays;

public class FindClosestSumToK {

    public static int findClosestToZero(int[] array) {
        Arrays.sort(array);

        int low = 0;
        int high = array.length - 1;
        int closestSum = array[low] + array[high];

        while (low < high) {
            if (array[low] + array[high] > 0) {
                high--;
            } else if (array[low] + array[high] < 0) {
                low++;
            } else {
                return 0;
            }

            if (Math.abs(array[low] + array[high]) < Math.abs(closestSum)) {
                closestSum = array[low] + array[high];
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        System.out.println(findClosestToZero(new int[]{-30, 21, 5, -12, 10, 25}));
    }

}

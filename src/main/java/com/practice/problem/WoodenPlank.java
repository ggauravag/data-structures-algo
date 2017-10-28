package com.practice.problem;

public class WoodenPlank {

    private static int cost(int a, int b, int start, int markPoint, int end) {
        return a * (markPoint - start) + b * (end - markPoint);
    }

    private static int[] subArray(int[] arr, int start, int end) {
        int[] newArr = new int[end - start + 1];
        System.arraycopy(arr, start, newArr, 0, end - start + 1);
        return newArr;
    }

    private static int findCost(int a, int b, int[] cutPoints) {
        if (cutPoints.length == 2) {
            return 0;
        }

        int minCost = 99999;
        for (int i = 1; i <= cutPoints.length - 2; i++) {
            int pointCost = cost(a, b, cutPoints[0], cutPoints[i], cutPoints[cutPoints.length - 1]);
            int totalCost = findCost(a, b, subArray(cutPoints, 0, i)) + pointCost + findCost(a, b, subArray(cutPoints, i, cutPoints.length - 1));
            if (totalCost < minCost)
                minCost = totalCost;
        }

        return minCost;
    }

    public static void main(String[] args) {
        System.out.println(findCost(3, 4, new int[]{1, 3, 5, 9, 16, 22}));
    }

}

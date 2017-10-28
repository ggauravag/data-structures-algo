package com.practice.problem;

public class FindMissingNumber {

    public static int findLinear(int[] array, int n) {
        int actualSum = n * (n + 1) / 2;
        int totalSum = 0;
        for (int a : array)
            totalSum += a;

        return actualSum - totalSum;
    }

    public static int findXOR(int[] array, int n) {
        int actualXOR = 1;
        for (int i = 2; i <= n; i++) {
            actualXOR ^= i;
        }

        int totalXOR = array[0];
        for(int i = 1; i < array.length; i++) {
            totalXOR ^= array[i];
        }

        return actualXOR ^ totalXOR;
    }

    public static void main(String[] args) {
        System.out.println(findLinear(new int[]{10, 3, 6, 2, 1, 5, 8, 9, 7}, 10));
        System.out.println(findXOR(new int[]{10, 3, 6, 2, 1, 5, 8, 9, 7}, 10));
    }

}

package com.practice.algorithm;

import java.util.Arrays;
import java.util.Objects;

public class SearchUtils {
    /**
     * Runs with a complexity of O(n) for uniformly distributed sorted array
     *
     * @param array, the array to be searched for the key, must always be non-null
     * @param key,   the key to be searched, must always be non-null
     * @return index of the occurrence of the key or -1 if not found
     */
    public static int linearSearch(int[] array, int key) {
        Objects.requireNonNull(array);
        Objects.requireNonNull(key);

        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Runs with a complexity of O(log(n)) for uniformly distributed sorted array
     *
     * @param array, sorted array that is to be searched, it must not be null
     * @param key,   key to be searched in the array, it must not be null
     * @return if key is present in the array, then its index, otherwise -1
     */
    public static int binarySearch(int[] array, int key) {
        Objects.requireNonNull(array);
        Objects.requireNonNull(key);

        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            // To safely divide the numbers, without overflow error
            int mid = (low + high) >>> 1;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                low = mid + 1;
            } else if (array[mid] > key) {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Runs with a complexity of O(sqrt(n)) for uniformly distributed sorted array
     *
     * @param array, sorted array that is to be searched, it must not be null
     * @param key,   key to be searched in the array, it must not be null
     * @return if key is present in the array, then its index, otherwise -1
     */
    public static int jumpSearch(int[] array, int key) {
        Objects.requireNonNull(array);
        Objects.requireNonNull(key);

        if (array.length == 0)
            throw new IllegalArgumentException("Empty Array cannot be searched");

        if (array.length == 1) {
            return array[0] == key ? 0 : -1;
        }

        int step = (int) Math.sqrt(array.length);
        int high = step - 1;
        int low = 0;
        while (array[high] <= key) {
            // If element found then return index
            if (array[high] == key) {
                return high;
            }

            // Set low to next element of current high
            low = high + 1;
            // Increase current high according by step size
            high += step;
            // If lower end is outside array bounds, then element does not exists
            if (low >= array.length) {
                return -1;
            }

            // If the upper limit crosses array length
            if (high >= array.length) {
                high = array.length - 1;
            }
        }

        // Perform linear search for the given low to high subarray block
        for (int i = low; i <= high; i++) {
            if (array[i] == key) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Runs with a complexity of O(log(log(n)) for uniformly distributed sorted array
     *
     * @param array, sorted array that is to be searched, it must not be null
     * @param key,   key to be searched in the array, it must not be null
     * @return if key is present in the array, then its index, otherwise -1
     */
    public static int interpolationSearch(int[] array, int key) {
        Objects.requireNonNull(array);
        Objects.requireNonNull(key);

        int low = 0;
        int high = array.length - 1;

        if (array.length == 0)
            throw new IllegalArgumentException("Empty Array cannot be searched");

        if (array.length == 1) {
            return array[0] == key ? 0 : -1;
        }

        if (key < array[low] || key > array[high]) {
            return -1;
        }

        while (low <= high) {
            if (array[high] - array[low] == 0) {
                if (array[low] != key)
                    return -1;
                else
                    return low;
            }

            int pos = low + ((key - array[low]) * (high - low) / (array[high] - array[low]));
            if (array[pos] == key) {
                return pos;
            } else if (array[pos] < key) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }

        return -1;
    }

    /**
     * Runs with a complexity of O(log(n)) for uniformly distributed sorted array
     *
     * @param array, sorted array that is to be searched, it must not be null
     * @param key,   key to be searched in the array, it must not be null
     * @return if key is present in the array, then its index, otherwise -1
     */
    public static int exponentialSearch(int[] array, int key) {
        Objects.requireNonNull(array);
        Objects.requireNonNull(key);

        int high = 1;
        int low = 0;

        if (array.length == 0)
            throw new IllegalArgumentException("Empty Array cannot be searched");

        if (array.length == 1) {
            return array[0] == key ? 0 : -1;
        }

        while (low < array.length && array[high] < key) {
            // Set low to next element of current high
            low = high + 1;
            // Increase current high according by step size
            high *= 2;
            // If the upper limit crosses array length
            if (high >= array.length) {
                high = array.length - 1;
            }
        }

        // Perform binary search for the given low to high subarray block
        if (low <= high) {
            int sub[] = new int[high - low + 1];
            System.arraycopy(array, low, sub, 0, high - low + 1);
            int index = binarySearch(sub, key);
            return index == -1 ? -1 : low + index;
        }

        return -1;
    }

    public static void main(String[] args) {
        int low = (int) (Integer.MAX_VALUE * 0.99);
        int high = Integer.MAX_VALUE;
        int arr[] = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int) ((high - low) * Math.random() + low);
        }

        Arrays.sort(arr);
        for (int i = 0; i < 8; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}

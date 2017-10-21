package com.practice;

import com.practice.algorithm.SearchUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchUtilsTest {

    @Test
    public void testLinearSearch() {
        int actual = SearchUtils.linearSearch(new int[]{1, 4, 6, 7, 5}, 5);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void testLinearSearchFailure() {
        int actual = SearchUtils.linearSearch(new int[]{1, 4, 6, 7, 5}, 50);
        int expected = -1;
        assertEquals(expected, actual);
    }


    @Test
    public void testBinarySearch() {
        int actual = SearchUtils.binarySearch(new int[]{1, 4, 6, 9, 17}, 9);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void testBinarySearchSmallArray() {
        int actual = SearchUtils.binarySearch(new int[]{1, 4}, 4);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void testBinarySearchLargeArray() {
        int actual = SearchUtils.binarySearch(new int[]{1, 4, 5, 8, 19, 34, 41, 43, 53, 69}, 1);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testBinarySearchNotFound() {
        int actual = SearchUtils.binarySearch(new int[]{1, 4, 5, 8, 19, 34, 41, 43, 53, 69}, 12);
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void testBinarySearchLargeNumbers() {
        int actual = SearchUtils.binarySearch(new int[]{2129024110, 2133515702, 2136329361, 2140224197, 2141852341, 2142477098, 2146063495, 2146294698}, 2136329361);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void testJumpSearch() {
        int actual = SearchUtils.jumpSearch(new int[]{1, 4, 6, 9, 17}, 9);
        int expected = 3;
        assertEquals(expected, actual);

        actual = SearchUtils.jumpSearch(new int[]{1, 2, 3, 4, 5, 6, 7}, 7);
        expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void testJumpSearchSmallArray() {
        int actual = SearchUtils.jumpSearch(new int[]{1, 4}, 4);
        int expected = 1;
        assertEquals(expected, actual);

        actual = SearchUtils.jumpSearch(new int[]{1}, 1);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testJumpSearchLargeArray() {
        int actual = SearchUtils.jumpSearch(new int[]{1, 4, 5, 8, 19, 34, 41, 43, 53, 69}, 1);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testJumpSearchNotFound() {
        int actual = SearchUtils.jumpSearch(new int[]{1, 4, 5, 8, 19, 34, 41, 43, 53, 69}, 12);
        int expected = -1;
        assertEquals(expected, actual);

        actual = SearchUtils.jumpSearch(new int[]{1}, 14);
        expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void testJumpSearchLargeNumbers() {
        int actual = SearchUtils.jumpSearch(new int[]{2129024110, 2133515702, 2136329361, 2140224197, 2141852341, 2142477098, 2146063495, 2146294698}, 2136329361);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void testInterpolationSearch() {
        int actual = SearchUtils.interpolationSearch(new int[]{1, 4, 6, 9, 17}, 9);
        int expected = 3;
        assertEquals(expected, actual);

        actual = SearchUtils.interpolationSearch(new int[]{1, 2, 3, 4, 5, 6, 7}, 7);
        expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void testInterpolationSearchSmallArray() {
        int actual = SearchUtils.interpolationSearch(new int[]{1, 4}, 4);
        int expected = 1;
        assertEquals(expected, actual);

        actual = SearchUtils.interpolationSearch(new int[]{1}, 1);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testInterpolationSearchLargeArray() {
        int actual = SearchUtils.interpolationSearch(new int[]{1, 4, 5, 8, 19, 34, 41, 43, 53, 69}, 1);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testInterpolationSearchNotFound() {
        int actual = SearchUtils.interpolationSearch(new int[]{1, 4, 5, 8, 19, 34, 41, 43, 53, 69}, 12);
        int expected = -1;
        assertEquals(expected, actual);

        actual = SearchUtils.interpolationSearch(new int[]{1}, 14);
        expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void testInterpolationSearchLargeNumbers() {
        int actual = SearchUtils.interpolationSearch(new int[]{2129024110, 2133515702, 2136329361, 2140224197, 2141852341, 2142477098, 2146063495, 2146294698}, 2136329361);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void testExponentialSearch() {
        int actual = SearchUtils.exponentialSearch(new int[]{1, 4, 6, 9, 17}, 9);
        int expected = 3;
        assertEquals(expected, actual);

        actual = SearchUtils.exponentialSearch(new int[]{1, 2, 3, 4, 5, 6, 7}, 7);
        expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void testExponentialSearchSmallArray() {
        int actual = SearchUtils.exponentialSearch(new int[]{1, 4}, 4);
        int expected = 1;
        assertEquals(expected, actual);

        actual = SearchUtils.exponentialSearch(new int[]{1}, 1);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testExponentialSearchLargeArray() {
        int actual = SearchUtils.exponentialSearch(new int[]{1, 4, 5, 8, 19, 34, 41, 43, 53, 69}, 1);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testExponentialSearchNotFound() {
        int actual = SearchUtils.exponentialSearch(new int[]{1, 4, 5, 8, 19, 34, 41, 43, 53, 69}, 12);
        int expected = -1;
        assertEquals(expected, actual);

        actual = SearchUtils.exponentialSearch(new int[]{1}, 14);
        expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void testExponentialSearchLargeNumbers() {
        int actual = SearchUtils.exponentialSearch(new int[]{2129024110, 2133515702, 2136329361, 2140224197, 2141852341, 2142477098, 2146063495, 2146294698}, 2136329361);
        int expected = 2;
        assertEquals(expected, actual);
    }
}


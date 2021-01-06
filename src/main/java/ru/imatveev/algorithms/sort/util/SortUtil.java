package ru.imatveev.algorithms.sort.util;

public class SortUtil {
    public static void swap(int[] data, int hi, int low) {
        int mid = data[hi];
        data[hi] = data[low];
        data[low] = mid;
    }

    public static <T> void swap(T[] data, int hi, int low) {
        T mid = data[hi];
        data[hi] = data[low];
        data[low] = mid;
    }
}

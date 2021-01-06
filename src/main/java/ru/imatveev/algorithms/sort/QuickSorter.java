package ru.imatveev.algorithms.sort;

import static ru.imatveev.algorithms.sort.util.SortUtil.swap;


public class QuickSorter implements ISorter {
    @Override
    public int[] sort(int[] data) {
        partition(data, 0, data.length - 1);
        return data;
    }

    private void partition(int[] data, int left, int right) {
        int i = left;
        int j = right;
        int mid = data[(left + right) / 2];
        while (i <= j) {
            while (data[i] < mid) {
                i++;
            }
            while (mid < data[j]) {
                j--;
            }
            if (i <= j) {
                swap(data, i, j);
                i++;
                j--;
            }
        }
        if (left < j) {
            partition(data, left, j);
        }
        if (i < right) {
            partition(data, i, right);
        }
    }
}

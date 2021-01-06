package ru.imatveev.algorithms.sort;

import static ru.imatveev.algorithms.sort.util.SortUtil.swap;

public class SelectionSorter implements ISorter {
    @Override
    public int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int minIndex = findMinIndex(data, i, data.length - 1);
            swap(data, i, minIndex);
        }
        return data;
    }

    private int findMinIndex(int[] data, int begin, int end) {
        int minVal = data[begin];
        int minIndex = begin;
        for (int i = begin + 1; i <= end; i++) {
            if (data[i] < minVal) {
                minVal = data[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}

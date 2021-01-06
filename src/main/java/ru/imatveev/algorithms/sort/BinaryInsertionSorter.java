package ru.imatveev.algorithms.sort;

import static ru.imatveev.algorithms.sort.util.SortUtil.swap;

public class BinaryInsertionSorter implements ISorter {
    public int[] sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            int low = 0;
            int hi = i - 1;
            while (low < hi) {
                int mid = low + (hi - low) / 2;
                if (key < data[mid]) {
                    hi = mid;
                } else {
                    low = mid + 1;
                }
            }
            for (int j = i; j > low + 1; j--) {
                swap(data, j, j - 1);
            }
            data[low] = key;
        }
        return data;
    }
}


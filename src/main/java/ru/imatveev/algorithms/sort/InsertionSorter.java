package ru.imatveev.algorithms.sort;

import static ru.imatveev.algorithms.sort.util.SortUtil.swap;

public class InsertionSorter implements ISorter {
    public int[] sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int j = i - 1;
            int key = data[i];
            while (j >= 0 && key < data[j]) {
                swap(data, j, j + 1);
                j--;
            }
            data[j + 1] = key;
        }
        return data;
    }
}

package ru.imatveev.algorithms.sort;

import static ru.imatveev.algorithms.sort.util.SortUtil.swap;

public class BubbleSorter implements ISorter {
    @Override
    public int[] sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = data.length - 1; j >= i; j--) {
                if (data[j - 1] > data[j]) {
                    swap(data, j - 1, j);
                }
            }
        }
        return data;
    }
}

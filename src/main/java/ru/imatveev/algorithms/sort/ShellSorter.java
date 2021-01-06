package ru.imatveev.algorithms.sort;

import static ru.imatveev.algorithms.sort.util.SortUtil.swap;

public class ShellSorter implements ISorter {
    @Override
    public int[] sort(int[] data) {
        int hip = data.length / 3 + 1;
        while (hip >= 1) {
            hSort(data, hip);
            hip /= 3;
        }
        return data;
    }

    private void hSort(int[] data, int hip) {
        for (int i = hip; i < data.length; i++) {
            int j = i;
            while (j >= hip && data[j] < data[j - hip]) {
                swap(data, j, j - hip);
                j -= hip;
            }
        }
    }
}

package ru.imatveev.algorithms.sort;

import static ru.imatveev.algorithms.sort.util.SortUtil.swap;

public class ShakerSorter implements ISorter {
    @Override
    public int[] sort(int[] data) {
        int left = 0;
        int right = data.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (data[i] > data[i + 1]) {
                    swap(data, i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (data[i] < data[i - 1]) {
                    swap(data, i, i - 1);
                }
            }
            left++;
        } while (left <= right);

        return data;
    }
}

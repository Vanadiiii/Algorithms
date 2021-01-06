package ru.imatveev.algorithms.sort;

import java.util.Comparator;

import static ru.imatveev.algorithms.sort.util.SortUtil.swap;

public class ShakerSorter<T> implements ISorter<T> {
    @Override
    public T[] sort(T[] data, Comparator<T> comparator) {
        int left = 0;
        int right = data.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (comparator.compare(data[i], data[i + 1]) > 0) {
                    swap(data, i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (comparator.compare(data[i - 1], data[i]) > 0) {
                    swap(data, i, i - 1);
                }
            }
            left++;
        } while (left <= right);

        return data;
    }
}

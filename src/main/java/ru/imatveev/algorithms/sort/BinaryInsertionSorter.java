package ru.imatveev.algorithms.sort;

import java.util.Comparator;

import static ru.imatveev.algorithms.sort.util.SortUtil.swap;

public class BinaryInsertionSorter<T> implements ISorter<T> {
    @Override
    public T[] sort(T[] data, Comparator<T> comparator) {
        for (int i = 1; i < data.length; i++) {
            T key = data[i];
            int low = 0;
            int hi = i - 1;
            while (low < hi) {
                int mid = low + (hi - low) / 2;
                if (comparator.compare(data[mid], key) > 0) {
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


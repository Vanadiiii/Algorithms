package ru.imatveev.algorithms.sort;

import java.util.Comparator;

import static ru.imatveev.algorithms.sort.util.SortUtil.swap;

public class SelectionSorter<T> implements ISorter<T> {
    @Override
    public T[] sort(T[] data, Comparator<T> comparator) {
        for (int i = 0; i < data.length; i++) {
            int minIndex = findMinIndex(data, i, data.length - 1, comparator);
            swap(data, i, minIndex);
        }
        return data;
    }

    private int findMinIndex(T[] data, int begin, int end, Comparator<T> comparator) {
        T minVal = data[begin];
        int minIndex = begin;
        for (int i = begin + 1; i <= end; i++) {
            if (comparator.compare(minVal, data[i]) > 0) {
                minVal = data[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}

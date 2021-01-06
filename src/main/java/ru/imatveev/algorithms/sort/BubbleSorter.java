package ru.imatveev.algorithms.sort;

import java.util.Comparator;

import static ru.imatveev.algorithms.sort.util.SortUtil.swap;

public class BubbleSorter<T> implements ISorter<T> {
    @Override
    public T[] sort(T[] data, Comparator<T> comparator) {
        for (int i = 1; i < data.length; i++) {
            for (int j = data.length - 1; j >= i; j--) {
                if (comparator.compare(data[j - 1], data[j]) > 0) {
                    swap(data, j - 1, j);
                }
            }
        }
        return data;
    }
}

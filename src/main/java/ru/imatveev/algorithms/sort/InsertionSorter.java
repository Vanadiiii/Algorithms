package ru.imatveev.algorithms.sort;

import java.util.Comparator;

import static ru.imatveev.algorithms.sort.util.SortUtil.swap;

public class InsertionSorter<T> implements ISorter<T> {
    @Override
    public T[] sort(T[] data, Comparator<T> comparator) {
        for (int i = 1; i < data.length; i++) {
            int j = i - 1;
            T key = data[i];
            while (j >= 0 && comparator.compare(data[j], key) > 0) {
                swap(data, j, j + 1);
                j--;
            }
            data[j + 1] = key;
        }
        return data;
    }
}

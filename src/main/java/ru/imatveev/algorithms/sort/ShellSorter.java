package ru.imatveev.algorithms.sort;

import java.util.Comparator;

import static ru.imatveev.algorithms.sort.util.SortUtil.swap;

public class ShellSorter<T> implements ISorter<T> {
    @Override
    public T[] sort(T[] data, Comparator<T> comparator) {
        int hip = data.length / 3 + 1;
        while (hip >= 1) {
            hSort(data, hip, comparator);
            hip /= 3;
        }
        return data;
    }

    private void hSort(T[] data, int hip, Comparator<T> comparator) {
        for (int i = hip; i < data.length; i++) {
            int j = i;
            while (j >= hip && comparator.compare(data[j - hip], data[j]) > 0) {
                swap(data, j, j - hip);
                j -= hip;
            }
        }
    }
}

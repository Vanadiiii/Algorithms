package ru.imatveev.algorithms.sort;

import java.util.Comparator;

import static ru.imatveev.algorithms.sort.util.SortUtil.swap;

public class HeapSorter<T> implements ISorter<T> {
    @Override
    public T[] sort(T[] data, Comparator<T> comparator) {
        int size = data.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(data, size, i, comparator);
        }
        for (int i = size - 1; i >= 0; i--) {
            swap(data, i, 0);
            heapify(data, i, 0, comparator);
        }
        return data;
    }

    /**
     * @param data incoming array
     * @param size heap size
     * @param root root index of binary heap
     * @apiNote turn array to binary heap
     */
    private void heapify(T[] data, int size, int root, Comparator<T> comparator) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < size && comparator.compare(data[left], data[largest]) > 0) {
            largest = left;
        }

        if (right < size && comparator.compare(data[right], data[largest]) > 0) {
            largest = right;
        }

        if (largest != root) {
            swap(data, largest, root);
            heapify(data, size, largest, comparator);
        }
    }
}

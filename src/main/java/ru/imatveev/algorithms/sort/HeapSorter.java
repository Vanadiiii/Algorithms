package ru.imatveev.algorithms.sort;

import static ru.imatveev.algorithms.sort.util.SortUtil.swap;

public class HeapSorter implements ISorter {
    @Override
    public int[] sort(int[] data) {
        int size = data.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(data, size, i);
        }
        for (int i = size - 1; i >= 0; i--) {
            swap(data, i, 0);
            heapify(data, i, 0);
        }
        return data;
    }

    /**
     * @param data incoming array
     * @param size heap size
     * @param root root index of binary heap
     * @apiNote turn array to binary heap
     */
    private void heapify(int[] data, int size, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < size && data[left] > data[largest]) {
            largest = left;
        }

        if (right < size && data[right] > data[largest]) {
            largest = right;
        }

        if (largest != root) {
            swap(data, largest, root);
            heapify(data, size, largest);
        }
    }
}

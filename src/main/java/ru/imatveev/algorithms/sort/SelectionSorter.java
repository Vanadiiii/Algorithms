package ru.imatveev.algorithms.sort;

public class SelectionSorter implements ISorter {
    @Override
    public int[] sort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int mid = data[i];
            int k = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < mid) {
                    k = j;
                    mid = data[j];
                }
            }
            data[k] = data[i];
            data[i] = mid;
        }
        return data;
    }
}

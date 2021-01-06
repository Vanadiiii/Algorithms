package ru.imatveev.algorithms.sort;

import java.util.Comparator;

public interface ISorter<T> {
    T[] sort(T[] data, Comparator<T> comparator);
}

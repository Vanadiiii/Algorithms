package ru.imatveev.algorithms.util;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

public class TestUtil<T> {
    public static <T> boolean isSorted(T[] arr, Comparator<T> comparator) {
        if (arr == null || arr.length == 0) return true;
        for (int i = 1; i < arr.length; i++) {
            if (comparator.compare(arr[i - 1], arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] getRandom(int length) {
        return Stream.generate(() -> new Random().nextInt(10))
                .limit(length)
                .toArray(Integer[]::new);
    }
}

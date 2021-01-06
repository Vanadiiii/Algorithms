package ru.imatveev.algorithms.util;

import java.util.Random;
import java.util.stream.Stream;

public class TestUtil {
    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length == 0) return true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] getRandom(int length) {
        return Stream.generate(() -> new Random().nextInt(10))
                .limit(length)
                .mapToInt(integer -> integer)
                .toArray();
    }

    public static int[] getBest(int length) {
        return Stream.iterate(0, i -> i + 1)
                .limit(length)
                .mapToInt(integer -> integer)
                .toArray();
    }

    public static int[] getWorst(int length) {
        return Stream.iterate(length - 1, i -> i - 1)
                .limit(length)
                .mapToInt(integer -> integer)
                .toArray();
    }
}

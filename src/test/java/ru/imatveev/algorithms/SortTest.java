package ru.imatveev.algorithms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.imatveev.algorithms.sort.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.imatveev.algorithms.util.TestUtil.getRandom;
import static ru.imatveev.algorithms.util.TestUtil.isSorted;

public class SortTest {
    private static ISorter<Integer> insertionSorter;
    private static ISorter<Integer> binaryInsertionSorter;
    private static ISorter<Integer> selectionSorter;
    private static ISorter<Integer> bubbleSorter;
    private static ISorter<Integer> shakerSorter;
    private static ISorter<Integer> shellSorter;
    private static ISorter<Integer> heapSorter;

    @BeforeAll
    public static void init() {
        insertionSorter = new InsertionSorter<>();
        binaryInsertionSorter = new BinaryInsertionSorter<>();
        selectionSorter = new SelectionSorter<>();
        bubbleSorter = new BubbleSorter<>();
        shakerSorter = new ShakerSorter<>();
        shellSorter = new ShellSorter<>();
        heapSorter = new HeapSorter<>();
    }

    @Test
    void insertionSortTest() {
        test(insertionSorter);
    }

    @Test
    void binaryInsertionSortTest() {
        test(binaryInsertionSorter);
    }

    @Test
    void selectionSortTest() {
        test(selectionSorter);
    }

    @Test
    void bubbleSortTest() {
        test(bubbleSorter);
    }

    @Test
    void shakerSortTest() {
        test(shakerSorter);
    }

    @Test
    void shellSortTest() {
        test(shellSorter);
    }

    @Test
    void heapSortTest() {
        test(heapSorter);
    }

    private void test(ISorter<Integer> iSorter) {
        Comparator<Integer> comparator = Integer::compareTo;
        Stream.generate(() -> getRandom(100))
                .parallel()
                .limit(100)
                .forEach(
                        data -> assertTrue(
                                isSorted(iSorter.sort(data, comparator), comparator),
                                getMessage(data, iSorter, comparator)
                        )
                );
    }

    private <T> String getMessage(T[] data, ISorter<T> sorter, Comparator<T> comparator) {
        return "\nbefore sorting -> " + Arrays.toString(data) + '\n' +
                "after sorting  -> " + Arrays.toString(sorter.sort(data, comparator)) + '\n';
    }
}

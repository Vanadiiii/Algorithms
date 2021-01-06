package ru.imatveev.algorithms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.imatveev.algorithms.sort.*;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.imatveev.algorithms.util.TestUtil.getRandom;
import static ru.imatveev.algorithms.util.TestUtil.isSorted;

public class SortTest {
    private static ISorter insertionSorter;
    private static ISorter binaryInsertionSorter;
    private static ISorter selectionSorter;
    private static ISorter bubbleSorter;
    private static ISorter shakerSorter;
    private static ISorter shellSorter;
    private static ISorter heapSorter;
    private static ISorter quickSorter;

    @BeforeAll
    public static void init() {
        insertionSorter = new InsertionSorter();
        binaryInsertionSorter = new BinaryInsertionSorter();
        selectionSorter = new SelectionSorter();
        bubbleSorter = new BubbleSorter();
        shakerSorter = new ShakerSorter();
        shellSorter = new ShellSorter();
        heapSorter = new HeapSorter();
        quickSorter = new QuickSorter();
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

    @Test
    void quickSortTest() {
        test(quickSorter);
    }

    private void test(ISorter iSorter) {
        int length = 100;
        int count = 100;
        Stream.generate(() -> getRandom(length))
                .parallel()
                .limit(count)
                .forEach(
                        data -> assertTrue(
                                isSorted(iSorter.sort(data)),
                                getMessage(data, iSorter)
                        )
                );
    }

    private String getMessage(int[] data, ISorter sorter) {
        return "before sorting -> " + Arrays.toString(data) + '\n' +
                "after sorting -> " + Arrays.toString(sorter.sort(data)) + '\n';
    }
}

package ru.imatveev.algorithms;

import org.junit.jupiter.api.Test;
import ru.imatveev.algorithms.sort.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.imatveev.algorithms.util.TestUtil.getRandom;
import static ru.imatveev.algorithms.util.TestUtil.isSorted;

public class SortTest {
    @Test
    void insertionSortTest() {
        ISorter iSorter = new InsertionSorter();
        test(iSorter);
    }

    @Test
    void binaryInsertionSortTest() {
        ISorter iSorter = new BinaryInsertionSorter();
        test(iSorter);
    }

    @Test
    void selectionSortTest() {
        ISorter iSorter = new SelectionSorter();
        test(iSorter);
    }

    @Test
    void bubbleSortTest() {
        ISorter iSorter = new BubbleSorter();
        test(iSorter);
    }

    @Test
    void shakerSortTest() {
        ISorter iSorter = new ShakerSorter();
        test(iSorter);
    }

    private void test(ISorter iSorter) {
        Stream.iterate(0, i -> i + 1)
                .parallel()
                .limit(100)
                .map(integer -> getRandom(100))
                .forEach(data -> assertTrue(isSorted(iSorter.sort(data))));
    }
}

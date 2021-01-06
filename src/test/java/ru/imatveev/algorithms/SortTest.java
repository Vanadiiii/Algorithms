package ru.imatveev.algorithms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.imatveev.algorithms.sort.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.imatveev.algorithms.util.TestUtil.*;

public class SortTest {
    private static ISorter insertionSorter;
    private static ISorter binaryInsertionSorter;
    private static ISorter selectionSorter;
    private static ISorter bubbleSorter;
    private static ISorter shakerSorter;
    private static ISorter shellSorter;
    private static ISorter heapSorter;
    private static ISorter quickSorter;
    private static List<int[]> startArrays;

    @BeforeAll
    public static void init() {
        insertionSorter = new InsertionSorter();
        binaryInsertionSorter = new BinaryInsertionSorter();
        selectionSorter = new SelectionSorter();
        bubbleSorter = new BubbleSorter();
        shakerSorter = new ShakerSorter();
        shellSorter = new ShellSorter();
        heapSorter = new HeapSorter();
        quickSorter = new QuickRecursiveSorter();
        startArrays = createStartData(() -> getRandom(1000), 1000);
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

    private static List<int[]> createStartData(Supplier<int[]> scenario, int count) {
        return Stream.generate(scenario)
                .parallel()
                .limit(count)
                .collect(Collectors.toList());
    }

    private void test(ISorter iSorter) {
        startArrays.forEach(
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

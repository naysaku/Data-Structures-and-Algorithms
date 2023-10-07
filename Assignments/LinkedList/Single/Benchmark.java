package Single;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Benchmark {

    private static final int MAX_SIZE = 100000;
    private static final int INCREMENT = 2000;
    private static final String OUTPUT_FILE = "benchmarke_results.txt";

    public static void main(String[] args) {

        StringBuilder sizesBuilder = new StringBuilder("Sizes:\n");
        StringBuilder arrayAppendBuilder = new StringBuilder("array time:\n");
        StringBuilder linkedListAppendBuilder = new StringBuilder("Linked list time:\n");

        for (int N = 0; N <= MAX_SIZE; N += INCREMENT) {
            int[] array1 = generateArray(N);
            int[] array2 = generateArray(N);

            LinkedList list1 = generateLinkedList(N);
            LinkedList list2 = generateLinkedList(N);

            long startTime, endTime;

            // Array append Benchmark
            startTime = System.nanoTime();
            int[] appendedArray = appendArrays(array1, array2);
            endTime = System.nanoTime();
            arrayAppendBuilder.append((endTime - startTime)).append("\n");

            // Linked List append Benchmark
            startTime = System.nanoTime();
            list1.append(list2);
            endTime = System.nanoTime();
            linkedListAppendBuilder.append((endTime - startTime)).append("\n");

            sizesBuilder.append(N).append("\n");
        }

        try {
            Files.write(Paths.get(OUTPUT_FILE), (sizesBuilder.toString() + "\n" + arrayAppendBuilder.toString() + "\n"
                    + linkedListAppendBuilder.toString()).getBytes());
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    private static int[] appendArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i];
        }
        for (int j = 0; j < array2.length; j++) {
            result[array1.length + j] = array2[j];
        }
        return result;
    }

    private static int[] generateArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    private static LinkedList generateLinkedList(int size) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    static class LinkedList {
        Cell first;

        public void add(int value) {
            if (first == null) {
                first = new Cell(value, null);
            } else {
                Cell current = first;
                while (current.tail != null) {
                    current = current.tail;
                }
                current.tail = new Cell(value, null);
            }
        }

        public void append(LinkedList b) {
            Cell nxt = this.first;
            while (nxt != null && nxt.tail != null) {
                nxt = nxt.tail;
            }
            if (nxt != null) {
                nxt.tail = b.first;
            } else {
                this.first = b.first;
            }
            b.first = null;
        }

        static class Cell {
            int head;
            Cell tail;

            Cell(int head, Cell tail) {
                this.head = head;
                this.tail = tail;
            }
        }
    }
}

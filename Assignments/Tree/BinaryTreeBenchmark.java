import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BinaryTreeBenchmark {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(5, 105);
        tree.add(2, 102);
        tree.add(7, 107);
        tree.add(1, 101);
        tree.add(8, 108);
        tree.add(6, 106);
        tree.add(3, 103);

        for (int i : tree)
            System.out.println("next value " + i);

        int maxElements = 1000;

        int step = 10; // you can adjust this step size

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("benchmark_results.txt"))) {

            writer.write("size:\n");
            for (int numberOfElements = step; numberOfElements <= maxElements; numberOfElements += step) {
                writer.write(numberOfElements + "\n");
            }

            writer.write("\nadd_time:\n");
            for (int numberOfElements = step; numberOfElements <= maxElements; numberOfElements += step) {
                tree = new BinaryTree(); // reset the tree for each run

                // Measure time for adding elements
                long startTime = System.currentTimeMillis();
                for (int i = 0; i < numberOfElements; i++) {
                    tree.add(i, i);
                }
                long endTime = System.currentTimeMillis();

                // Write the result to the file
                writer.write((endTime - startTime) + "\n");
            }

            writer.write("\nlookup_time:\n");
            for (int numberOfElements = step; numberOfElements <= maxElements; numberOfElements += step) {
                // Measure time for looking up elements
                long startTime = System.currentTimeMillis();
                for (int i = 0; i < numberOfElements; i++) {
                    tree.lookup(i);
                }
                long endTime = System.currentTimeMillis();

                // Write the result to the file
                writer.write((endTime - startTime) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

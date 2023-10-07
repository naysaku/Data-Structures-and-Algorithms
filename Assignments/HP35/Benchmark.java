public class Benchmark {

    DynamicStack dynamicStack = new DynamicStack(4);
    StaticStack staticStack = new StaticStack(1024);

    public void runDynamic(int rounds) {
        long timeForThousandRuns = 0;
        long timeForOneRound = 0;
        for (int i = 0; i < rounds; i++) {
            long start = System.nanoTime();

            for (long j = 0; j < 1024; j++) {
                dynamicStack.push(0);
            }

            for (long k = 0; k < 1000; k++) {
                dynamicStack.pop();
            }

            long end = System.nanoTime();

            timeForOneRound = (end - start);
            // System.out.println("The run took: " + timeForOneRound + " ns");
            timeForThousandRuns = timeForThousandRuns + timeForOneRound;
        }
        timeForThousandRuns = timeForThousandRuns / rounds;
        System.out.println(
                "[DYNAMIC]The average time it took to run the dynamic stack is " + timeForThousandRuns + " ns");
    }

    public void runStatic(int rounds) {
        long timeForThousandRuns = 0;
        long timeForOneRound = 0;
        for (int i = 0; i < rounds; i++) {
            long start = System.nanoTime();

            for (long j = 0; j < 1023; j++) {
                staticStack.push(0);
            }

            for (long k = 0; k < 1023; k++) {
                staticStack.pop();
            }

            long end = System.nanoTime();

            timeForOneRound = (end - start);
            // System.out.println("The run took: " + timeForOneRound + " ns");
            timeForThousandRuns = timeForThousandRuns + timeForOneRound;
        }
        timeForThousandRuns = timeForThousandRuns / rounds;
        System.out
                .println("[STATIC] The average time it took to run the static stack is " + timeForThousandRuns + " ns");
    }

}

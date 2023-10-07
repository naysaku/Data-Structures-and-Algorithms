public class BenchmarkNew {

    DynamicStack dynamicStack = new DynamicStack(4);
    DStack DStack = new DStack(4);
    StaticStack staticStack = new StaticStack(1024);
    SStack SStack = new SStack();

    public void runDynamic(int rounds) {
        long timeForThousandRuns = 0;
        long timeForOneRound = 0;
        for (int i = 0; i < rounds; i++) {
            long start = System.nanoTime();

            for (long j = 0; j < 1024; j++) {
                DStack.push(0);

            }

            for (int k = 0; k < 1024; k++) {
                DStack.pop();
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
                SStack.push(0);
            }

            for (long k = 0; k < 1023; k++) {
                SStack.pop();
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

    public void runOldDynamic(int rounds) {
        long timeForThousandRuns = 0;
        long timeForOneRound = 0;
        for (int i = 0; i < rounds; i++) {
            long start = System.nanoTime();

            for (long j = 0; j < 1023; j++) {
                SStack.push(0);
            }

            for (long k = 0; k < 1023; k++) {
                SStack.pop();
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

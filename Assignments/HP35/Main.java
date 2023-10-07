public class Main {
    public static void main(String[] args) {

        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 + * + * + * + * + * + * + * +
        Item[] expr = {
                Item.Value(1),
                Item.Value(2),
                Item.Value(3),
                Item.Value(4),
                Item.Value(5),
                Item.Value(6),
                Item.Value(7),
                Item.Value(8),
                Item.Value(9),
                Item.Value(10),
                Item.Value(11),
                Item.Value(12),
                Item.Value(13),
                Item.Value(14),
                Item.Value(15),
                Item.Value(16),
                Item.Add(),
                Item.Mul(),
                Item.Add(),
                Item.Mul(),
                Item.Add(),
                Item.Mul(),
                Item.Add(),
                Item.Mul(),
                Item.Add(),
                Item.Mul(),
                Item.Add(),
                Item.Mul(),
                Item.Add(),
                Item.Mul(),
                Item.Add(),
        };

        BenchmarkNew bench = new BenchmarkNew();
        bench.runDynamic(1000);
        bench.runStatic(1000);

        Calculator calc = new Calculator(expr);
        int res = calc.run();
        System.out.println(" Calculator: res = " + res);
    }
}

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(2);
        list.append(5);

        Random rand = new Random();
        System.out.println("ee");

        for (int i = 0; i < 4; i++) {
            list.append(rand.nextInt(9));
        }

        list.display();

    }

}

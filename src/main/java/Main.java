import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Purchase purchase = new Purchase();
        purchase.printAssortment();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if ("end".equals(line)) break;
            String[] parts = line.split(" ");
            String product = parts[0];
            int count = Integer.parseInt(parts[1]);
            purchase.addPurchase(product, count);
        }
        purchase.printPurchases();
    }
}

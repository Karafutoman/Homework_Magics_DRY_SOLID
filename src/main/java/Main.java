import java.util.Scanner;


/**
 * Весь код нарушает принцип единой отвественности "каждый класс отвечает только за 1 часть функциональности программы"
 */


public class Main {

    public static void main(String[] args) {

/*  Создаём отдельный класс (Assortmentproduct) и выносим это в него
        HashMap<String, Integer> products = new HashMap<>();
        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);
*/

/*  Выносим в ранее созданный в класс (Purchase)
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : Data.products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }
        System.out.println("Введите два слова: название товара и количество. Или end");
*/
        var purchase = new Purchase();
        purchase.printPurchases();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if ("end".equals(line)) break;
            String[] parts = line.split(" ");
            String product = parts[0];
            int count = Integer.parseInt(parts[1]);
            purchase.addPurchase(product, count);
        }
/* /*  Выносим в ранее созданный в класс (Purchase)
        long sum = purchase.sum(Data.products);
        System.out.println("ИТОГО: " + sum);
*/
        purchase.printPurchases();
    }
}



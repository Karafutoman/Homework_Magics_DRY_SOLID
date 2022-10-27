import java.util.HashMap;
import java.util.Map;

public class Purchase {

/*
    private String title;
    private int count;
*/
    // Нарушение - константа цифрой, исправили магические цифры
    // protected Purchase[] purchases = new Purchase[4];


    private final Map<String, Integer> products;
    private final Map<String, Integer> purchases = new HashMap<>();



/* Конструктор не используется, можно убрать
    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }
*/

    /**
     * В конструкторе задается источник данный на этапе кодирования<br>
     * Конструктор инициализирует локальную копию ассортимента
     */
    public Purchase() {
        // Dependency Inversion Principle - в принципе сюда подходит
        // описываем интерфейс, скрывая реализацию
        Assortment dataBase = Assortmentproduct.getInstance();
        products = dataBase.getProducts();
    }

    public void addPurchase(String title, int count) {
        purchases.put(title, purchases.getOrDefault(title, 0) + count);
/* Решение через Map - поэтому часть кода не нужна.
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
*/
    }

    public void printPurchases() {
/*
        System.out.println("КОРЗИНА:");
        long sum = purchase.sum(Data.products);
        System.out.println("ИТОГО: " + sum);
*/
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (Map.Entry<String, Integer> entryMap : purchases.entrySet()) {
            System.out.println("\t" + entryMap.getKey() + " " + entryMap.getValue()
                    + " шт. в сумме " + (entryMap.getValue() * products.get(entryMap.getKey()) + " руб."));
            sum += (long) entryMap.getValue() * products.get(entryMap.getKey());
        }
        System.out.println("ИТОГО: " + sum);
    }

    /*
        private long sum(Map<String, Integer> prices) {
            long sum = 0;
            System.out.println("КОРЗИНА:");
            for (int i = 0; i < purchases.length; i++) {
                Purchase purchase = purchases[i];
                if (purchase == null) continue;
                System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * prices.get(purchase.title)) + " руб.");
                sum += purchase.count * prices.get(purchase.title);
            }
            return sum;
        }
    */
    // Выыодим на печать ассортимент и цены
    public void printShowCase() {
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }
        System.out.println("Введите два слова: название товара и количество. Или end");
    }
}
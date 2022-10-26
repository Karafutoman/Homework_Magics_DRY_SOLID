import java.util.HashMap;
import java.util.Map;

public class Purchase {
    // Внутренние переменные были c параметром протектед

/*
    private String title;
    private int count;
*/
    // Нарушение - константа цифрой, убрали магические цифры в ограничении массива
    // protected Purchase[] purchases = new Purchase[4];


    private final Map<String, Integer> products;
    private final Map<String, Integer> purchases = new HashMap<>();



/* Конструктор не несёт никакой нагрузки
    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }
*/


    public Purchase() {
        // принцип: Dependency Inversion Principle - описываем интерфейс, скрывая реализацию
        Assortment Assortment = Assortmentproduct.getInstance();
        products = Assortment.getProducts();
    }

    public void addPurchase(String title, int count) {

        purchases.put(title, purchases.getOrDefault(title, 0) + count);
/* Часть кода убрана, т.к. реализация через Map
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
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (Map.Entry<String, Integer> entryMap : purchases.entrySet()) {
            System.out.println("\t" + entryMap.getKey() + " " + entryMap.getValue()
                    + " шт. в сумме " + (entryMap.getValue() * products.get(entryMap.getKey()) + " руб."));
            sum += (long) entryMap.getValue() * products.get(entryMap.getKey());
        }
        System.out.println("ИТОГО: " + sum);
    }

    public void printAssortment() {
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }
        System.out.println("Введите два слова: название товара и количество. Или end");
    }
}
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class Assortmentproduct implements Assortment {
    public static final Assortmentproduct ASSORTMENT_PRODUCT = new Assortmentproduct();

    private static final Map<String, Integer> products = Map.ofEntries(
            entry("Хлеб", 56),
            entry("Масло", 153),
            entry("Колбаса", 211),
            entry("Пирожок", 45)
    );

    @Override
    public Map<String, Integer> getProducts() {
        return new HashMap<>(products);
    }

    // Закрываем доступ через private, чтобы не было возможности создания экземпляров
    private Assortmentproduct() {
    }

    // Используем внешний конструктор
    public static Assortmentproduct getInstance() {
        return ASSORTMENT_PRODUCT;
    }
}

package christmas.model;

import java.util.HashMap;
import java.util.Map;

public enum Menu {
    BUTTON_MUSHROOM_SOUP("양송이수프", 6000, Category.APPETIZER),
    TAPAS("타파스", 5500, Category.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, Category.APPETIZER),

    T_BONE_STEAK("티본스테이크", 55000, Category.MAIN),
    BBQ_RIB("바비큐립", 54000, Category.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, Category.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, Category.MAIN),

    CHOCO_CAKE("초코케이크", 15000, Category.DESSERT),
    ICE_CREAM("아이스크림", 5000, Category.DESSERT),

    ZERO_COKE("제로콜라", 3000, Category.BEVERAGE),
    RED_WINE("레드와인", 60000, Category.BEVERAGE),
    CHAMPAGNE("샴페인", 25000, Category.BEVERAGE);

    private final String name;
    private final int price;
    private final Category category;
    private static final Map<String, Menu> MENU_LIST = new HashMap<>();

    static {
        for (Menu menu : values()) {
            MENU_LIST.put(menu.name, menu);
        }
    }

    Menu(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public static boolean findMenu(String input) {
        return MENU_LIST.containsKey(input);
    }

    public static Menu getMenu(String input) {
        return MENU_LIST.get(input);
    }
}

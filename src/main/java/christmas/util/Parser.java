package christmas.util;

import christmas.model.Menu;
import christmas.model.OrderList;
import java.util.EnumMap;
import java.util.Map;

public class Parser {
    public static OrderList parseStringToOrderList(String input) {
        Map<Menu, Integer> orderList = new EnumMap<>(Menu.class);
        String[] orderMenus = input.split(",");

        for (String orderMenu : orderMenus) {
            String menuName = orderMenu.split("-")[0];
            String amount = orderMenu.split("-")[1];

            Menu menu = Menu.getMenu(menuName);
            orderList.put(menu, Integer.parseInt(amount));
        }
        return new OrderList(orderList);
    }
}

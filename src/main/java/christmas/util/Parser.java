package christmas.util;

import christmas.model.Menu;
import christmas.model.OrderList;
import java.util.EnumMap;
import java.util.Map;

public class Parser {
    private static final String MENU_DELIMITER = ",";
    private static final String QUANTITY_DELIMITER = "-";

    public static OrderList parseStringToOrderList(String input) {
        Map<Menu, Integer> orderList = new EnumMap<>(Menu.class);
        String[] orderMenus = input.split(MENU_DELIMITER);

        for (String orderMenu : orderMenus) {
            String menuName = orderMenu.split(QUANTITY_DELIMITER)[0];
            String quantity = orderMenu.split(QUANTITY_DELIMITER)[1];

            Menu menu = Menu.getMenu(menuName);
            orderList.put(menu, Integer.parseInt(quantity));
        }
        return new OrderList(orderList);
    }
}

package christmas.util;

import christmas.model.Menu;
import christmas.model.OrderAmount;
import christmas.model.OrderList;
import java.util.Map;

public class Calculator {
    public static OrderAmount calculateOrderAmount(OrderList orderList) {
        int orderAmount = 0;

        for (Map.Entry<Menu, Integer> orderMenu : orderList.get().entrySet()) {
            Menu menu = orderMenu.getKey();
            int amount = orderMenu.getValue();

            orderAmount += menu.getPrice() * amount;
        }
        return new OrderAmount(orderAmount);
    }
}

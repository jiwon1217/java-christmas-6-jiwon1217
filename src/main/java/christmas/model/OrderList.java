package christmas.model;

import java.util.Collections;
import java.util.Map;

public class OrderList {
    private final Map<Menu, Integer> orderList;

    public OrderList(Map<Menu, Integer> orderList) {
        this.orderList = orderList;
    }

    public Map<Menu, Integer> of() {
        return Collections.unmodifiableMap(orderList);
    }
}

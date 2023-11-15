package christmas.controller;

import christmas.model.order.OrderAmount;
import christmas.model.order.OrderInformation;
import christmas.model.order.OrderList;
import christmas.model.order.VisitDate;
import christmas.util.AmountCalculator;
import christmas.util.Parser;
import christmas.view.InputView;
import christmas.view.OutputView;

public class OrderController {
    public OrderInformation order() {
        OutputView.printGreeting();

        VisitDate visitDate = getVisitDate();
        OrderList orderList = getOrderList();

        OutputView.printBenefitPreviewInformation(visitDate);
        OutputView.printOrderList(orderList);

        OrderAmount amount = calculateOrderAmount(orderList);
        OutputView.printOrderAmount(amount);

        return new OrderInformation(visitDate, orderList, amount);
    }

    private OrderList getOrderList() {
        return Parser.parseStringToOrderList(InputView.askOrderMenu());
    }

    private VisitDate getVisitDate() {
        return new VisitDate(InputView.askVisitDate());
    }

    private OrderAmount calculateOrderAmount(OrderList orderList) {
        return AmountCalculator.calculateOrderAmount(orderList);
    }
}

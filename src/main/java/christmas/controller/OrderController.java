package christmas.controller;

import christmas.model.order.OrderAmount;
import christmas.model.order.OrderList;
import christmas.model.order.OrderInformation;
import christmas.model.order.VisitDate;
import christmas.util.AmountCalculator;
import christmas.util.Parser;
import christmas.view.InputView;
import christmas.view.OutputView;

public class OrderController {
    public OrderInformation order() {
        OutputView.printGreeting();
        VisitDate visitDate = InputView.askVisitDate();

        String orderMenu = InputView.askOrderMenu();
        OrderList orderList = Parser.parseStringToOrderList(orderMenu);

        OutputView.printBenefitPreviewInformation(visitDate);
        OutputView.printOrderList(orderList);

        OrderAmount amount = AmountCalculator.calculateOrderAmount(orderList);
        OutputView.printOrderAmount(amount);

        return new OrderInformation(visitDate, orderList, amount);
    }
}

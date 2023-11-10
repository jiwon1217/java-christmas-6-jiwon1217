package christmas.controller;

import christmas.model.OrderAmount;
import christmas.model.OrderList;
import christmas.model.PaymentInformation;
import christmas.model.VisitDate;
import christmas.util.Calculator;
import christmas.util.Parser;
import christmas.view.InputView;
import christmas.view.OutputView;

public class OrderController {
    public PaymentInformation order() {
        OutputView.printGreeting();
        VisitDate visitDate = InputView.askVisitDate();

        String orderMenu = InputView.askOrderMenu();
        OrderList orderList = Parser.parseStringToOrderList(orderMenu);

        OutputView.printBenefitPreviewInformation(visitDate);
        OutputView.printOrderList(orderList);

        OrderAmount orderAmount = Calculator.calculateOrderAmount(orderList);
        OutputView.printOrderAmount(orderAmount);

        return new PaymentInformation(visitDate, orderList, orderAmount);
    }
}

package christmas.controller;

import christmas.model.benefit.BenefitInformation;
import christmas.model.payment.PayAmount;
import christmas.model.order.OrderInformation;
import christmas.util.Calculator;
import christmas.view.OutputView;

public class PaymentController {
    public void pay(OrderInformation orderInformation, BenefitInformation benefitInformation) {
        PayAmount amount = Calculator.calculatePayAmount(orderInformation, benefitInformation);

        OutputView.printPayAmount(amount);
    }
}

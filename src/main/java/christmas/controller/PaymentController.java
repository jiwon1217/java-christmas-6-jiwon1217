package christmas.controller;

import christmas.model.BenefitInformation;
import christmas.model.PayAmount;
import christmas.model.OrderInformation;
import christmas.util.Calculator;
import christmas.view.OutputView;

public class PaymentController {
    public void pay(OrderInformation orderInformation, BenefitInformation benefitInformation) {
        PayAmount amount = Calculator.calculatePayAmount(orderInformation, benefitInformation);

        OutputView.printPayAmount(amount);
    }
}

package christmas.controller;

import christmas.model.BenefitInformation;
import christmas.model.PayAmount;
import christmas.model.PaymentInformation;
import christmas.util.Calculator;
import christmas.view.OutputView;

public class PaymentController {
    public void pay(PaymentInformation paymentInformation, BenefitInformation benefitInformation) {
        PayAmount amount = Calculator.calculatePayAmount(paymentInformation, benefitInformation);

        OutputView.printPayAmount(amount);
    }
}

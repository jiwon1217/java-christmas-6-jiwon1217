package christmas.controller;

import christmas.model.benefit.BenefitInformation;
import christmas.model.order.OrderInformation;
import christmas.model.payment.PayAmount;
import christmas.util.AmountCalculator;
import christmas.view.OutputView;

public class PaymentController {
    public void pay(OrderInformation orderInformation, BenefitInformation benefitInformation) {
        PayAmount amount = calculatePayAmount(orderInformation, benefitInformation);

        OutputView.printPayAmount(amount);
    }

    private PayAmount calculatePayAmount(OrderInformation orderInformation,
                                                BenefitInformation benefitInformation) {
        return AmountCalculator.calculatePayAmount(orderInformation, benefitInformation);
    }
}

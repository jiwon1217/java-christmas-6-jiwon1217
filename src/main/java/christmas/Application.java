package christmas;

import christmas.controller.BadgeController;
import christmas.controller.BenefitAmountController;
import christmas.controller.BenefitController;
import christmas.controller.GiveawayController;
import christmas.controller.OrderController;
import christmas.controller.PaymentController;
import christmas.model.BenefitDetails;
import christmas.model.BenefitInformation;
import christmas.model.GiveawayDetails;
import christmas.model.PayAmount;
import christmas.model.PaymentInformation;

public class Application {
    public static void main(String[] args) {
        PaymentInformation paymentInformation = new OrderController().order();

        GiveawayDetails giveawayDetails = new GiveawayController().give(paymentInformation);

        BenefitDetails benefitDetails = new BenefitController().apply(paymentInformation, giveawayDetails);

        BenefitInformation benefitInformation = new BenefitAmountController().getBenefitAmount(benefitDetails);

        PayAmount payAmount = new PaymentController().pay(paymentInformation, benefitInformation);

        new BadgeController().give(benefitInformation);
    }
}

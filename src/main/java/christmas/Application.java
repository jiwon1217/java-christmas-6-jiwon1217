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
import christmas.model.OrderInformation;

public class Application {
    public static void main(String[] args) {
        OrderInformation orderInformation = new OrderController().order();

        GiveawayDetails giveawayDetails = new GiveawayController().give(orderInformation);

        BenefitDetails benefitDetails = new BenefitController().apply(orderInformation, giveawayDetails);

        BenefitInformation benefitInformation = new BenefitAmountController().getBenefitAmount(benefitDetails);

        new PaymentController().pay(orderInformation, benefitInformation);
        new BadgeController().give(benefitInformation);
    }
}

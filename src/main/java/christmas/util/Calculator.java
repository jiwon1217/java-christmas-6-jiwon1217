package christmas.util;

import christmas.model.BenefitAmount;
import christmas.model.BenefitDetails;
import christmas.model.BenefitInformation;
import christmas.model.DiscountPolicy;
import christmas.model.Menu;
import christmas.model.OrderAmount;
import christmas.model.OrderList;
import christmas.model.PayAmount;
import christmas.model.PaymentInformation;
import java.util.Map;

public class Calculator {
    public static OrderAmount calculateOrderAmount(OrderList orderList) {
        int amount = 0;

        for (Map.Entry<Menu, Integer> orderMenu : orderList.get().entrySet()) {
            Menu menu = orderMenu.getKey();
            int quantity = orderMenu.getValue();

            amount += menu.getPrice() * quantity;
        }
        return new OrderAmount(amount);
    }

    public static BenefitAmount calculateBenefitAmount(BenefitDetails benefitDetails) {
        int amount = 0;

        for (Map.Entry<DiscountPolicy, Integer> benefit : benefitDetails.get().entrySet()) {
            amount += benefit.getValue();
        }
        return new BenefitAmount(amount);
    }

    public static PayAmount calculatePayAmount(PaymentInformation paymentInformation,
                                               BenefitInformation benefitInformation) {
        BenefitDetails benefitDetails = benefitInformation.getBenefitDetails();

        if (benefitDetails.isEmpty()) {
            return new PayAmount(paymentInformation.getOrderAmount());
        }

        int giveawayAmount = benefitDetails.get().get(DiscountPolicy.GIVEAWAY_EVENT);
        int amount =
                paymentInformation.getOrderAmount() - benefitInformation.getBenefitAmount() + giveawayAmount;

        return new PayAmount(amount);
    }
}

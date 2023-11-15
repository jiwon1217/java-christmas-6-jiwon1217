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
        int orderAmount = 0;

        for (Map.Entry<Menu, Integer> orderMenu : orderList.get().entrySet()) {
            Menu menu = orderMenu.getKey();
            int amount = orderMenu.getValue();

            orderAmount += menu.getPrice() * amount;
        }
        return new OrderAmount(orderAmount);
    }

    public static BenefitAmount calculateBenefitAmount(BenefitDetails benefitDetails) {
        int benefitAmount = 0;

        for (Map.Entry<DiscountPolicy, Integer> benefit : benefitDetails.get().entrySet()) {
            benefitAmount += benefit.getValue();
        }
        return new BenefitAmount(benefitAmount);
    }

    public static PayAmount calculatePayAmount(PaymentInformation paymentInformation,
                                               BenefitInformation benefitInformation) {
        BenefitDetails benefitDetails = benefitInformation.getBenefitDetails();

        if (benefitDetails.isEmpty()) {
            return new PayAmount(paymentInformation.getOrderAmount());
        }

        int giveawayAmount = benefitDetails.get().get(DiscountPolicy.GIVEAWAY_EVENT);
        int payAmount =
                paymentInformation.getOrderAmount() - benefitInformation.getBenefitAmount() + giveawayAmount;

        return new PayAmount(payAmount);
    }
}

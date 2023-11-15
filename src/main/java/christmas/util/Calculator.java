package christmas.util;

import christmas.model.BenefitAmount;
import christmas.model.BenefitDetails;
import christmas.model.BenefitInformation;
import christmas.model.DiscountPolicy;
import christmas.model.Menu;
import christmas.model.OrderAmount;
import christmas.model.OrderList;
import christmas.model.PayAmount;
import christmas.model.OrderInformation;
import java.util.Map;

public class Calculator {
    public static OrderAmount calculateOrderAmount(OrderList orderList) {
        int amount = 0;

        for (Map.Entry<Menu, Integer> orderMenu : orderList.of().entrySet()) {
            Menu menu = orderMenu.getKey();
            int quantity = orderMenu.getValue();

            amount += menu.getPrice() * quantity;
        }
        return new OrderAmount(amount);
    }

    public static BenefitAmount calculateBenefitAmount(BenefitDetails benefitDetails) {
        int amount = 0;

        for (Map.Entry<DiscountPolicy, Integer> benefit : benefitDetails.of().entrySet()) {
            amount += benefit.getValue();
        }
        return new BenefitAmount(amount);
    }

    public static PayAmount calculatePayAmount(OrderInformation orderInformation,
                                               BenefitInformation benefitInformation) {
        BenefitDetails benefitDetails = benefitInformation.getBenefitDetails();

        if (benefitDetails.isEmpty()) {
            return new PayAmount(orderInformation.orderAmount());
        }

        int giveawayAmount = benefitDetails.of().get(DiscountPolicy.GIVEAWAY_EVENT);
        int amount =
                orderInformation.orderAmount() - benefitInformation.getBenefitAmount() + giveawayAmount;

        return new PayAmount(amount);
    }
}

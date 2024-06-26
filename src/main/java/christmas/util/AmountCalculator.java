package christmas.util;

import christmas.model.benefit.BenefitAmount;
import christmas.model.benefit.BenefitDetails;
import christmas.model.benefit.BenefitInformation;
import christmas.model.benefit.DiscountPolicy;
import christmas.model.menu.Menu;
import christmas.model.order.OrderAmount;
import christmas.model.order.OrderInformation;
import christmas.model.order.OrderList;
import christmas.model.payment.PayAmount;
import java.util.Map;

public class AmountCalculator {

    private AmountCalculator() {
        throw new IllegalArgumentException();
    }

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
        int orderAmount = orderInformation.orderAmount();

        if (benefitDetails.isEmpty()) {
            return new PayAmount(orderAmount);
        }

        int benefitAmount = benefitInformation.getBenefitAmount();
        Integer giveawayAmount = benefitDetails.of().get(DiscountPolicy.GIVEAWAY_EVENT);

        return calculatePayAmountWithGiveaway(orderAmount, benefitAmount, giveawayAmount);
    }

    private static PayAmount calculatePayAmountWithGiveaway(int orderAmount, int benefitAmount,
                                                            Integer giveawayAmount) {
        if (giveawayAmount == null) {
            return new PayAmount(orderAmount - benefitAmount);
        }

        int totalAmount = orderAmount - benefitAmount + giveawayAmount;
        return new PayAmount(totalAmount);
    }
}

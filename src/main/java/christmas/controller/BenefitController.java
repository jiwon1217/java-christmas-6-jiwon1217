package christmas.controller;

import christmas.model.benefit.BenefitDetails;
import christmas.model.benefit.DiscountPolicy;
import christmas.model.giveaway.GiveawayDetails;
import christmas.model.order.OrderInformation;
import christmas.model.order.OrderList;
import christmas.model.order.VisitDate;
import christmas.util.BenefitCalculator;
import christmas.view.OutputView;
import java.util.EnumMap;
import java.util.Map;

public class BenefitController {
    public BenefitDetails apply(OrderInformation orderInformation, GiveawayDetails giveawayDetails) {
        int amount = orderInformation.orderAmount();
        VisitDate visitDate = orderInformation.visitDate();

        Map<DiscountPolicy, Integer> benefitInformation = new EnumMap<>(DiscountPolicy.class);
        BenefitDetails benefitDetails = new BenefitDetails(benefitInformation);

        if (benefitDetails.isPossibleBenefit(amount)) {
            applyGiveawayEvent(benefitDetails, giveawayDetails);
            applyChristmasDDayAndSpecialDiscount(visitDate, benefitDetails);
            applyWeekendOrWeekdayDiscount(visitDate, benefitDetails, orderInformation.orderList());
        }
        OutputView.printBenefitDetails(benefitDetails);

        return benefitDetails;
    }

    private void applyGiveawayEvent(BenefitDetails benefitDetails, GiveawayDetails giveawayDetails) {
        if (!giveawayDetails.isEmpty()) {
            benefitDetails.put(DiscountPolicy.GIVEAWAY_EVENT, BenefitCalculator.calculateGiveawayEvent());
        }
    }

    private void applyChristmasDDayAndSpecialDiscount(VisitDate visitDate, BenefitDetails benefitDetails) {
        applyChristmasDDayDiscount(benefitDetails, visitDate);
        applySpecialDiscount(benefitDetails, visitDate);
    }

    private void applyChristmasDDayDiscount(BenefitDetails benefitDetails, VisitDate visitDate) {
        if (visitDate.getDay() <= 25) {
            benefitDetails.put(DiscountPolicy.CHRISTMAS_D_DAY_DISCOUNT,
                    BenefitCalculator.calculateChristmasDDayDiscount(visitDate));
        }
    }

    private void applySpecialDiscount(BenefitDetails benefitDetails, VisitDate visitDate) {
        if (visitDate.isSpecialDay()) {
            benefitDetails.put(DiscountPolicy.SPECIAL_DISCOUNT, BenefitCalculator.calculateSpecialDiscount());
        }
    }

    private void applyWeekendOrWeekdayDiscount(VisitDate visitDate, BenefitDetails benefitDetails,
                                               OrderList orderList) {
        if (visitDate.isWeekend()) {
            applyWeekendDiscount(benefitDetails, orderList);
            return;
        }
        applyWeekdayDiscount(benefitDetails, orderList);
    }

    private void applyWeekendDiscount(BenefitDetails benefitDetails, OrderList orderList) {
        int amount = BenefitCalculator.calculateWeekendDiscount(orderList);

        if (amount > 0) {
            benefitDetails.put(DiscountPolicy.WEEKEND_DISCOUNT, amount);
        }
    }

    private void applyWeekdayDiscount(BenefitDetails benefitDetails, OrderList orderList) {
        int amount = BenefitCalculator.calculateWeekdayDiscount(orderList);

        if (amount > 0) {
            benefitDetails.put(DiscountPolicy.WEEKDAYS_DISCOUNT, amount);
        }
    }
}

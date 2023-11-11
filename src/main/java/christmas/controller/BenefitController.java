package christmas.controller;

import christmas.model.BenefitDetails;
import christmas.model.DiscountPolicy;
import christmas.model.GiveawayDetails;
import christmas.model.OrderAmount;
import christmas.model.OrderList;
import christmas.model.PaymentInformation;
import christmas.model.VisitDate;
import christmas.util.BenefitCalculator;
import christmas.view.OutputView;
import java.util.EnumMap;
import java.util.Map;

public class BenefitController {
    private static final int FRIDAY = 5;
    private static final int SATURDAY = 6;
    private static final int SUNDAY = 7;
    private static final int CHRISTMAS_DAY = 25;
    private static final int BENEFIT_THRESHOLD = 10_000;

    public BenefitDetails apply(PaymentInformation paymentInformation, GiveawayDetails giveawayDetails) {
        OrderAmount orderAmount = paymentInformation.orderAmount();
        VisitDate visitDate = paymentInformation.visitDate();

        Map<DiscountPolicy, Integer> benefitInformation = new EnumMap<>(DiscountPolicy.class);
        BenefitDetails benefitDetails = new BenefitDetails(benefitInformation);

        if (isPossibleBenefit(orderAmount)) {
            getGiveawayEvent(giveawayDetails, benefitDetails);
            getChristmasDDayAndSpecialDiscount(visitDate, benefitDetails);
            getWeekendOrWeekdayDiscount(visitDate, benefitDetails, paymentInformation.orderList());
        }
        OutputView.printBenefitDetails(benefitDetails);
        return benefitDetails;
    }

    private boolean isPossibleBenefit(OrderAmount orderAmount) {
        return orderAmount.orderAmount() >= BENEFIT_THRESHOLD;
    }

    private boolean isPossibleGiveawayEvent(GiveawayDetails giveawayDetails) {
        return !giveawayDetails.isEmpty();
    }

    private void getGiveawayEvent(GiveawayDetails giveawayDetails, BenefitDetails benefitDetails) {
        if (isPossibleGiveawayEvent(giveawayDetails)) {
            benefitDetails.put(DiscountPolicy.GIVEAWAY_EVENT, BenefitCalculator.calculateGiveawayEvent());
        }
    }

    private void getChristmasDDayAndSpecialDiscount(VisitDate visitDate, BenefitDetails benefitDetails) {
        getChristmasDDayDiscount(visitDate, benefitDetails);
        getSpecialDiscount(visitDate, benefitDetails);
    }

    private void getChristmasDDayDiscount(VisitDate visitDate, BenefitDetails benefitDetails) {
        benefitDetails.put(DiscountPolicy.CHRISTMAS_D_DAY_DISCOUNT,
                BenefitCalculator.calculateChristmasDDayDiscount(visitDate));
    }

    private boolean isWeekend(VisitDate visitDate) {
        return visitDate.getDayOfTheWeek() == FRIDAY || visitDate.getDayOfTheWeek() == SATURDAY;
    }

    private void getWeekendOrWeekdayDiscount(VisitDate visitDate, BenefitDetails benefitDetails,
                                             OrderList orderList) {
        if (isWeekend(visitDate)) {
            benefitDetails.put(DiscountPolicy.WEEKEND_DISCOUNT, BenefitCalculator.calculateWeekendDiscount(orderList));
            return;
        }
        benefitDetails.put(DiscountPolicy.WEEKDAYS_DISCOUNT, BenefitCalculator.calculateWeekdayDiscount(orderList));
    }

    private static boolean isSpecial(VisitDate visitDate) {
        return visitDate.getDayOfTheWeek() == SUNDAY || visitDate.getDay() == CHRISTMAS_DAY;
    }

    private void getSpecialDiscount(VisitDate visitDate, BenefitDetails benefitDetails) {
        if (isSpecial(visitDate)) {
            benefitDetails.put(DiscountPolicy.SPECIAL_DISCOUNT, BenefitCalculator.calculateSpecialDiscount());
        }
    }
}

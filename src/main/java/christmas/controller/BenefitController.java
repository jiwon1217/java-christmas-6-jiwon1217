package christmas.controller;

import christmas.model.BenefitDetails;
import christmas.model.DiscountPolicy;
import christmas.model.GiveawayDetails;
import christmas.model.VisitDate;
import christmas.util.BenefitCalculator;

public class BenefitController {
    private static final int FRIDAY = 5;
    private static final int SATURDAY = 6;

    private boolean isPossibleGiveawayEvent(GiveawayDetails giveawayDetails) {
        return !giveawayDetails.isEmpty();
    }

    private void getGiveawayEvent(GiveawayDetails giveawayDetails, BenefitDetails benefitDetails) {
        if (isPossibleGiveawayEvent(giveawayDetails)) {
            benefitDetails.put(DiscountPolicy.GIVEAWAY_EVENT, BenefitCalculator.calculateGiveawayEvent());
        }
    }

    private void getChristmasDDayDiscount(VisitDate visitDate, BenefitDetails benefitDetails) {
        benefitDetails.put(DiscountPolicy.CHRISTMAS_D_DAY_DISCOUNT,
                BenefitCalculator.calculateChristmasDDayDiscount(visitDate));
    }

    private boolean isWeekend(VisitDate visitDate) {
        return visitDate.getDayOfTheWeek() == FRIDAY || visitDate.getDayOfTheWeek() == SATURDAY;
    }
}

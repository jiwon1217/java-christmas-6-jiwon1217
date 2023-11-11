package christmas.controller;

import christmas.model.BenefitDetails;
import christmas.model.DiscountPolicy;
import christmas.model.GiveawayDetails;
import christmas.model.VisitDate;
import christmas.util.BenefitCalculator;

public class BenefitController {
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
}

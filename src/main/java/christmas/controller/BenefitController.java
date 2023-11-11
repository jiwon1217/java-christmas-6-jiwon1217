package christmas.controller;

import christmas.model.BenefitDetails;
import christmas.model.DiscountPolicy;
import christmas.model.GiveawayDetails;
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
}

package christmas.controller;

import christmas.model.GiveawayDetails;

public class BenefitController {
    private boolean isPossibleGiveawayEvent(GiveawayDetails giveawayDetails) {
        return !giveawayDetails.isEmpty();
    }
}

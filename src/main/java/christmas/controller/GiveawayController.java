package christmas.controller;

import christmas.model.GiveawayDetails;
import christmas.model.Menu;
import christmas.model.OrderAmount;

public class GiveawayController {
    private static final int GIVEAWAY_THRESHOLD = 120_000;
    private static final int GIVEAWAY_QUANTITY = 1;

    public boolean isPossibleGive(OrderAmount orderAmount) {
        return orderAmount.orderAmount() >= GIVEAWAY_THRESHOLD;
    }

    public void getGiveaway(GiveawayDetails giveawayDetails) {
        giveawayDetails.put(Menu.CHAMPAGNE, GIVEAWAY_QUANTITY);
    }
}

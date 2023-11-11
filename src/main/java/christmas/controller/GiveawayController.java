package christmas.controller;

import christmas.model.OrderAmount;

public class GiveawayController {
    private static final int GIVEAWAY_THRESHOLD = 120_000;

    public boolean isPossibleGive(OrderAmount orderAmount) {
        return orderAmount.orderAmount() >= GIVEAWAY_THRESHOLD;
    }
}

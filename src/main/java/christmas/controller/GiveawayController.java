package christmas.controller;

import christmas.model.GiveawayDetails;
import christmas.model.Menu;
import christmas.model.OrderAmount;
import christmas.model.PaymentInformation;
import christmas.view.OutputView;
import java.util.EnumMap;
import java.util.Map;

public class GiveawayController {
    private static final int GIVEAWAY_THRESHOLD = 120_000;
    private static final int GIVEAWAY_QUANTITY = 1;

    public GiveawayDetails give(PaymentInformation paymentInformation) {
        OrderAmount orderAmount = paymentInformation.orderAmount();

        Map<Menu, Integer> giveawayInformation = new EnumMap<>(Menu.class);
        GiveawayDetails giveawayDetails = new GiveawayDetails(giveawayInformation);

        if (isPossibleGive(orderAmount)) {
            getGiveaway(giveawayDetails);
        }
        OutputView.printGiveawayDetails(giveawayDetails);
        return giveawayDetails;
    }

    public boolean isPossibleGive(OrderAmount orderAmount) {
        return orderAmount.orderAmount() >= GIVEAWAY_THRESHOLD;
    }

    public void getGiveaway(GiveawayDetails giveawayDetails) {
        giveawayDetails.put(Menu.CHAMPAGNE, GIVEAWAY_QUANTITY);
    }
}

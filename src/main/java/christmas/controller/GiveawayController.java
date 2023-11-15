package christmas.controller;

import christmas.model.GiveawayDetails;
import christmas.model.Menu;
import christmas.model.OrderInformation;
import christmas.view.OutputView;
import java.util.EnumMap;
import java.util.Map;

public class GiveawayController {
    private static final int GIVEAWAY_THRESHOLD = 120_000;
    private static final int GIVEAWAY_QUANTITY = 1;

    public GiveawayDetails give(OrderInformation orderInformation) {
        int amount = orderInformation.orderAmount();

        Map<Menu, Integer> giveawayInformation = new EnumMap<>(Menu.class);
        GiveawayDetails giveawayDetails = new GiveawayDetails(giveawayInformation);

        if (isPossibleGive(amount)) {
            getGiveaway(giveawayDetails);
        }
        OutputView.printGiveawayDetails(giveawayDetails);
        return giveawayDetails;
    }

    public boolean isPossibleGive(int orderAmount) {
        return orderAmount >= GIVEAWAY_THRESHOLD;
    }

    public void getGiveaway(GiveawayDetails giveawayDetails) {
        giveawayDetails.put(Menu.CHAMPAGNE, GIVEAWAY_QUANTITY);
    }
}

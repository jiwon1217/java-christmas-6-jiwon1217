package christmas.controller;

import christmas.model.giveaway.GiveawayDetails;
import christmas.model.menu.Menu;
import christmas.model.order.OrderInformation;
import christmas.view.OutputView;
import java.util.EnumMap;
import java.util.Map;

public class GiveawayController {
    public GiveawayDetails give(OrderInformation orderInformation) {
        int amount = orderInformation.orderAmount();
        GiveawayDetails giveawayDetails = calculateGiveawayDetails(amount);

        OutputView.printGiveawayDetails(giveawayDetails);

        return giveawayDetails;
    }

    private GiveawayDetails calculateGiveawayDetails(int amount) {
        Map<Menu, Integer> giveawayInformation = new EnumMap<>(Menu.class);
        GiveawayDetails giveawayDetails = new GiveawayDetails(giveawayInformation);

        if (giveawayDetails.isPossibleGetGiveaway(amount)) {
            giveawayDetails.getGiveaway(giveawayDetails);
        }

        return giveawayDetails;
    }
}

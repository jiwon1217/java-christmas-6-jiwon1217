package christmas.model.giveaway;

import christmas.model.menu.Menu;
import java.util.Collections;
import java.util.Map;

public class GiveawayDetails {
    private static final int GIVEAWAY_THRESHOLD = 120_000;
    private static final int GIVEAWAY_QUANTITY = 1;
    private final Map<Menu, Integer> details;

    public GiveawayDetails(Map<Menu, Integer> details) {
        this.details = details;
    }

    public Map<Menu, Integer> of() {
        return Collections.unmodifiableMap(details);
    }

    public void put(Menu menu, Integer quantity) {
        details.put(menu, quantity);
    }

    public boolean isEmpty() {
        return details.isEmpty();
    }

    public boolean isPossibleGetGiveaway(int amount) {
        return amount >= GIVEAWAY_THRESHOLD;
    }

    public void getGiveaway(GiveawayDetails giveawayDetails) {
        giveawayDetails.put(Menu.CHAMPAGNE, GIVEAWAY_QUANTITY);
    }
}

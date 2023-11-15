package christmas.model.giveaway;

import christmas.model.menu.Menu;
import java.util.Collections;
import java.util.Map;

public class GiveawayDetails {
    private final Map<Menu, Integer> giveawayDetails;

    public GiveawayDetails(Map<Menu, Integer> giveawayDetails) {
        this.giveawayDetails = giveawayDetails;
    }

    public Map<Menu, Integer> of() {
        return Collections.unmodifiableMap(giveawayDetails);
    }

    public void put(Menu menu, Integer quantity) {
        giveawayDetails.put(menu, quantity);
    }

    public boolean isEmpty() {
        return giveawayDetails.isEmpty();
    }
}
package christmas.model;

import java.util.Collections;
import java.util.Map;

public class GiveawayDetails {
    private final Map<Menu, Integer> giveawayDetails;

    public GiveawayDetails(Map<Menu, Integer> giveawayDetails) {
        this.giveawayDetails = giveawayDetails;
    }

    public Map<Menu, Integer> get() {
        return Collections.unmodifiableMap(giveawayDetails);
    }

    public void put(Menu menu, Integer quantity) {
        giveawayDetails.put(menu, quantity);
    }

    public boolean isEmpty() {
        return giveawayDetails.isEmpty();
    }
}
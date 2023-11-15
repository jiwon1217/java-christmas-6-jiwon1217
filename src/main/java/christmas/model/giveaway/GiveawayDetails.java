package christmas.model.giveaway;

import christmas.model.menu.Menu;
import java.util.Collections;
import java.util.Map;

public class GiveawayDetails {
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
}

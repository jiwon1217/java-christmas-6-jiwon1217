package christmas.model.benefit;

import java.util.Collections;
import java.util.Map;

public class BenefitDetails {
    private final Map<DiscountPolicy, Integer> details;

    public BenefitDetails(Map<DiscountPolicy, Integer> details) {
        this.details = details;
    }

    public Map<DiscountPolicy, Integer> of() {
        return Collections.unmodifiableMap(details);
    }

    public void put(DiscountPolicy discountPolicy, int amount) {
        details.put(discountPolicy, amount);
    }

    public boolean isEmpty() {
        return details.isEmpty();
    }
}

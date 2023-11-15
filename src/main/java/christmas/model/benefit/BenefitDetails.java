package christmas.model.benefit;

import christmas.util.BenefitCalculator;
import java.util.Collections;
import java.util.Map;

public class BenefitDetails {
    private static final int BENEFIT_THRESHOLD = 10_000;
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

    public boolean isPossibleBenefit(int amount) {
        return amount >= BENEFIT_THRESHOLD;
    }

    public void applyGiveawayEvent() {
        details.put(DiscountPolicy.GIVEAWAY_EVENT, BenefitCalculator.calculateGiveawayEvent());
    }
}

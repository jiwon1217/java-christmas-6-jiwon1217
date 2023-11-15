package christmas.model.benefit;

import java.util.Collections;
import java.util.Map;

public class BenefitDetails {
    private final Map<DiscountPolicy, Integer> benefitDetails;

    public BenefitDetails(Map<DiscountPolicy, Integer> benefitDetails) {
        this.benefitDetails = benefitDetails;
    }

    public Map<DiscountPolicy, Integer> of() {
        return Collections.unmodifiableMap(benefitDetails);
    }

    public void put(DiscountPolicy discountPolicy, int amount) {
        benefitDetails.put(discountPolicy, amount);
    }

    public boolean isEmpty() {
        return benefitDetails.isEmpty();
    }
}

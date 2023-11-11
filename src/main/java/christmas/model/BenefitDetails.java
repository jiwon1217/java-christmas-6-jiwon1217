package christmas.model;

import java.util.Map;

public class BenefitDetails {
    private final Map<DiscountPolicy, Integer> benefitDetails;

    public BenefitDetails(Map<DiscountPolicy, Integer> benefitDetails) {
        this.benefitDetails = benefitDetails;
    }

    public void put(DiscountPolicy discountPolicy, int amount) {
        benefitDetails.put(discountPolicy, amount);
    }
}

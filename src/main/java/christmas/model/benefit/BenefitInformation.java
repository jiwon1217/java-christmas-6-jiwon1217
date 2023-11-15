package christmas.model.benefit;

import christmas.model.benefit.BenefitAmount;
import christmas.model.benefit.BenefitDetails;

public class BenefitInformation {
    private final BenefitDetails benefitDetails;
    private final BenefitAmount benefitAmount;

    public BenefitInformation(BenefitDetails benefitDetails, BenefitAmount benefitAmount) {
        this.benefitDetails = benefitDetails;
        this.benefitAmount = benefitAmount;
    }

    public BenefitDetails getBenefitDetails() {
        return benefitDetails;
    }

    public int getBenefitAmount() {
        return benefitAmount.amount();
    }
}

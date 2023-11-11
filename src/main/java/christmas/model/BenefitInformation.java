package christmas.model;

public class BenefitInformation {
    private final BenefitDetails benefitDetails;
    private final BenefitAmount benefitAmount;

    public BenefitInformation(BenefitDetails benefitDetails, BenefitAmount benefitAmount) {
        this.benefitDetails = benefitDetails;
        this.benefitAmount = benefitAmount;
    }
}

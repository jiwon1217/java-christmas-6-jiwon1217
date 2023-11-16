package christmas.controller;

import christmas.model.benefit.BenefitAmount;
import christmas.model.benefit.BenefitDetails;
import christmas.model.benefit.BenefitInformation;
import christmas.util.AmountCalculator;
import christmas.view.OutputView;

public class BenefitAmountController {
    public BenefitInformation apply(BenefitDetails benefitDetails) {
        BenefitAmount amount = calculateBenefitAmount(benefitDetails);

        OutputView.printBenefitAmount(amount);

        return new BenefitInformation(benefitDetails, amount);
    }

    private BenefitAmount calculateBenefitAmount(BenefitDetails benefitDetails) {
        return AmountCalculator.calculateBenefitAmount(benefitDetails);
    }
}

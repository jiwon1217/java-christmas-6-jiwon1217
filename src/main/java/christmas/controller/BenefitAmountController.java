package christmas.controller;

import christmas.model.BenefitAmount;
import christmas.model.BenefitDetails;
import christmas.model.BenefitInformation;
import christmas.util.Calculator;
import christmas.view.OutputView;

public class BenefitAmountController {
    public BenefitInformation getBenefitAmount(BenefitDetails benefitDetails) {
        BenefitAmount benefitAmount = Calculator.calculateBenefitAmount(benefitDetails);

        OutputView.printBenefitAmount(benefitAmount);

        return new BenefitInformation(benefitDetails, benefitAmount);
    }
}

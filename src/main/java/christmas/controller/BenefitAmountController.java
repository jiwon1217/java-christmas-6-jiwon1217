package christmas.controller;

import christmas.model.BenefitAmount;
import christmas.model.BenefitDetails;
import christmas.model.BenefitInformation;
import christmas.util.Calculator;
import christmas.view.OutputView;

public class BenefitAmountController {
    public BenefitInformation getBenefitAmount(BenefitDetails benefitDetails) {
        BenefitAmount amount = Calculator.calculateBenefitAmount(benefitDetails);

        OutputView.printBenefitAmount(amount);

        return new BenefitInformation(benefitDetails, amount);
    }
}

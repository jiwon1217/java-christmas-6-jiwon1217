package christmas.controller;

import christmas.model.benefit.BenefitAmount;
import christmas.model.benefit.BenefitDetails;
import christmas.model.benefit.BenefitInformation;
import christmas.util.Calculator;
import christmas.view.OutputView;

public class BenefitAmountController {
    public BenefitInformation getBenefitAmount(BenefitDetails benefitDetails) {
        BenefitAmount amount = Calculator.calculateBenefitAmount(benefitDetails);

        OutputView.printBenefitAmount(amount);

        return new BenefitInformation(benefitDetails, amount);
    }
}

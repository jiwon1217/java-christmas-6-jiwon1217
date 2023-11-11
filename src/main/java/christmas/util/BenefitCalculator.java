package christmas.util;

import christmas.model.VisitDate;
import java.time.LocalDate;

public class BenefitCalculator {
    private static final int GIVEAWAY_AMOUNT = 25_000;
    private static final LocalDate DecemberFirst = LocalDate.of(2023, 12, 1);
    private static final int START_DISCOUNT_AMOUNT = 1000;
    private static final int DAILY_DISCOUNT_INCREMENT = 100;

    public static int calculateGiveawayEvent() {
        return GIVEAWAY_AMOUNT;
    }

    public static int calculateChristmasDDayDiscount(VisitDate visitDate) {
        int daysUntilVisit = visitDate.getDay() - DecemberFirst.getDayOfMonth();

        return START_DISCOUNT_AMOUNT + (DAILY_DISCOUNT_INCREMENT * daysUntilVisit);
    }
}

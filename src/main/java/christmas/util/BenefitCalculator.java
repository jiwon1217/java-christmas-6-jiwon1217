package christmas.util;

import christmas.model.Category;
import christmas.model.OrderList;
import christmas.model.VisitDate;
import java.time.LocalDate;

public class BenefitCalculator {
    private static final int GIVEAWAY_AMOUNT = 25_000;
    private static final LocalDate DecemberFirst = LocalDate.of(2023, 12, 1);
    private static final int START_DISCOUNT_AMOUNT = 1000;
    private static final int DAILY_DISCOUNT_INCREMENT = 100;
    private static final int DAY_DISCOUNT_AMOUNT = 2023;

    public static int calculateGiveawayEvent() {
        return GIVEAWAY_AMOUNT;
    }

    public static int calculateChristmasDDayDiscount(VisitDate visitDate) {
        int daysUntilVisit = visitDate.getDay() - DecemberFirst.getDayOfMonth();

        return START_DISCOUNT_AMOUNT + (DAILY_DISCOUNT_INCREMENT * daysUntilVisit);
    }

    public static int calculateWeekdayDiscount(OrderList orderList) {
        return orderList.get().entrySet().stream()
                .filter(entry -> entry.getKey().getCategory() == Category.DESSERT)
                .mapToInt(entry -> entry.getValue() * DAY_DISCOUNT_AMOUNT)
                .sum();
    }

    public static int calculateWeekendDiscount(OrderList orderList) {
        return orderList.get().entrySet().stream()
                .filter(entry -> entry.getKey().getCategory() == Category.MAIN)
                .mapToInt(entry -> entry.getValue() * DAY_DISCOUNT_AMOUNT)
                .sum();
    }
}

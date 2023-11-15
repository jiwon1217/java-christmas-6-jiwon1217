package christmas.model.order;

import java.time.LocalDate;

public class VisitDate {
    private static final int FRIDAY = 5;
    private static final int SATURDAY = 6;
    private static final int SUNDAY = 7;
    private static final int CHRISTMAS_DAY = 25;
    private final LocalDate visitDate;

    public VisitDate(int visitDay) {
        this.visitDate = LocalDate.of(2023, 12, visitDay);
    }

    public int getDayOfTheWeek() {
        return visitDate.getDayOfWeek().getValue();
    }

    public int getDay() {
        return visitDate.getDayOfMonth();
    }

    public boolean isWeekend() {
        return getDayOfTheWeek() == FRIDAY || getDayOfTheWeek() == SATURDAY;
    }

    public boolean isSpecialDay() {
        return getDayOfTheWeek() == SUNDAY || getDay() == CHRISTMAS_DAY;
    }

    public boolean isInChristmasDay() {
        return getDay() <= CHRISTMAS_DAY;
    }
}

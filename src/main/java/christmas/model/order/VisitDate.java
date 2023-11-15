package christmas.model.order;

import java.time.LocalDate;

public class VisitDate {
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
}

package christmas.model;

public class PaymentInformation {
    private final VisitDate visitDate;
    private final OrderAmount orderAmount;

    public PaymentInformation(VisitDate visitDate, OrderAmount orderAmount) {
        this.visitDate = visitDate;
        this.orderAmount = orderAmount;
    }
}

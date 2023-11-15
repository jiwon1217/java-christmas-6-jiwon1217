package christmas.model;

public class PaymentInformation {
    private final VisitDate visitDate;
    private final OrderList orderList;
    private final OrderAmount orderAmount;

    public PaymentInformation(VisitDate visitDate, OrderList orderList, OrderAmount orderAmount) {
        this.visitDate = visitDate;
        this.orderList = orderList;
        this.orderAmount = orderAmount;
    }

    public VisitDate visitDate() {
        return visitDate;
    }

    public OrderList orderList() {
        return orderList;
    }

    public int getOrderAmount() {
        return orderAmount.orderAmount();
    }
}

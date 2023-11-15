package christmas.model.order;

public class OrderInformation {
    private final VisitDate visitDate;
    private final OrderList orderList;
    private final OrderAmount orderAmount;

    public OrderInformation(VisitDate visitDate, OrderList orderList, OrderAmount orderAmount) {
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

    public int orderAmount() {
        return orderAmount.amount();
    }
}

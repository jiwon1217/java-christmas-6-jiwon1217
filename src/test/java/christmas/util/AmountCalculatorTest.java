package christmas.util;

import christmas.model.order.OrderAmount;
import christmas.model.order.OrderList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountCalculatorTest {
    @DisplayName("할인 전 총 주문 금액 계산 테스트")
    @Test
    void calculateOrderAmountTest() {
        String input = "타파스-1,제로콜라-1";
        int expectedAmount = 8500;

        OrderList orderList = Parser.parseStringToOrderList(input);
        OrderAmount orderAmount = AmountCalculator.calculateOrderAmount(orderList);

        Assertions.assertThat(orderAmount.amount()).isEqualTo(expectedAmount);
    }
}
package christmas.order;

import christmas.model.order.OrderAmount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OrderAmountTest {

    @DisplayName("주문 금액 생성 테스트")
    @ParameterizedTest
    @CsvSource({"5000", "10000", "20000"})
    void createOrderAmountTest(int amount) {
        OrderAmount orderAmount = new OrderAmount(amount);

        Assertions.assertThat(orderAmount.amount()).isEqualTo(amount);
    }
}

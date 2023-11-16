package christmas.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidatorTest {
    @DisplayName("방문 날짜는 1이상 31이하여야 한다.")
    @ParameterizedTest
    @CsvSource("1,2,3,4,5")
    void validateVisitDayTest(String input) {
        assertThatCode(() -> Validator.validateVisitDay(input)).doesNotThrowAnyException();
    }

    @DisplayName("방문 날짜가 유효하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource("32,33,34,35,36")
    void validateVisitDayExceptionTest(String input) {
        assertThatThrownBy(() -> Validator.validateVisitDay(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 주문시 주어진 형식을 지켜야 한다.")
    @Test
    void validateOrderMenuTest() {
        String input = "타파스-1,제로콜라-2";
        assertThatCode(() -> Validator.validateOrderMenu(input)).doesNotThrowAnyException();
    }

    @DisplayName("메뉴 주문시 형식을 지키지 않으면 예외가 발생한다.")
    @Test
    void validateInputFormatTest() {
        String input = "타파스-1제로콜라-2";
        assertThatThrownBy(() -> Validator.validateOrderMenu(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("존재하지 않는 메뉴를 주문하면 예외가 발생한다.")
    @Test
    void validateExistMenuTest() {
        String input = "파스타-1,음료수-2";
        assertThatThrownBy(() -> Validator.validateOrderMenu(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("20개가 넘는 수량을 주문하면 예외가 발생한다.")
    @Test
    void validateQuantityTest() {
        String input = "타파스-20,제로콜라-20";
        assertThatThrownBy(() -> Validator.validateOrderMenu(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복되는 메뉴를 주문하면 예외가 발생한다.")
    @Test
    void validateDuplicateMenuTest() {
        String input = "타파스-2,타파스-2";
        assertThatThrownBy(() -> Validator.validateOrderMenu(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료만 주문하면 예외가 발생한다.")
    @Test
    void validateOnlyOrderBeverageTest() {
        String input = "제로콜라-2";
        assertThatThrownBy(() -> Validator.validateOrderMenu(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
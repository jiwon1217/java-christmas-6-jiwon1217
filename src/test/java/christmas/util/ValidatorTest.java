package christmas.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
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
}
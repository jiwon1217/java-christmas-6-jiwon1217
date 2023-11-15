package christmas.giveaway;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.giveaway.GiveawayDetails;
import christmas.model.menu.Menu;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GiveawayDetailsTest {
    @DisplayName("주문 금액이 12만원 이상이면 증정 메뉴를 받을 수 있다.")
    @ParameterizedTest
    @CsvSource("120_000,200_000,300_000")
    void isPossibleGetGiveawayTest(int amount) {
        Map<Menu, Integer> giveawayInformation = new EnumMap<>(Menu.class);
        GiveawayDetails giveawayDetails = new GiveawayDetails(giveawayInformation);

        assertThat(giveawayDetails.isPossibleGetGiveaway(amount)).isTrue();
    }

    @DisplayName("주문 금액이 12만원 미만이면 증정 메뉴를 받을 수 없다.")
    @ParameterizedTest
    @CsvSource("119_999,110_000,30_000")
    void isImPossibleGetGiveawayTest(int amount) {
        Map<Menu, Integer> giveawayInformation = new EnumMap<>(Menu.class);
        GiveawayDetails giveawayDetails = new GiveawayDetails(giveawayInformation);

        assertThat(giveawayDetails.isPossibleGetGiveaway(amount)).isFalse();
    }
}

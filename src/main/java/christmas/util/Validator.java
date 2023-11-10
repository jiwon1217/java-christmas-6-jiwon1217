package christmas.util;

import java.util.regex.Pattern;

public class Validator {
    private static final Pattern BETWEEN_1_AND_31_REGEX = Pattern.compile("^(?:[1-9]|[12]\\d|3[01])$");
    private static final Pattern ORDER_MENU_REGEX = Pattern.compile("^[가-힣]+-\\d+(,[가-힣]+-\\d+)*$");

    public static void validateVisitDay(String input) {
        if (!isBetween1And31(input)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static boolean isBetween1And31(String input) {
        return BETWEEN_1_AND_31_REGEX.matcher(input).matches();
    }

    public static void validateOrderMenu(String input) {
        validateInputFormat(input);
    }

    private static void validateInputFormat(String input) {
        if (!isValidInputFormat(input)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean isValidInputFormat(String input) {
        return ORDER_MENU_REGEX.matcher(input).matches();
    }
}

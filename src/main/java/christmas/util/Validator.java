package christmas.util;

import christmas.model.Menu;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern BETWEEN_1_AND_31_REGEX = Pattern.compile("^(?:[1-9]|[12]\\d|3[01])$");
    private static final Pattern ORDER_MENU_REGEX = Pattern.compile("^[가-힣]+-\\d+(,[가-힣]+-\\d+)*$");

    public static void validateVisitDay(String input) {
        if (!isBetween1And31(input)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean isBetween1And31(String input) {
        return BETWEEN_1_AND_31_REGEX.matcher(input).matches();
    }

    public static void validateOrderMenu(String input) {
        validateInputFormat(input);
        validateExistMenu(input);
        validateAmount(input);
    }

    private static void validateInputFormat(String input) {
        if (!isValidInputFormat(input)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean isValidInputFormat(String input) {
        return ORDER_MENU_REGEX.matcher(input).matches();
    }

    private static void validateExistMenu(String input) {
        Pattern menuPattern = Pattern.compile("([가-힣]+)-\\d");
        Matcher menuMatcher = menuPattern.matcher(input);

        while (menuMatcher.find()) {
            String menu = menuMatcher.group(1);

            if (isNotExistMenu(menu)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private static boolean isNotExistMenu(String input) {
        return !Menu.findMenu(input);
    }

    private static void validateAmount(String input) {
        if (calculateAmount(input) > 20) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static int calculateAmount(String input) {
        Pattern menuPattern = Pattern.compile("([가-힣]+)-(\\d+)");
        Matcher menuMatcher = menuPattern.matcher(input);
        int sum = 0;

        while (menuMatcher.find()) {
            int amount = Integer.parseInt(menuMatcher.group(2));
            sum += amount;
        }
        return sum;
    }
}

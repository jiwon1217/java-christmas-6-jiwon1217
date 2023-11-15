package christmas.util;

import christmas.model.menu.Category;
import christmas.model.menu.Menu;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern BETWEEN_1_AND_31_REGEX = Pattern.compile("^(?:[1-9]|[12]\\d|3[01])$");
    private static final Pattern ORDER_MENU_REGEX = Pattern.compile("^[가-힣]+-\\d+(,[가-힣]+-\\d+)*$");
    private static final Pattern MENU_PATTERN = Pattern.compile("([가-힣]+)-(\\d+)");
    private static final String INVALID_DATE_RETRY_INPUT = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String INVALID_ORDER_RETRY_INPUT = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String MENU_DELIMITER = ",";
    private static final String QUANTITY_DELIMITER = "-";
    private static final int ORDER_THRESHOLD = 20;

    private Validator() {
        throw new IllegalArgumentException();
    }

    public static void validateVisitDay(String input) {
        if (!isBetween1And31(input)) {
            throw new IllegalArgumentException(INVALID_DATE_RETRY_INPUT);
        }
    }

    private static boolean isBetween1And31(String input) {
        return BETWEEN_1_AND_31_REGEX.matcher(input).matches();
    }

    public static void validateOrderMenu(String input) {
        validateInputFormat(input);
        validateExistMenu(input);
        validateQuantity(input);
        validateDuplicateMenu(input);
        validateOnlyOrderBeverage(input);
    }

    private static void validateInputFormat(String input) {
        if (!isValidInputFormat(input)) {
            throw new IllegalArgumentException(INVALID_ORDER_RETRY_INPUT);
        }
    }

    private static boolean isValidInputFormat(String input) {
        return ORDER_MENU_REGEX.matcher(input).matches();
    }

    private static void validateExistMenu(String input) {
        Matcher menuMatcher = MENU_PATTERN.matcher(input);

        while (menuMatcher.find()) {
            String menu = menuMatcher.group(1);

            if (isNotExistMenu(menu)) {
                throw new IllegalArgumentException(INVALID_ORDER_RETRY_INPUT);
            }
        }
    }

    private static boolean isNotExistMenu(String input) {
        return !Menu.findMenu(input);
    }

    private static void validateQuantity(String input) {
        if (calculateMenuQuantity(input) > ORDER_THRESHOLD) {
            throw new IllegalArgumentException(INVALID_ORDER_RETRY_INPUT);
        }
    }

    private static int calculateMenuQuantity(String input) {
        Matcher menuMatcher = MENU_PATTERN.matcher(input);
        int sum = 0;

        while (menuMatcher.find()) {
            int amount = Integer.parseInt(menuMatcher.group(2));
            sum += amount;
        }
        return sum;
    }

    private static void validateDuplicateMenu(String input) {
        if (hasDuplicateMenu(input)) {
            throw new IllegalArgumentException(INVALID_ORDER_RETRY_INPUT);
        }
    }

    private static boolean hasDuplicateMenu(String input) {
        Set<String> uniqueOrderMenus = new HashSet<>();
        String[] orderMenus = input.split(MENU_DELIMITER);

        for (String orderMenu : orderMenus) {
            String menu = orderMenu.split(QUANTITY_DELIMITER)[0];

            if (!uniqueOrderMenus.add(menu)) {
                return true;
            }
        }
        return false;
    }

    private static void validateOnlyOrderBeverage(String input) {
        if (isBeverageOnlyOrder(input)) {
            throw new IllegalArgumentException(INVALID_ORDER_RETRY_INPUT);
        }
    }

    private static boolean isBeverageOnlyOrder(String input) {
        String[] orderMenus = input.split(MENU_DELIMITER);

        for (String orderMenu : orderMenus) {
            String menuName = orderMenu.split(QUANTITY_DELIMITER)[0];
            Menu menu = Menu.getMenu(menuName);

            if (menu.getCategory() != Category.BEVERAGE) {
                return false;
            }
        }
        return true;
    }
}

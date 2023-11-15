package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.order.VisitDate;
import christmas.util.Validator;

public class InputView {
    private static final String ASK_VISIT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ASK_ORDER_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    private InputView() {
        throw new IllegalArgumentException();
    }

    public static int askVisitDate() {
        try {
            System.out.println(ASK_VISIT_DATE);
            String input = Console.readLine();

            Validator.validateVisitDay(input);
            int visitDay = Integer.parseInt(input);

            return visitDay;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askVisitDate();
        }
    }

    public static String askOrderMenu() {
        try {
            System.out.println(ASK_ORDER_MENU);
            String input = Console.readLine();

            Validator.validateOrderMenu(input);

            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askOrderMenu();
        }
    }
}

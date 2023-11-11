package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.VisitDate;
import christmas.util.Validator;

public class InputView {
    public static VisitDate askVisitDate() {
        try {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            String input = Console.readLine();

            Validator.validateVisitDay(input);
            int visitDay = Integer.parseInt(input);

            return new VisitDate(visitDay);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askVisitDate();
        }
    }

    public static String askOrderMenu() {
        try {
            System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
            String input = Console.readLine();

            Validator.validateOrderMenu(input);

            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askOrderMenu();
        }
    }
}
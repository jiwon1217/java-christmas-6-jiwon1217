package christmas.view;

import christmas.model.Menu;
import christmas.model.OrderList;
import christmas.model.VisitDate;
import java.util.Map;

public class OutputView {
    public static void printGreeting() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printBenefitPreviewInformation(VisitDate visitDate) {
        System.out.println("12월" + visitDate.getDay() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public static void printOrderList(OrderList orderList) {
        System.out.println();
        System.out.println("<주문 메뉴>");

        for (Map.Entry<Menu, Integer> orderMenu : orderList.get().entrySet()) {
            Menu menu = orderMenu.getKey();
            int amount = orderMenu.getValue();
            System.out.println(menu.getName() + " " + amount + "개");
        }
    }
}

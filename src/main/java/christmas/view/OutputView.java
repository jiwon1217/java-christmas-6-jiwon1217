package christmas.view;

import christmas.model.BadgeDetails;
import christmas.model.BenefitAmount;
import christmas.model.BenefitDetails;
import christmas.model.DiscountPolicy;
import christmas.model.GiveawayDetails;
import christmas.model.Menu;
import christmas.model.OrderAmount;
import christmas.model.OrderList;
import christmas.model.PayAmount;
import christmas.model.VisitDate;
import christmas.util.CurrencyFormatter;
import java.util.Map;

public class OutputView {
    public static void printGreeting() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printBenefitPreviewInformation(VisitDate visitDate) {
        System.out.println("12월" + " " + visitDate.getDay() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
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

    public static void printOrderAmount(OrderAmount orderAmount) {
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(CurrencyFormatter.changeFormat(orderAmount.orderAmount()) + "원");
    }

    public static void printGiveawayDetails(GiveawayDetails giveawayDetails) {
        System.out.println();
        System.out.println("<증정 메뉴>");

        if (giveawayDetails.isEmpty()) {
            System.out.println("없음");
            return;
        }

        for (Map.Entry<Menu, Integer> giveaway : giveawayDetails.get().entrySet()) {
            Menu menu = giveaway.getKey();
            int quantity = giveaway.getValue();
            System.out.println(menu.getName() + " " + quantity + "개");
        }
    }

    public static void printBenefitDetails(BenefitDetails benefitDetails) {
        System.out.println();
        System.out.println("<혜택 내역>");

        if (benefitDetails.isEmpty()) {
            System.out.println("없음");
            return;
        }

        for (Map.Entry<DiscountPolicy, Integer> benefit : benefitDetails.get().entrySet()) {
            DiscountPolicy discountPolicy = benefit.getKey();
            int benefitAmount = benefit.getValue();
            System.out.println(
                    discountPolicy.getName() + " " + ":" + " " + "-" + CurrencyFormatter.changeFormat(benefitAmount)
                            + "원");
        }
    }

    public static void printBenefitAmount(BenefitAmount benefitAmount) {
        System.out.println();
        System.out.println("<총혜택 금액>");

        int amount = benefitAmount.benefitAmount();

        if (benefitAmount.benefitAmount() > 0) {
            System.out.println("-" + CurrencyFormatter.changeFormat(amount) + "원");
            return;
        }
        System.out.println(amount + "원");
    }

    public static void printPayAmount(PayAmount payAmount) {
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(CurrencyFormatter.changeFormat(payAmount.payAmount()) + "원");
    }

    public static void printBadgeDetails(BadgeDetails badgeDetails) {
        System.out.println();
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badgeDetails.get());
    }
}

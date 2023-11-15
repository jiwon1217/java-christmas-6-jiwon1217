package christmas.view;

import christmas.model.badge.BadgeDetails;
import christmas.model.benefit.BenefitAmount;
import christmas.model.benefit.BenefitDetails;
import christmas.model.benefit.DiscountPolicy;
import christmas.model.giveaway.GiveawayDetails;
import christmas.model.menu.Menu;
import christmas.model.order.OrderAmount;
import christmas.model.order.OrderList;
import christmas.model.payment.PayAmount;
import christmas.model.order.VisitDate;
import christmas.util.CurrencyFormatter;
import java.util.Map;

public class OutputView {
    private static final String GREETING = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String DECEMBER = "12월";
    private static final String BENEFIT_PREVIEW = "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT = "<할인 전 총주문 금액>";
    private static final String GIVEAWAY_MENU = "<증정 메뉴>";
    private static final String BENEFIT_DETAILS = "<혜택 내역>";
    private static final String TOTAL_BENEFIT_AMOUNT = "<총혜택 금액>";
    private static final String DECEMBER_EVENT_BADGE = "<12월 이벤트 배지>";
    private static final String TOTAL_PAY_AMOUNT_AFTER_DISCOUNT = "<할인 후 예상 결제 금액>";
    private static final String QUANTITY = "개";
    private static final String WON = "원";
    private static final String NONE = "없음";
    private static final String BLANK = " ";
    private static final String MINUS = "-";
    private static final String DELIMITER = ":";

    public static void printGreeting() {
        System.out.println(GREETING);
    }

    public static void printBenefitPreviewInformation(VisitDate visitDate) {
        System.out.println(DECEMBER + BLANK + visitDate.getDay() + BENEFIT_PREVIEW);
    }

    public static void printOrderList(OrderList orderList) {
        System.out.println();
        System.out.println(ORDER_MENU);

        for (Map.Entry<Menu, Integer> orderMenu : orderList.of().entrySet()) {
            Menu menu = orderMenu.getKey();
            int quantity = orderMenu.getValue();

            System.out.println(menu.getName() + BLANK + quantity + QUANTITY);
        }
    }

    public static void printOrderAmount(OrderAmount orderAmount) {
        System.out.println();
        System.out.println(TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT);
        System.out.println(CurrencyFormatter.changeFormat(orderAmount.amount()) + WON);
    }

    public static void printGiveawayDetails(GiveawayDetails giveawayDetails) {
        System.out.println();
        System.out.println(GIVEAWAY_MENU);

        if (giveawayDetails.isEmpty()) {
            System.out.println(NONE);
            return;
        }
        for (Map.Entry<Menu, Integer> giveaway : giveawayDetails.of().entrySet()) {
            Menu menu = giveaway.getKey();
            int quantity = giveaway.getValue();

            System.out.println(menu.getName() + BLANK + quantity + QUANTITY);
        }
    }

    public static void printBenefitDetails(BenefitDetails benefitDetails) {
        System.out.println();
        System.out.println(BENEFIT_DETAILS);

        if (benefitDetails.isEmpty()) {
            System.out.println(NONE);
            return;
        }
        for (Map.Entry<DiscountPolicy, Integer> benefit : benefitDetails.of().entrySet()) {
            DiscountPolicy discountPolicy = benefit.getKey();
            int amount = benefit.getValue();

            System.out.println(
                    discountPolicy.getName() + BLANK + DELIMITER + BLANK + MINUS + CurrencyFormatter.changeFormat(
                            amount)
                            + WON);
        }
    }

    public static void printBenefitAmount(BenefitAmount benefitAmount) {
        System.out.println();
        System.out.println(TOTAL_BENEFIT_AMOUNT);

        int amount = benefitAmount.amount();

        if (amount > 0) {
            System.out.println(MINUS + CurrencyFormatter.changeFormat(amount) + WON);
            return;
        }
        System.out.println(amount + WON);
    }

    public static void printPayAmount(PayAmount payAmount) {
        System.out.println();
        System.out.println(TOTAL_PAY_AMOUNT_AFTER_DISCOUNT);
        System.out.println(CurrencyFormatter.changeFormat(payAmount.amount()) + WON);
    }

    public static void printBadgeDetails(BadgeDetails badgeDetails) {
        System.out.println();
        System.out.println(DECEMBER_EVENT_BADGE);
        System.out.println(badgeDetails.get());
    }
}

package christmas.view;

import christmas.model.VisitDate;

public class OutputView {
    public static void printGreeting() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printBenefitPreviewInformation(VisitDate visitDate) {
        System.out.println("12월" + visitDate.getDay() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }
}

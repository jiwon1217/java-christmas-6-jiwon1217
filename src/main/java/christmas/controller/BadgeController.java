package christmas.controller;

import christmas.model.Badge;
import christmas.model.BadgeDetails;
import christmas.view.OutputView;

public class BadgeController {
    private static void getBadge(int benefitAmount) {
        getSantaBadge(benefitAmount);
        getTreeBadge(benefitAmount);
        getStarBadge(benefitAmount);
        getNoneBadge(benefitAmount);
    }

    private static void getSantaBadge(int benefitAmount) {
        if (isPossibleSantaBadge(benefitAmount)) {
            BadgeDetails badgeDetails = new BadgeDetails(Badge.SANTA);
            OutputView.printBadgeDetails(badgeDetails);
        }
    }

    private static void getTreeBadge(int benefitAmount) {
        if (isPossibleTreeBadge(benefitAmount)) {
            BadgeDetails badgeDetails = new BadgeDetails(Badge.TREE);
            OutputView.printBadgeDetails(badgeDetails);
        }
    }

    private static void getStarBadge(int benefitAmount) {
        if (isPossibleStarBadge(benefitAmount)) {
            BadgeDetails badgeDetails = new BadgeDetails(Badge.STAR);
            OutputView.printBadgeDetails(badgeDetails);
        }
    }

    private static void getNoneBadge(int benefitAmount) {
        if (isCannotGetAnyBadge(benefitAmount)) {
            BadgeDetails badgeDetails = new BadgeDetails(Badge.NONE);
            OutputView.printBadgeDetails(badgeDetails);
        }
    }

    private static boolean isCannotGetAnyBadge(int benefitAmount) {
        return benefitAmount < 5000;
    }

    private static boolean isPossibleStarBadge(int benefitAmount) {
        return benefitAmount >= 5000 && benefitAmount < 10_000;
    }

    private static boolean isPossibleTreeBadge(int benefitAmount) {
        return benefitAmount >= 10_000 && benefitAmount < 20_000;
    }

    private static boolean isPossibleSantaBadge(int benefitAmount) {
        return benefitAmount >= 20_000;
    }
}

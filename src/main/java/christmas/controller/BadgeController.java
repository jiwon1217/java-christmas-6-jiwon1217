package christmas.controller;

import christmas.model.badge.Badge;
import christmas.model.badge.BadgeDetails;
import christmas.model.benefit.BenefitInformation;
import christmas.view.OutputView;

public class BadgeController {
    private static int SANTA_BADGE_THRESHOLD = 20_000;
    private static int TREE_BADGE_THRESHOLD = 10_000;
    private static int STAR_BADGE_THRESHOLD = 5_000;

    public void give(BenefitInformation benefitInformation) {
        int amount = benefitInformation.getBenefitAmount();

        getBadge(amount);
    }

    private static void getBadge(int amount) {
        getSantaBadge(amount);
        getTreeBadge(amount);
        getStarBadge(amount);
        getNoneBadge(amount);
    }

    private static void getSantaBadge(int amount) {
        if (isPossibleSantaBadge(amount)) {
            BadgeDetails badgeDetails = new BadgeDetails(Badge.SANTA);
            OutputView.printBadgeDetails(badgeDetails);
        }
    }

    private static void getTreeBadge(int amount) {
        if (isPossibleTreeBadge(amount)) {
            BadgeDetails badgeDetails = new BadgeDetails(Badge.TREE);
            OutputView.printBadgeDetails(badgeDetails);
        }
    }

    private static void getStarBadge(int amount) {
        if (isPossibleStarBadge(amount)) {
            BadgeDetails badgeDetails = new BadgeDetails(Badge.STAR);
            OutputView.printBadgeDetails(badgeDetails);
        }
    }

    private static void getNoneBadge(int amount) {
        if (isCannotGetAnyBadge(amount)) {
            BadgeDetails badgeDetails = new BadgeDetails(Badge.NONE);
            OutputView.printBadgeDetails(badgeDetails);
        }
    }

    private static boolean isCannotGetAnyBadge(int amount) {
        return amount < STAR_BADGE_THRESHOLD;
    }

    private static boolean isPossibleStarBadge(int amount) {
        return amount >= STAR_BADGE_THRESHOLD && amount < TREE_BADGE_THRESHOLD;
    }

    private static boolean isPossibleTreeBadge(int amount) {
        return amount >= TREE_BADGE_THRESHOLD && amount < SANTA_BADGE_THRESHOLD;
    }

    private static boolean isPossibleSantaBadge(int amount) {
        return amount >= SANTA_BADGE_THRESHOLD;
    }
}

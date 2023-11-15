package christmas.controller;

import christmas.model.Badge;
import christmas.model.BadgeDetails;
import christmas.model.BenefitInformation;
import christmas.view.OutputView;

public class BadgeController {
    private static int SANTA_BADGE_THRESHOLD = 20_000;
    private static int TREE_BADGE_THRESHOLD = 10_000;
    private static int STAR_BADGE_THRESHOLD = 5_000;

    public void give(BenefitInformation benefitInformation) {
        int benefitAmount = benefitInformation.getBenefitAmount();

        getBadge(benefitAmount);
    }

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
        return benefitAmount < STAR_BADGE_THRESHOLD;
    }

    private static boolean isPossibleStarBadge(int benefitAmount) {
        return benefitAmount >= STAR_BADGE_THRESHOLD && benefitAmount < TREE_BADGE_THRESHOLD;
    }

    private static boolean isPossibleTreeBadge(int benefitAmount) {
        return benefitAmount >= TREE_BADGE_THRESHOLD && benefitAmount < SANTA_BADGE_THRESHOLD;
    }

    private static boolean isPossibleSantaBadge(int benefitAmount) {
        return benefitAmount >= SANTA_BADGE_THRESHOLD;
    }
}

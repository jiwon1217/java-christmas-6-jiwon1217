package christmas.controller;

import christmas.model.badge.Badge;
import christmas.model.badge.BadgeDetails;
import christmas.model.benefit.BenefitInformation;
import christmas.view.OutputView;
import java.util.HashMap;
import java.util.Map;

public class BadgeController {
    private static final int SANTA_BADGE_THRESHOLD = 20_000;
    private static final int TREE_BADGE_THRESHOLD = 10_000;
    private static final int STAR_BADGE_THRESHOLD = 5_000;

    private static final Map<Integer, Badge> THRESHOLD_TO_BADGE = new HashMap<>();

    static {
        THRESHOLD_TO_BADGE.put(SANTA_BADGE_THRESHOLD, Badge.SANTA);
        THRESHOLD_TO_BADGE.put(TREE_BADGE_THRESHOLD, Badge.TREE);
        THRESHOLD_TO_BADGE.put(STAR_BADGE_THRESHOLD, Badge.STAR);
    }

    public void give(BenefitInformation benefitInformation) {
        int amount = benefitInformation.getBenefitAmount();

        Badge badge = getBadge(amount);
        BadgeDetails badgeDetails = new BadgeDetails(badge);

        OutputView.printBadgeDetails(badgeDetails);
    }

    private Badge getBadge(int amount) {
        return THRESHOLD_TO_BADGE.entrySet().stream()
                .filter(entry -> amount >= entry.getKey())
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(Badge.NONE);
    }
}

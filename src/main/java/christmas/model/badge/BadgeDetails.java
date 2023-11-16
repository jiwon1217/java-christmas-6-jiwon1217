package christmas.model.badge;

public class BadgeDetails {
    private final Badge badgeDetails;

    public BadgeDetails(Badge benefitDetails) {
        this.badgeDetails = benefitDetails;
    }

    public String get() {
        return badgeDetails.getName();
    }
}

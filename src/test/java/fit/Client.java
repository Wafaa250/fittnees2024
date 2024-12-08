package fit;

public class Client {
    private String name;
    private SubscriptionPlan subscription;

    public Client(String name, SubscriptionPlan subscription) {
        this.name = name;
        this.subscription = subscription;
    }

    public String getName() {
        return name;
    }

    public SubscriptionPlan getSubscription() {
        return subscription;
    }

    public void setSubscription(SubscriptionPlan subscription) {
        this.subscription = subscription;
    }
}

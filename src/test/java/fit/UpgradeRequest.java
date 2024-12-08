package fit;

public class UpgradeRequest {
    private Client client;
    private SubscriptionPlan newPlan;

    public UpgradeRequest(Client client, SubscriptionPlan newPlan) {
        this.client = client;
        this.newPlan = newPlan;
    }

    public String getClientName() {
        return client.getName();
    }

    public Client getClient() {
        return client;
    }

    public SubscriptionPlan getNewPlan() {
        return newPlan;
    }
}

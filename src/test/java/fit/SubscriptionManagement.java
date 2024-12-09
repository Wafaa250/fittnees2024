package fit;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionManagement {

    // قائمة بخطط الاشتراك
    private List<SubscriptionPlan> subscriptionPlans = new ArrayList<>();

    // طلبات ترقية الاشتراك
    private List<UpgradeRequest> upgradeRequests = new ArrayList<>();

    // إضافة خطة اشتراك جديدة
    public boolean addPlan(String name, double price) {
        for (SubscriptionPlan plan : subscriptionPlans) {
            if (plan.getName().equalsIgnoreCase(name)) {
                System.out.println("Error: Plan already exists.");
                return false; // الخطة موجودة بالفعل
            }
        }
        subscriptionPlans.add(new SubscriptionPlan(name, price));
        System.out.println("Plan added successfully: " + name);
        return true;
    }

    // تحديث سعر خطة الاشتراك
    public boolean updatePlanPrice(String name, double newPrice) {
        for (SubscriptionPlan plan : subscriptionPlans) {
            if (plan.getName().equalsIgnoreCase(name)) {
                plan.setPrice(newPrice);
                System.out.println("Price updated successfully for plan: " + name);
                return true;
            }
        }
        System.out.println("Error: Plan not found.");
        return false;
    }

    // حذف خطة اشتراك
    public boolean deletePlan(String name) {
        boolean removed = subscriptionPlans.removeIf(plan -> plan.getName().equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Plan removed successfully: " + name);
        } else {
            System.out.println("Error: Plan not found.");
        }
        return removed;
    }

    // عرض جميع خطط الاشتراك
    public List<SubscriptionPlan> viewPlans() {
        return subscriptionPlans;
    }

    // الموافقة على طلب ترقية
    public boolean approveUpgrade(String clientName) {
        for (UpgradeRequest request : upgradeRequests) {
            if (request.getClientName().equalsIgnoreCase(clientName)) {
                request.getClient().setSubscription(request.getNewPlan());
                upgradeRequests.remove(request);
                System.out.println("Upgrade approved for client: " + clientName);
                return true;
            }
        }
        System.out.println("Error: Upgrade request not found.");
        return false;
    }

    // رفض طلب ترقية
    public boolean rejectUpgrade(String clientName) {
        for (UpgradeRequest request : upgradeRequests) {
            if (request.getClientName().equalsIgnoreCase(clientName)) {
                upgradeRequests.remove(request);
                System.out.println("Upgrade rejected for client: " + clientName);
                return true;
            }
        }
        System.out.println("Error: Upgrade request not found.");
        return false;
    }

    // إضافة طلب ترقية
    public void addUpgradeRequest(Client client, SubscriptionPlan newPlan) {
        upgradeRequests.add(new UpgradeRequest(client, newPlan));
        System.out.println("Upgrade request added for client: " + client.getName());
    }
}

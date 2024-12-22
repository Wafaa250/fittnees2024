package fit;

import java.io.*;
import java.util.*;

public class SubscriptionManagementSource {

    private Vector<SubscriptionPlan> plans = new Vector<>();
    private Vector<Subscription> subscriptions = new Vector<>();
    private Map<String, String> users = new HashMap<>(); // حفظ الـ Client ID بناءً على البريد الإلكتروني

    // تحميل بيانات المستخدمين من الملف
    public SubscriptionManagementSource() {
        loadUsers();
    }

    // تحميل بيانات المستخدمين من ملف Accounts.txt
    private void loadUsers() {
        String filePath = "C:\\Users\\Msys\\eclipse-workspace\\fit\\src\\main\\resources\\Accounts.txt"; // تأكد من المسار الصحيح للملف
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] user = line.split(",");
                String clientId = user[3]; // الـ Client ID في هذا المثال هو العنصر الرابع
                String email = user[2]; // البريد الإلكتروني في هذا المثال هو العنصر الثالث
                users.put(email, clientId);  // تخزين البريد الإلكتروني مع الـ Client ID
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // البحث عن الـ Client ID باستخدام البريد الإلكتروني
    public String getClientId(String email) {
        return users.get(email); // إرجاع الـ Client ID بناءً على البريد الإلكتروني
    }

    // إضافة خطة اشتراك جديدة
    public boolean addSubscriptionPlan(String name, int price) {
        for (SubscriptionPlan plan : plans) {
            if (plan.getName().equalsIgnoreCase(name)) {
                return false; // Plan already exists
            }
        }
        plans.add(new SubscriptionPlan(name, price));
        savePlansToFile();
        return true;
    }

    // تعديل خطة اشتراك موجودة
    public boolean modifySubscriptionPlan(String oldName, String newName, int newPrice) {
        for (SubscriptionPlan plan : plans) {
            if (plan.getName().equalsIgnoreCase(oldName)) {
                plan.setName(newName);
                plan.setPrice(newPrice);
                savePlansToFile();
                return true;
            }
        }
        return false; // Plan not found to modify
    }

    // حذف خطة اشتراك
    public boolean deleteSubscriptionPlan(String name) {
        for (SubscriptionPlan plan : plans) {
            if (plan.getName().equalsIgnoreCase(name)) {
                plans.remove(plan);
                savePlansToFile();
                return true;
            }
        }
        return false; // Plan not found
    }

    // طلب ترقية اشتراك للعميل
    public void requestUpgrade(String email) {
        String clientId = getClientId(email);  // استخراج Client ID باستخدام البريد الإلكتروني
        if (clientId != null) {
            subscriptions.add(new Subscription(clientId, "Upgrade Requested"));
        } else {
            System.out.println("Client not found!");
        }
    }

    // رفض طلب ترقية الاشتراك للعميل
    public boolean rejectSubscriptionUpgrade(String email) {
        String clientId = getClientId(email);  // استخراج Client ID باستخدام البريد الإلكتروني
        for (Subscription subscription : subscriptions) {
            if (subscription.getClientId().equals(clientId) && subscription.getPlanName().equals("Upgrade Requested")) {
                subscription.setPlanName("Basic");  // الترقية تم رفضها، لذلك نعيد اشتراك العميل إلى الخطة الأساسية
                saveSubscriptionsToFile();
                return true; // رفض الترقية بنجاح
            }
        }
        return false; // لم يتم العثور على طلب ترقية
    }

    // دالة لإلغاء اشتراك العميل بناءً على معرفه
    public boolean cancelSubscription(String email) {
        String clientId = getClientId(email);  // استخراج Client ID باستخدام البريد الإلكتروني
        for (Subscription subscription : subscriptions) {
            if (subscription.getClientId().equals(clientId)) {
                subscriptions.remove(subscription);  // إزالة الاشتراك للعميل المحدد
                saveSubscriptionsToFile();  // حفظ التغييرات في الملف
                return true;
            }
        }
        return false; // لم يتم العثور على الاشتراك
    }

    // دالة لحفظ خطط الاشتراك في الملف
    private void savePlansToFile() {
        String filePath = "C:\\Users\\Msys\\eclipse-workspace\\fit\\src\\main\\resources\\SubscriptionPlans.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (SubscriptionPlan plan : plans) {
                writer.write(plan.getName() + "," + plan.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // دالة لحفظ الاشتراكات في الملف
    private void saveSubscriptionsToFile() {
        String filePath = "C:\\Users\\Msys\\eclipse-workspace\\fit\\src\\main\\resources\\Subscriptions.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Subscription subscription : subscriptions) {
                writer.write(subscription.getClientId() + "," + subscription.getPlanName());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // الكلاسات الداخلية الخاصة بخطط الاشتراك والاشتراكات
    public static class SubscriptionPlan {
        private String name;
        private int price;

        public SubscriptionPlan(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

    public static class Subscription {
        private String clientId;
        private String planName;

        public Subscription(String clientId, String planName) {
            this.clientId = clientId;
            this.planName = planName;
        }

        public String getClientId() {
            return clientId;
        }

        public String getPlanName() {
            return planName;
        }

        public void setPlanName(String planName) {
            this.planName = planName;
        }
    }
}

import java.time.LocalDate;
import java.util.*;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract LocalDate getRenewalDate();

    String getName() {
        return name;
    }
}

class BasicPlan extends SubscriptionPlan {

    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends SubscriptionPlan {

    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends SubscriptionPlan {

    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanRenewalReminder {

    static SubscriptionPlan createPlan(
            String type,
            String name,
            LocalDate date) {

        switch (type) {
            case "BASIC":
                return new BasicPlan(name, date);

            case "STANDARD":
                return new StandardPlan(name, date);

            case "PREMIUM":
                return new PremiumPlan(name, date);

            default:
                throw new IllegalArgumentException(
                        "Invalid plan type"
                );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            LocalDate startDate =
                    LocalDate.parse(sc.next());

            SubscriptionPlan plan =
                    createPlan(type, name, startDate);

            System.out.println(
                    plan.getName() + ": "
                    + plan.getRenewalDate()
            );
        }

        sc.close();
    }
}
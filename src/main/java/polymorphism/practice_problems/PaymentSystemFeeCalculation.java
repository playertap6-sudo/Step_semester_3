import java.util.*;

abstract class Payment {
    protected double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();
}

class CardPayment extends Payment {

    CardPayment(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount * 1.02;
    }
}

class WalletPayment extends Payment {

    WalletPayment(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount * 1.01;
    }
}

class BankTransferPayment extends Payment {

    BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount;
    }
}

public class PaymentSystemFeeCalculation {

    static Payment createPayment(
            String type,
            double amount) {

        switch (type) {
            case "CARD":
                return new CardPayment(amount);

            case "WALLET":
                return new WalletPayment(amount);

            case "BANKTRANSFER":
                return new BankTransferPayment(amount);

            default:
                throw new IllegalArgumentException(
                        "Invalid payment type"
                );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Payment payment =
                    createPayment(type, amount);

            double adjusted =
                    payment.calculateAmount();

            System.out.printf(
                    "%s: %.2f%n",
                    type,
                    adjusted
            );

            total += adjusted;
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );

        sc.close();
    }
}
import java.util.*;

abstract class Transport {
    protected double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bus extends Transport {

    Bus(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return Math.min(10, 2 + 0.10 * distance);
    }
}

class Train extends Transport {

    Train(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return 3 + 0.15 * distance;
    }
}

class Metro extends Transport {

    private double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    double calculateFare() {
        return (1.50 + 0.20 * distance)
                * peakHourFactor;
    }
}

public class PublicTransportFareCalculator {

    static Transport createTransport(
            String type,
            double distance,
            double peakHourFactor) {

        switch (type) {

            case "BUS":
                return new Bus(distance);

            case "TRAIN":
                return new Train(distance);

            case "METRO":
                return new Metro(
                        distance,
                        peakHourFactor
                );

            default:
                throw new IllegalArgumentException(
                        "Invalid transport type"
                );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            double distance =
                    sc.nextDouble();

            double peakHourFactor = 1.0;

            if (type.equals("METRO")) {
                peakHourFactor =
                        sc.nextDouble();
            }

            Transport transport =
                    createTransport(
                            type,
                            distance,
                            peakHourFactor
                    );

            double fare =
                    transport.calculateFare();

            System.out.printf(
                    "%s: %.2f%n",
                    type,
                    fare
            );

            total += fare;
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );

        sc.close();
    }
}
package basics.practice_problems;

import java.util.Random;

public class BmiCalculatorForTeam {

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("Person %d | %.2f | %.1f | %.2f | %s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];

        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.5 + random.nextDouble() * 0.5;
            weights[i] = 50 + random.nextDouble() * 50;
        }

        printWellnessReport(heights, weights);
    }
}
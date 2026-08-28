package string.class_problems;

public class BmiCalculator {

    public static void main(String[] args) {
        try {
            double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70};
            double[] weights = {70.0, 90.0, 65.0, 85.0, 75.0};

            printWellnessReport(heights, weights);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid data: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            throw new IllegalArgumentException("Heights and weights arrays must be non-null and equal length.");
        }

        System.out.printf("%-8s | %-10s | %-11s | %-6s | %-12s\n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] <= 0 || weights[i] <= 0) {
                System.out.println("Invalid height/weight for Person " + (i + 1));
                continue;
            }

            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-2d | %-10.2f | %-11.2f | %-6.2f | %-12s\n", (i + 1), heights[i], weights[i], bmi, status);
        }
    }

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}

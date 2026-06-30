public class ForecastDemo {
    public static void main(String[] args) {
        double initialInvestment = 10000.0;
        double annualGrowthRate = 0.07; // 7%
        int yearsToForecast = 10;

        double recursiveResult = ForecastCalculator.calculateFutureValue(
                initialInvestment, annualGrowthRate, yearsToForecast);
        System.out.println("Recursive forecast after " + yearsToForecast +
                " years: $" + String.format("%.2f", recursiveResult));

        double optimizedResult = ForecastCalculator.calculateFutureValueOptimized(
                initialInvestment, annualGrowthRate, yearsToForecast);
        System.out.println("Optimized (Math.pow) forecast: $" +
                String.format("%.2f", optimizedResult));
    }
}
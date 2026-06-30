public class ForecastCalculator {

    // Recursively calculates future value: FV = PV * (1 + rate)^years
    // Time complexity: O(n) where n = number of years (each call does O(1) work)
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    // Optimized iterative/closed-form version to avoid recursive call overhead
    public static double calculateFutureValueOptimized(double presentValue, double growthRate, int years) {
        return presentValue * Math.pow(1 + growthRate, years);
    }
}
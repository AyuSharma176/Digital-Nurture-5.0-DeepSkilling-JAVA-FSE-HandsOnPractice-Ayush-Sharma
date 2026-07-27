public class OperatorPrecedence {
    public static void main(String[] args) {
        int result1 = 10 + 5 * 2;       // 20 (not 30)
        int result2 = (10 + 5) * 2;     // 30
        int result3 = 10 + 6 / 2 - 1;  // 12
        System.out.println("10 + 5 * 2 = " + result1);
        System.out.println("(10 + 5) * 2 = " + result2);
        System.out.println("10 + 6 / 2 - 1 = " + result3);
    }
}
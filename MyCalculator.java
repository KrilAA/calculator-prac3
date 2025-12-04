public class MyCalculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0.0) {
            throw new ArithmeticException("Ділення на нуль неможливе");
        }
        return a / b;
    }

    public double sqrt(double x) throws InvalidInputException {
        if (x < 0) {
            throw new InvalidInputException(
                    "Для квадратного кореня число має бути не від’ємним"
            );
        }
        return Math.sqrt(x);
    }
}

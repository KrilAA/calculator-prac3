import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyCalculator calculator = new MyCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Калькулятор (Практична робота 3) ===");
        System.out.println("Доступні операції: +  -  *  /  sqrt");
        System.out.println("Приклад: + (додавання), sqrt (квадратний корінь)");

        try {
            System.out.print("Оберіть операцію (+, -, *, /, sqrt): ");
            String op = scanner.next().trim();

            double x;
            double y;

            if ("sqrt".equalsIgnoreCase(op)) {
                System.out.print("Введіть число: ");
                x = readDouble(scanner);

                double result = calculator.sqrt(x);
                System.out.println("Результат: " + result);
            } else {
                System.out.print("Введіть перше число: ");
                x = readDouble(scanner);

                System.out.print("Введіть друге число: ");
                y = readDouble(scanner);

                double result;

                switch (op) {
                    case "+" -> result = calculator.add(x, y);
                    case "-" -> result = calculator.subtract(x, y);
                    case "*" -> result = calculator.multiply(x, y);
                    case "/" -> result = calculator.divide(x, y);
                    default -> throw new InvalidInputException("Невідома операція: " + op);
                }

                System.out.println("Результат: " + result);
            }

        } catch (ArithmeticException e) {
            System.out.println("Помилка арифметики: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println("Некоректні вхідні дані: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ви ввели не число. Спробуйте ще раз.");
        } catch (Exception e) {
            System.out.println("Непередбачена помилка: " + e.getMessage());
        } finally {
            System.out.println("Обробку запиту завершено.");
            scanner.close();
        }
    }

    private static double readDouble(Scanner scanner) {
        String text = scanner.next();
        text = text.replace(',', '.');
        return Double.parseDouble(text);
    }
}

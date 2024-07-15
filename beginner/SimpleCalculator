
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result;
        char operator;

        System.out.println("Welcome to the Simple Calculator!");

        while (true) {
            // Ask the user for the first number
            System.out.print("Enter the first number: ");
            num1 = scanner.nextDouble();

            // Ask the user for the operation
            System.out.print("Enter the operation (+, -, *, /): ");
            operator = scanner.next().charAt(0);

            // Ask the user for the second number
            System.out.print("Enter the second number: ");
            num2 = scanner.nextDouble();

            // Perform the calculation based on the user's choice
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    System.out.println(num1 + " + " + num2 + " = " + result);
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.println(num1 + " - " + num2 + " = " + result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.println(num1 + " * " + num2 + " = " + result);
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println(num1 + " / " + num2 + " = " + result);
                    } else {
                        System.out.println("Error: Cannot divide by zero!");
                    }
                    break;
                default:
                    System.out.println("Invalid operation!");
                    break;
            }

            // Ask the user if they want to perform another calculation
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String answer = scanner.next().toLowerCase();
            if (!answer.equals("yes")) {
                break;
            }
        }

        System.out.println("Thank you for using the Simple Calculator!");
    }
}
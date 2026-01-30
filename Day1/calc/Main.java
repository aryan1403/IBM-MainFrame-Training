package Day1.calc;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static int acceptOperands() {
        System.out.print("Enter an integer:");
        return sc.nextInt();
    }
    public static void menu(){
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. History");
        System.out.println("0. Exit");
    }
    public static void main(String[] args) {
        // menu
        int choice;
        calc calculator = new calc();
        logs log = new logs();
        while (true) {
            System.out.println("Calculator Menu:");
            menu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Exiting calculator.");
                    System.exit(0);
                case 1:
                    int a = acceptOperands();
                    int b = acceptOperands();
                    int result = calculator.add(a, b);
                    log.addOperation(a, b, "+", result);

                    break;
                case 2:
                    System.out.println("You chose Subtraction.");
                    break;
                case 3:
                    System.out.println("You chose Multiplication.");
                    break;
                case 4:
                    System.out.println("You chose Division.");
                    break;
                case 5:
                    System.out.println("You chose History.");
                    log.showLogs();
                    break;
                default:
                    break;
            }
        }
        // int a = acceptOperands();
        // int b = acceptOperands();
        // System.out.print("Sum of " + a + " and " + b + " is: " + (a + b));
    }
}

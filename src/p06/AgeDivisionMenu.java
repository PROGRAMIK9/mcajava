import java.util.Scanner;

class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) {
        super(msg);
    }
}

public class AgeDivisionMenu {

    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18)
            throw new InvalidAgeException("Age must be 18 or above");
        System.out.println("Valid age");
    }

    // Division method
    static void divide(int a, int b) {
        if (b == 0)
            throw new ArithmeticException("Divisor cannot be zero");
        System.out.println("Result = " + (a / b));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice, age, a, b;

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Validate Age");
            System.out.println("2. Divide Numbers");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter age: ");
                        age = sc.nextInt();
                        validateAge(age);
                        break;

                    case 2:
                        System.out.print("Enter dividend: ");
                        a = sc.nextInt();
                        System.out.print("Enter divisor: ");
                        b = sc.nextInt();
                        divide(a, b);
                        break;

                    case 3:
                        System.out.println("Program terminated");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            }
            catch (InvalidAgeException e) {
                System.out.println(e.getMessage());
            }
            catch (ArithmeticException e) {
                System.out.println(e.getMessage());

            }
            
        } 
    }
}

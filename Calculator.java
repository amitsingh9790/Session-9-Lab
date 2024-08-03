import java.util.Scanner;
//Custom Exception for Invalid Operator
class InvalidOperator extends Exception{
    InvalidOperator(String message){
        super(message);
    }
}

public class Calculator {
    public static void main(String[] args) {
        // Creating object of Scanner class
        Scanner sc = new Scanner(System.in);
        char checkExit;

        // Implementing do while loop for execute code at least one time.
        do{
            System.out.print("Enter two number: ");
            // Taking input(in double) from user
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            System.out.print("Enter the Operator to perform Operation: ");
            // Taking input(in character) from user
            char Operator = sc.next().charAt(0);
            switch (Operator){
                case '+':
                    System.out.println(a+"+"+b+"="+ (a+b));
                    break;
                case '-':
                    System.out.println(a+"-"+b+"="+ (a-b));
                    break;
                case '*':
                    System.out.println(a+"*"+b+"="+ (a*b));
                    break;
                case '/':
                    // Handling ArithmeticException using try, catch and throw.
                    try {
                        if(b==0)
                            throw new ArithmeticException(); //Creating an exception object manually using new keyword when Arithmetic exception occur and Send to JVM
                        System.out.println(a+"/"+b+"="+ (a/b));
                    }
                    catch (ArithmeticException e){
                        System.out.println(e);
                        System.out.println("Error: Division by zero is not allowed.");
                    }
                    break;
                    default:
                        // Handling InvalidOperatorException using try, catch, throw and custom exception.
                        try {
                            throw new InvalidOperator(" Only enter '+', '-', '*', or '/' .");//Creating an exception object manually using new keyword when Arithmetic exception occur and Send to JVM
                        }
                        catch (InvalidOperator e){
                            System.out.println(e);
                        }
            }
            System.out.println("Enter 'Y' to exit or any other key to continue: ");
            checkExit = sc.next().charAt(0);
        }while (checkExit!='Y' && checkExit!='y');

        // Close the scanner
        sc.close();
    }
}

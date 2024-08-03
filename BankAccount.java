// Custom Exception for InsufficientBalanceException
class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(String message){
        super(message);
    }
}

// BankAccount class
public class BankAccount {
    private double balance;
    // Constructor
    BankAccount(double balance){
        this.balance = balance;
    }
    // Method to deposit
    public void deposit(double amount){
        balance+=amount;
    }
    // Method to withdraw money with exception handling
    public void withdraw(double amount){
        try {
            if(balance<amount)
                throw new InsufficientBalanceException("Withdrawal amount is should be less or equal to Current amount.");
            balance -= amount;
        }
        catch (InsufficientBalanceException e){
            System.out.println(e);
        }
    }
    // Method to get the current balance
    public double getBalance(){
        return balance;
    }
}

// Main class to test the BankAccount class
class Main{
    public static void main(String[] args) {
        BankAccount hdfc = new BankAccount(5000);
        // Display the current balance
        System.out.println("Current balance: ₹"+hdfc.getBalance()); //Output: Current balance: ₹5000.0

        hdfc.withdraw(2000);
        System.out.println("Current balance: ₹"+hdfc.getBalance()); //Output: Current balance: ₹3000.0

        hdfc.deposit(5000);
        System.out.println("Current balance: ₹"+hdfc.getBalance()); //Output: Current balance: ₹8000.0

        hdfc.withdraw(12000); //Output: InsufficientBalanceException: Withdrawal amount is should be less or equal to Current amount
        System.out.println("Current balance: ₹"+hdfc.getBalance()); //Output: Current balance: ₹8000.0
    }
}

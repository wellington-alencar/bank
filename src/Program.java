import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            var number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            var holder = sc.nextLine();
            System.out.print("Inital balance: ");
            var balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            var withdrawLimit = sc.nextDouble();
            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.print("Enter amount for withdraw: ");
            account.withdraw(sc.nextDouble());
            System.out.print("New balance: " + String.format("%.2f", account.getBalance()) );
        }
        catch (DomainException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }
    }
}
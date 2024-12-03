package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp {
    private final Scanner scanner;
    private final Bank bank;

    public BankApp(Scanner scanner, Bank bank) {
        this.scanner = scanner;
        this.bank = bank;
    }

    public void run() {
        int option;
        do {
            System.out.println("Elige una opcion:");
            System.out.println("1. Mostrar las cuentas del banco");
            System.out.println("2. Mostrar datos de una cuenta");
            System.out.println("3. Mostrar los datos de las cuentas de un cliente");
            System.out.println("4. Ingresar dinero en cuenta");
            System.out.println("5. Sacar dinero de una cuenta");
            System.out.println("6. Salir");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                bank.showAccounts();
            } else if (option == 2) {
                System.out.println("Introduce el IBAN de la cuenta");
                String iban = scanner.nextLine();
                var findAccount = bank.findAccount(iban);
                if (findAccount != null){
                    bank.showAccountIban(iban);
                } else {
                    System.out.println("No existe la cuenta");
                }
            } else if (option == 3){
                System.out.println("Introduce el NIF del cliente asociado a la cuenta");
                String nif = scanner.nextLine();
                bank.showAccountNif(nif);
            }
        } while (option != 6);
    }
}
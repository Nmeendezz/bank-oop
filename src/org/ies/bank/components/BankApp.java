package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;


import java.util.Scanner;

public class BankApp {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        int option;
        var bank = bankReader.read();
        do {
            System.out.println("Elige una opcion");
            System.out.println("1. Mostrar las cuentas del banco");
            System.out.println("2. Mostrar los datos de una cuenta");
            System.out.println("3. Mostrar los datos de las cuentas de un cliente");
            System.out.println("4. Ingresar dinero en cuenta");
            System.out.println("5. Sacar dinero de una cuenta");
            System.out.println("6. Salir");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                bank.printAccount();
            } else if (option == 2) {
                System.out.println("Introduce el IBAN de la cuenta");
                String iban = scanner.nextLine();
                var findAccount = bank.findAccount(iban);
                if (findAccount != null) {
                    bank.showAccountIban(iban);
                } else {
                    System.out.println("No existe la cuenta");
                }
            } else if (option == 3) {
                System.out.println("Introduce el NIF del cliente asociado a la cuenta");
                String nif = scanner.nextLine();
                bank.showAccountNif(nif);
            } else if (option == 4) {
                System.out.println("Introduce el IBAN de la cuenta a la que desea ingresar el dinero");
                String iban = scanner.nextLine();
                System.out.println("Ingrese la cantidad de dinero que desea ingresar");
                double money = scanner.nextDouble();
                scanner.nextLine();
                var findAccount = bank.findAccount(iban);
                if (findAccount != null) {
                    bank.addMoney(iban, money);
                    bank.showAccountIban(iban);
                }
            } else if (option == 5) {
                System.out.println("Introduce el IBAN de la cuenta a la que desea retirar el dinero");
                String iban = scanner.nextLine();
                System.out.println("Ingrese la cantidad de dinero que desea retirar");
                double money = scanner.nextDouble();
                scanner.nextLine();
                var findAccount = bank.findAccount(iban);
                if (findAccount != null) {
                    if (findAccount.getBalance() < money) {
                        System.out.println("Saldo insuficiente");
                    } else {
                        bank.takeOutMoney(iban, money);
                        bank.showAccountIban(iban);
                    }
                }
            } else if (option == 6) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opcion invalida");
            }
        }while (option != 6) ;
    }
}


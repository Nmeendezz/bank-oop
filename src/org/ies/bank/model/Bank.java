package org.ies.bank.model;


import java.util.Arrays;
import java.util.Objects;

public class Bank {
    private String name;
    private Account[] accounts;

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public void printAccount() {
        for (Account account: accounts){
            System.out.println("IBAN: " + account.getIban());
            System.out.println("Saldo: " + account.getBalance());
            System.out.println("NIF del cliente: " + account.getCliente().getNif());
        }
    }

    public Account findAccount(String iban) {
        for (Account account : accounts) {
            if (account.getIban().equals(iban)) {
                return account;
            }
        }
        return null;
    }
    public void showAccountIban(String iban){
        Account account = findAccount(iban);
        if (account.getIban().equals(iban)){
            System.out.println("IBAN: " + account.getIban());
            System.out.println("Saldo: " + account.getBalance());
            System.out.println("NIF del cliente: " + account.getCliente().getNif());
        }
    }
    public void showAccountNif(String nif){
        for (Account account: accounts){
            if (account.getCliente().getNif().equals(nif)){
                System.out.println("IBAN: " + account.getIban());
                System.out.println("Saldo: " + account.getBalance());
                System.out.println("NIF del cliente: " + account.getCliente().getNif());
            }
        }
    }
    public void addMoney(String iban, double money){
        Account account = findAccount(iban);
        if (account != null){
            account.deposit(money);
        } else {
            System.out.println("No existe la cuenta");
        }
    }
    public void takeOutMoney(String iban, double money){
        Account account = findAccount(iban);
        if (account != null){
            account.deposit(money);
        } else {
            System.out.println("No existe la cuenta");
        }
    }
    public void showCantAccounts(String nif){
        for (Account account: accounts){
            int cont = 0;
            if (account.getCliente().getNif().equals(nif)){
                cont++;
                System.out.println("Hay " + cont + " cuentas con el NIF " + nif);
            }else {
                System.out.println("No existen cuentas con el NIF " + nif);
            }
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(accounts));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}

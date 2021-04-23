package com.homework.threads.task4;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(100);

        Thread one = new Thread(() -> {
            while (bankAccount.getBalance() != 0){
                bankAccount.withdraw(45);
                System.out.println("withdraw, balance = " + bankAccount.getBalance());

                if (bankAccount.getBalance() < 0){
                    Thread.currentThread().interrupt();
                }

                if (Thread.currentThread().isInterrupted()){
                    bankAccount.addToBalance(200);
                    return;
                }
            }
        });
    }
}

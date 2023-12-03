package org.project.WorkBank.Program;

import org.project.WorkBank.BankAccount.*;

import java.util.Random;


public class WorkTransaction {
    private static Random random = new Random();

    public static void main(String[] args) {
        int startSum = 100;
        int sumCredit = 500;


        for (int i = 0; i < 5; i++) {
            System.out.printf("\nИтерация № %d______\n", i + 1);
            Account accountFirst = CreditAccount.create(startSum, sumCredit);
            Account accountSecond = DebitAccount.create(startSum);

            printInfo("Начальное состояние счетов:", accountFirst, accountSecond);

            int sum = random.nextInt(-10, 10) * startSum;
            System.out.printf("сумма перевода: %d\n", sum);

            if (random.nextInt(4) == 0) {
                accountFirst.closeAccount();
            } else if (random.nextInt(4) == 2){
                accountSecond.closeAccount();
            }

            try {
                Transaction.transfer(accountFirst, accountSecond, sum);
                System.out.println("транзакция прошла успешно");
            } catch (InsufficientFundsException | IllegalOperation | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            printInfo("Cостояние счетов после транзакции:", accountFirst, accountSecond);


        }

    }

    private static void printInfo(String description, Account accountFirst, Account accountSecond) {
        System.out.println(description);
        System.out.println("\t счет 1: " + accountFirst.info());
        System.out.println("\t счет 2: " + accountSecond.info());

    }


}

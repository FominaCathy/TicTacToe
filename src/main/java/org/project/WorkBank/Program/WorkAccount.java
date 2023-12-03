package org.project.WorkBank.Program;

import org.project.WorkBank.BankAccount.Account;
import org.project.WorkBank.BankAccount.CreditAccount;
import org.project.WorkBank.BankAccount.DebitAccount;
import org.project.WorkBank.BankAccount.InsufficientFundsException;

import java.util.Random;

/**
 * задание №1
 */
public class WorkAccount {
    private static Random random = new Random();
    private static final int maxValue = 500;

    /**
     * работа с дебетовым счетом: создаие счета и выполнение 5 пар (зачисление + списание) операций с рандомными суммами
     *
     * @param countOperation - кол-во пар (зачисление + списание) операций
     */
    public static void workDebitAccount(int countOperation) {
        int sing = (int) Math.pow(-1, random.nextInt(2));//знак суммы
        int startBalance = random.nextInt(0, maxValue) * sing;
        try {
            Account account = DebitAccount.create(startBalance);
            System.out.printf("Создан счет с начальной суммой %d \n", startBalance);
            randomTestOperation(account, countOperation);
        } catch (
                IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * работа с кредитным счетом: создаие счета и выполнение заданных пар (зачисление + списание) операций с рандомными суммами
     *
     * @param countOperation - кол-во пар (зачисление + списание) операций
     */
    public static void workCreditAccount(int countOperation) {

        int startBalance = random.nextInt(0, maxValue) * getSing(4);
        int creditLimit = random.nextInt(0, maxValue);
        try {
            Account account = CreditAccount.create(startBalance, creditLimit);
            System.out.printf("Создан счет с начальной суммой %d и кредитным лимитом: %d\n", startBalance, creditLimit);
            randomTestOperation(account, countOperation);
        } catch (
                IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    private static void randomTestOperation(Account account, int countIteration) {

        for (int i = 0; i < countIteration; i++) {
            System.out.println(i + 1);
            addSumFromAccount(account, random.nextInt(0, maxValue) * getSing(4));
            withdrawFromAccount(account, random.nextInt(0, account.getDeposit() * 2) * getSing(4));
        }
    }

    /**
     * вспомогательный метод. для получения знака суммы
     *
     * @param event - коэф для расчета процента вероятности знака "-". (1/event)
     * @return -1 или 1.
     */
    private static int getSing(int event) {
        return (random.nextInt(event) == 0) ? (-1) : 1;
    }

    /**
     * зачисление суммы на счет
     * @param account счет
     * @param sum сумма зачисления
     */
    private static void addSumFromAccount(Account account, int sum) {
        try {
            account.putSum(sum);
            System.out.printf("\t- зачислена сумма: %d. ", sum);
            System.out.println(account.info());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * списание суммы со счета
     * @param account счет
     * @param sum сумма списания
     */
    private static void withdrawFromAccount(Account account, int sum) {
        try {
            account.withdrawSum(sum);
            System.out.printf("\t- списана сумма: %d. ", sum);
            System.out.println(account.info());
        } catch (InsufficientFundsException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


}


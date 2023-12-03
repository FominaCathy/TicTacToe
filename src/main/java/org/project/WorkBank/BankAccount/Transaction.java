package org.project.WorkBank.BankAccount;

/**
 * клас для проведения транзакций между счетами
 */
public class Transaction {

    public static void transfer(Account sender, Account payee, int sum) throws IllegalOperation, InsufficientFundsException {
        if ((!sender.isActiveAccount()) || (!payee.isActiveAccount())) {
            throw new IllegalOperation("один из счетов заблокирован.");
        }
        if (sender.getDeposit() < sum) {
            throw new IllegalOperation("недостаточно средств для перевода.");
        }

        sender.withdrawSum(sum);
        payee.putSum(sum);
    }
}

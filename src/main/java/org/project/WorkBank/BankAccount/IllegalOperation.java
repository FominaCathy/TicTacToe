package org.project.WorkBank.BankAccount;

public class IllegalOperation extends Exception {
    public IllegalOperation(String message) {
        super("Невозможно совершить транзакцию: " + message);
    }
}

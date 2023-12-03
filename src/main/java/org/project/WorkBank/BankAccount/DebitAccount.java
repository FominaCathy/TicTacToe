package org.project.WorkBank.BankAccount;

/**
 * дебетовая карта
 */
public class DebitAccount extends Account {

    protected DebitAccount(int startBalance) {
        super(startBalance);
    }

    @Override
    public String info() {
        return String.format("Доступные ср-ва: %d.", getDeposit());
    }

    /**
     * создание  счета
     * @param startBalance - начальная сумма на счете. должна быть больше нуля
     * @return
     * @throws IllegalArgumentException - некорректная начальная сумма на счете
     */
    public static DebitAccount create(int startBalance) {
        if (startBalance < 0) {
            throw new IllegalArgumentException(String.format("Начальная сумма счета: %d - меньше нуля.", startBalance));
        }
        return new DebitAccount(startBalance);
    }


}

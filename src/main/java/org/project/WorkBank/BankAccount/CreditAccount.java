package org.project.WorkBank.BankAccount;

/**
 * кредитная карта. при создании карты можно указать сумму возможного кредита. (есть максимально допустимый кредит)
 */
public class CreditAccount extends Account {
    private static final int MAXLIMIT = 500;
    private int creditLimit;

    protected CreditAccount(int startBalance, int creditLimit) {
        super(startBalance+ creditLimit);
        this.creditLimit = creditLimit;
    }

    public static CreditAccount create(int startBalance, int creditLimit) {

        if (startBalance < 0) {
            throw new IllegalArgumentException(String.format("Начальная сумма счета: %d - меньше нуля.", startBalance));
        }
        if (creditLimit <= 0) {
            throw new IllegalArgumentException(String.format("Cумма кредита: %d - меньше либо равна нулю.", creditLimit));
        } else if (creditLimit > MAXLIMIT) {
            throw new IllegalArgumentException(String.format("Cумма кредита: %d - превышает мах.допустимый предел.", creditLimit));

        }
        return new CreditAccount(startBalance, creditLimit);
    }


    public int getCreditLimit() {
        return creditLimit;
    }

    public static int getMaxLimit(){
        return MAXLIMIT;
    }

    @Override
    public String info() {
        return String.format("Доступные ср-ва: %d. Из них кредитные: %d", getDeposit(), Math.min(creditLimit, getDeposit()));
    }


}

package org.project.WorkBank.BankAccount;

public abstract class Account {
    private int deposit;
    private boolean activeAccount;

    protected Account(int startBalance) {
        this.deposit = startBalance;
        this.activeAccount = true;
    }

    /**
     * списание средств со счета
     *
     * @param sum - сумма снятия
     * @throws InsufficientFundsException - если сумма снятия меньше либо равна нулю
     */
    public void withdrawSum(int sum) throws InsufficientFundsException {
        if (sum <= 0) {
            throw new IllegalArgumentException(
                    String.format("Сумма снятия: %d - должна быть больше нуля.", sum));
        }
        if (sum > this.deposit) {
            throw new InsufficientFundsException(
                    String.format("Недостаточно средств для снятия: сумма снятия =  %d, сумма на счете = %d", sum, this.deposit));
        }
        this.deposit -= sum;
    }

    /**
     * внесение средств на счет
     *
     * @param sum - сумма зачисления
     * @throws IllegalArgumentException - сумма меньше нуля
     */
    public void putSum(int sum) {
        if (sum <= 0) {
            throw new IllegalArgumentException(
                    String.format("Сумма внесения: %d - должна быть больше нуля.", sum));
        }
        this.deposit += sum;
    }

    public void closeAccount(){
        this.activeAccount = false;
    }

    public abstract String info();

    //region Getters and Setters
    public int getDeposit() {
        return deposit;
    }

    protected void setDeposit(int sum){
        this.deposit = sum;
    }

    public boolean isActiveAccount() {
        return activeAccount;
    }

    //endregion Getters
}

package org.project.WorkBank.BankAccount;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestCreditAccount {
    //TODO еще не доделала


    @ParameterizedTest(name = "{index} - сумма депозита = {0}")
    @ValueSource(ints = {100, 10, 0})
    void validCreateSum(int sum) {
        assertEquals((100 + sum), CreditAccount.create(sum, 100).getDeposit());
    }


    @Test
    void inValidCreateNegativeSumDeposit() {
        assertThrows(IllegalArgumentException.class, () -> CreditAccount.create(-1, 100));
    }

    @ParameterizedTest(name = "{index} -сумма кредита = {0}")
    @ValueSource(ints = {0, -1})
    void inValidCreateSumCredit(int sumCredit) {
        assertThrows(IllegalArgumentException.class, () -> CreditAccount.create(100, sumCredit));
    }

    //TODO как объедеить с верним тестом???
    @Test
    void inValidCreateOverflowSumCredit() {
        int maxCredit = CreditAccount.getMaxLimit() + 1;
        assertThrows(IllegalArgumentException.class, () -> CreditAccount.create(100, maxCredit));
    }

    @ParameterizedTest(name = "{index} - снятие {0} из 200 со счета")
    @ValueSource(ints = {100, 200, 300})
    void validWithdrawSum(int sum) throws InsufficientFundsException {
        Account account = CreditAccount.create(100, 100);
        int sumAccount = 200;
        try {
            account.withdrawSum(sum);
            sumAccount -= sum;
        } catch (InsufficientFundsException ignored) {
        }
        assertEquals(sumAccount, account.getDeposit());
    }

    @Test
    void inValidWithdrawSumOverflow() {
        Account account = CreditAccount.create(100, 100);
        Throwable throwable = assertThrows(InsufficientFundsException.class, () -> account.withdrawSum(201));
        //TODO проверка сообщения
        String mess = "Недостаточно средств для снятия: сумма снятия =  201, сумма на счете = 200";
        assertEquals(mess, throwable.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void inValidWithdrawSum(int sumWithdraw) {
        Account account = CreditAccount.create(100, 100);
        assertThrows(IllegalArgumentException.class, () -> account.withdrawSum(sumWithdraw));
    }


//    @ParameterizedTest
//    @ValueSource()
//    void validPutSum() {
//
//    }
}

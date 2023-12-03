package org.project.WorkBank.BankAccount;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCreditAccount {
    //TODO еще не доделал

    @ParameterizedTest
    @ValueSource(ints = {100, 10, 0})
    void validCreateSum(int sum) {
        assertEquals((100 + sum), CreditAccount.create(sum, 100).getDeposit());
    }


    @Test
    void inValidCreateNegativeSumDeposit() {
        assertThrows(IllegalArgumentException.class, () -> CreditAccount.create(-1, 100));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void inValidCreateSumCredit(int sumCredit) {
        assertThrows(IllegalArgumentException.class, () -> CreditAccount.create(100, sumCredit));
    }


    @Test
    void inValidCreateOverflowSumCredit() {
        int sumCredit = CreditAccount.getMaxLimit() + 1;
        assertThrows(IllegalArgumentException.class, () -> CreditAccount.create(100, sumCredit));
    }

    @Test
    void validWithdrawSum() {
        Account account = CreditAccount.create(100, 100);
        try {
            account.withdrawSum(200);
        } catch (InsufficientFundsException ignored) {

        } finally {
            assertEquals(0, account.getDeposit());
        }
    }

    @Test
    void inValidWithdrawSumOverflow() {
        Account account = CreditAccount.create(100, 100);
        assertThrows(InsufficientFundsException.class, () -> account.withdrawSum(201));
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

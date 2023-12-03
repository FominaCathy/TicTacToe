package org.project.WorkBank.Program;


import java.util.Random;

public class WorkCreditAccount {
    private static Random random = new Random();

    public static void main(String[] args) {

        //кредитая карта
        for (int j = 0; j < 5; j++) {
            System.out.printf("\n_Итерация %d______________\n", j + 1);
            WorkAccount.workCreditAccount(5);
        }
    }

}

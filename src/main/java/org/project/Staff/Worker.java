package org.project.Staff;

/**
 * класс содрудников с фиксированной з/п, которая определяется при найме индивидуально
 */
public class Worker extends Employee {
    private double rateFix;

    private Worker(String firstName, String lastName, int rateFix) {
        super(firstName, lastName);
        this.rateFix = rateFix;
    }

    public static Worker create(String firstName, String lastName, int rateFix) {
        if (rateFix < 0) {
            throw new RuntimeException("Некорректная з/п.");
        }
        return new Worker(firstName, lastName, rateFix);
    }


    public double getRateFix() {
        return rateFix;
    }

    public void setRateFix(double rateFix) {
        if (rateFix > this.rateFix) {
            this.rateFix = rateFix;
        }
    }

    @Override
    public double getSalary() {
        //«среднемесячная заработная плата = фиксированная месячная оплата».
        return rateFix;
    }
}

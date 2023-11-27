package org.project.Staff;

/**
 * класс сотрудников на почасовой ставке, которая определяется индивидуально для каждого сотрудника
 */
public class Freelancer extends Employee  {
    double rateHourly;

    private Freelancer(String firstName, String lastName, double rateHourly) {
        super(firstName, lastName);
        this.rateHourly = rateHourly;
    }


    public static Freelancer create(String firstName, String lastName, double rateHourly) {
        if (rateHourly < 0) {
            throw new RuntimeException("Некорректная з/п.");
        }
        return new Freelancer(firstName, lastName, rateHourly);
    }

    @Override
    public double getSalary() {
        // «среднемесячная заработная плата = 20.8 * 8 * почасовая ставка»,
        return rateHourly * 20.8 * 8;
    }


}

package org.project.Staff;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Employee workerFirst = Worker.create("Big", "Tusik", 150);
        Employee workerSecond = Worker.create("Small", "Tommik", 200);
        Employee freelancerFirst = Freelancer.create("Black", "Barsik", 5);
        Employee freelancerSecond = Freelancer.create("White", "Vaska", 10);
        //лист сотрудников
        List<Employee> employees = new ArrayList<>();
        employees.add(workerFirst);
        employees.add(workerSecond);
        employees.add(freelancerFirst);
        employees.add(freelancerSecond);

        // сортировка по фамилии
        Collections.sort(employees);
        printListEmployee(employees, "\nSort by First name:");

        // сотрировка по з/п. с помощью компаратора
        Comparator bySalary = new SortBySalaryComparator();
        Collections.sort(employees, bySalary);
        printListEmployee(employees, "\nSort by salary:");

        // второй вариант создания правила сортировки с помощью comparing
        Comparator<Employee> sortByLastName = Comparator.comparing(Employee::getLastName);
        Collections.sort(employees, sortByLastName);
        printListEmployee(employees, "\nSort by last name:");

        //создание класса с итератором и перебор его с помощью foreach
        System.out.println("\nIterator");
        Office office = new Office(employees);
        office.addEmployee(Worker.create("Litlle", "Rex", 2000));
        for (Employee employee : office) {
            System.out.println(employee);
        }

    }

    /**
     * вспомогатеьный метод для печати списка
     * @param employees List сотрудников
     * @param description заголовок списка
     */
    private static void printListEmployee(List<Employee> employees, String description) {
        System.out.println(description);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

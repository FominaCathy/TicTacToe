package org.project.Staff;

public abstract class Employee implements  Comparable<Employee>{
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int compareTo(Employee o) {
        return firstName.compareTo(o.firstName);
    }

    public abstract double getSalary();

    @Override
    public String toString() {
        return String.format("%s %s. salary = %.2f", this.firstName, this.lastName,  this.getSalary());
    }
}

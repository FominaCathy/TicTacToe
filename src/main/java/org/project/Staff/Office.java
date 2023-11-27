package org.project.Staff;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * класс для создания коллекции сотрудников
 */
public class Office implements Iterable<Employee>{
    private List <Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public Office(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Office (){
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        this.employeeList.add(employee);
    }

    @Override
    public Iterator iterator() {
        return new OfficeIterator(this);
    }

}

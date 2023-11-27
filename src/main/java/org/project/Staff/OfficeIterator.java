package org.project.Staff;

import java.util.Iterator;
import java.util.List;

public class OfficeIterator implements Iterator<Employee> {
    private int cursor;
    private int size;
    List<Employee> list;

    public OfficeIterator(Office office) {
        this.cursor = 0;
        this.size = office.getEmployeeList().size();
        this.list = office.getEmployeeList();
    }

    @Override
    public boolean hasNext() {
        return this.cursor < this.size;
    }

    @Override
    public Employee next() {
        return this.list.get(cursor++);
    }
}

package co.com.sofkau.icecreamshop.manager.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.icecreamshop.manager.values.EmployeeId;
import co.com.sofkau.icecreamshop.manager.values.Name;
import co.com.sofkau.icecreamshop.manager.values.Salary;

import java.util.Objects;

public class Employee extends Entity<EmployeeId> {
    private Name name;
    private Salary salary;

    public Employee(EmployeeId employeeId, Name name, Salary salary) {
        super(employeeId);
        this.name = name;
        this.salary = salary;
    }

    //Commands
    public void updateSalary(Salary salary){this.salary = Objects.requireNonNull(salary);
    }

    //Getters
    public Name getName() {
        return name;
    }

    public Salary getSalary() {
        return salary;
    }
}

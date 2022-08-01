package co.com.sofkau.icecreamshop.manager.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.manager.values.EmployeeId;
import co.com.sofkau.icecreamshop.manager.values.Name;
import co.com.sofkau.icecreamshop.manager.values.Salary;

public class EmployeeHired extends DomainEvent {
    private final EmployeeId employeeId;
    private final Name name;
    private final Salary salary;

    public EmployeeHired(EmployeeId employeeId, Name name, Salary salary) {
        super("sofka.manager.employeehired");
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    //Getters
    public EmployeeId getEmployeeId() {
        return employeeId;
    }

    public Name getName() {
        return name;
    }

    public Salary getSalary() {
        return salary;
    }
}

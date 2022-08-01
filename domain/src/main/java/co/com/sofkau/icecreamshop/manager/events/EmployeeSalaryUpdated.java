package co.com.sofkau.icecreamshop.manager.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.manager.values.EmployeeId;
import co.com.sofkau.icecreamshop.manager.values.Salary;

public class EmployeeSalaryUpdated extends DomainEvent {
    private final EmployeeId employeeId;
    private final Salary salary;

    public EmployeeSalaryUpdated(EmployeeId employeeId, Salary salary) {
        super("sofka.manager.employeesalaryupdated");
        this.employeeId = employeeId;
        this.salary = salary;
    }

    //Getters
    public EmployeeId getEmployeeId() {
        return employeeId;
    }

    public Salary getSalary() {
        return salary;
    }
}

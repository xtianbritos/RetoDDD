package co.com.sofkau.icecreamshop.manager.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.icecreamshop.manager.values.EmployeeId;
import co.com.sofkau.icecreamshop.manager.values.ManagerId;
import co.com.sofkau.icecreamshop.manager.values.Salary;

public class UpdateEmployeeSalary extends Command {
    private final ManagerId managerId;
    private final EmployeeId employeeId;
    private final Salary salary;

    public UpdateEmployeeSalary(ManagerId managerId, EmployeeId employeeId, Salary salary) {
        this.managerId = managerId;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    //Getters
    public ManagerId getManagerId() {
        return managerId;
    }

    public EmployeeId getEmployeeId() {
        return employeeId;
    }

    public Salary getSalary() {
        return salary;
    }
}

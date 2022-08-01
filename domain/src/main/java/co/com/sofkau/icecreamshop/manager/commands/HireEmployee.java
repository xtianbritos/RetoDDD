package co.com.sofkau.icecreamshop.manager.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.icecreamshop.manager.values.EmployeeId;
import co.com.sofkau.icecreamshop.manager.values.Name;
import co.com.sofkau.icecreamshop.manager.values.Salary;

public class HireEmployee extends Command {
    private final EmployeeId employeeId;
    private final Name name;
    private final Salary salary;

    public HireEmployee(EmployeeId employeeId, Name name, Salary salary) {
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

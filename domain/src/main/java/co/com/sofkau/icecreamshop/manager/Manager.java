package co.com.sofkau.icecreamshop.manager;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.manager.entities.Distributor;
import co.com.sofkau.icecreamshop.manager.entities.Employee;
import co.com.sofkau.icecreamshop.manager.events.*;
import co.com.sofkau.icecreamshop.manager.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Manager extends AggregateEvent<ManagerId> {
    protected Name name;
    protected Set<Employee> employeeSet;
    protected Set<Distributor> distributorSet;


    public Manager(ManagerId managerId, Name name) {
        super(managerId);
        appendChange(new ManagerCreated(name)).apply();
    }

    private Manager(ManagerId managerId) {
        super(managerId);
        subscribe(new ManagerChange(this));
    }

    public static Manager from(ManagerId managerId, List<DomainEvent> domainEvents) {
        Manager manager = new Manager(managerId);
        domainEvents.forEach(manager::applyEvent);
        return manager;
    }


    //Commands
    public void hireEmployee(Name name, Salary salary) {
        EmployeeId employeeId = new EmployeeId();
        appendChange(new EmployeeHired(employeeId, name, salary)).apply();
    }

    public void updateEmployeeSalary(EmployeeId employeeId, Salary salary) {
        appendChange(new EmployeeSalaryUpdated(employeeId, salary)).apply();
    }

    public void addDistributor(Commodity commodity, Cost cost) {
        DistributorId distributorId = new DistributorId();
        appendChange(new DistributorAdded(distributorId, commodity, cost)).apply();
    }

    public void updateDistributorCost(DistributorId distributorId, Cost cost) {
        appendChange(new DistributorCostUpdated(distributorId, cost)).apply();
    }


    //Getters
    public Optional<Employee> getEmployeeById(EmployeeId employeeId) {
        return getEmployeeSet()
                .stream()
                .filter(product -> product.identity().equals(employeeId))
                .findFirst();
    }

    public Optional<Distributor> getDistributorById(DistributorId distributorId) {
        return getDistributorSet()
                .stream()
                .filter(product -> product.identity().equals(distributorId))
                .findFirst();
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public Set<Distributor> getDistributorSet() {
        return distributorSet;
    }

    public Name getName() {
        return name;
    }
}

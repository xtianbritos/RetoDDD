package co.com.sofkau.icecreamshop.manager;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.icecreamshop.manager.entities.Distributor;
import co.com.sofkau.icecreamshop.manager.entities.Employee;
import co.com.sofkau.icecreamshop.manager.events.*;

import java.util.HashSet;

public class ManagerChange extends EventChange {
}
    public ManagerChange(Manager manager) {

        apply((ManagerCreated event) -> {
            manager.employeeSet = new HashSet<>();
            manager.distributorSet = new HashSet<>();
            manager.name = event.getName();
        });

        apply((EmployeeHired event) -> {
            manager.employeeSet.add(new Employee(event.getEmployeeId(), event.getName(), event.getSalary()));
        });

        apply((DistributorAdded event) -> {
            manager.distributorSet.add(new Distributor(event.getDistributorId(), event.getCommodity(), event.getCost()));
        });

        apply((EmployeeSalaryUpdated event) -> {
            var employee = manager.getEmployeeById(event.getEmployeeId())
                    .orElseThrow(() -> new IllegalArgumentException("Employee not found"));
            employee.updateSalary(event.getSalary());
        });

        apply((DistributorCostUpdated event) -> {
            var distributor = manager.getDistributorById(event.getDistributorId())
                    .orElseThrow(() -> new IllegalArgumentException("Distributor not found"));
            distributor.updateCost(event.getCost());
        });
    }
}

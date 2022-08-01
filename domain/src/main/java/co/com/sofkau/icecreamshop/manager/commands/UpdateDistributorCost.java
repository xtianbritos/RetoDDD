package co.com.sofkau.icecreamshop.manager.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.icecreamshop.manager.values.*;

public class UpdateDistributorCost extends Command {
    private final ManagerId managerId;
    private final DistributorId distributorId;
    private final Cost cost;

    public UpdateDistributorCost(ManagerId managerId, DistributorId distributorId, Cost cost) {
        this.managerId = managerId;
        this.distributorId = distributorId;
        this.cost = cost;
    }

    //Getters
    public ManagerId getManagerId() {
        return managerId;
    }

    public DistributorId getDistributorId() {
        return distributorId;
    }

    public Cost getCost() {
        return cost;
    }
}

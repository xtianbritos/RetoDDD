package co.com.sofkau.icecreamshop.manager.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.manager.values.Cost;
import co.com.sofkau.icecreamshop.manager.values.DistributorId;

public class DistributorCostUpdated extends DomainEvent {
    private final DistributorId distributorId;
    private final Cost cost;

    public DistributorCostUpdated(DistributorId distributorId, Cost cost) {
        super("sofka.manager.distributorcostupdatd");
        this.distributorId = distributorId;
        this.cost = cost;
    }

    //Getters
    public DistributorId getDistributorId() {
        return distributorId;
    }

    public Cost getCost() {
        return cost;
    }
}

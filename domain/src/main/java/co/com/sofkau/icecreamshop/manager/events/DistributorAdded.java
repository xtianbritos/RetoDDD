package co.com.sofkau.icecreamshop.manager.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.manager.entities.Distributor;
import co.com.sofkau.icecreamshop.manager.values.*;

public class DistributorAdded extends DomainEvent {
    private final DistributorId distributorId;
    private final Commodity commodity;
    private final Cost cost;

    public DistributorAdded(DistributorId distributorId, Commodity commodity, Cost cost) {
        super("sofka.manager.distributoradded");
        this.distributorId = distributorId;
        this.commodity = commodity;
        this.cost = cost;
    }

    //Getters

    public DistributorId getDistributorId() {
        return distributorId;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public Cost getCost() {
        return cost;
    }
}

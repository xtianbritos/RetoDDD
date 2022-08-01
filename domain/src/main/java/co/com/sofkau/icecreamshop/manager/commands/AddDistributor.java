package co.com.sofkau.icecreamshop.manager.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.icecreamshop.manager.values.*;

public class AddDistributor extends Command {
    private final DistributorId distributorId;
    private final Commodity commodity;
    private final Cost cost;

    public AddDistributor(DistributorId distributorId, Commodity commodity, Cost cost) {
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

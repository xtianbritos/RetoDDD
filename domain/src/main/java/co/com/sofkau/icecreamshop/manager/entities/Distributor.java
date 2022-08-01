package co.com.sofkau.icecreamshop.manager.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.icecreamshop.manager.values.Commodity;
import co.com.sofkau.icecreamshop.manager.values.Cost;
import co.com.sofkau.icecreamshop.manager.values.DistributorId;

import java.util.Objects;

public class Distributor extends Entity<DistributorId> {
    private Commodity commodity;
    private Cost cost;

    public Distributor(DistributorId distributorId, Commodity commodity, Cost cost) {
        super(distributorId);
        this.commodity = commodity;
        this.cost = cost;
    }

    //Commands
    public void updateCost(Cost cost){this.cost = Objects.requireNonNull(cost);
    }

    //Getters

    public Commodity getCommodity() {
        return commodity;
    }

    public Cost getCost() {
        return cost;
    }
}


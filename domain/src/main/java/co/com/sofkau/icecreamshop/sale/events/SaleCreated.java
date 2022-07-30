package co.com.sofkau.icecreamshop.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.sale.values.Name;

import java.util.Set;

public class SaleCreated extends DomainEvent {
    protected Name name;

    public SaleCreated(Name name) {
        super("sofka.sale.salecreated");
        this.name = name;
    }

    //Getters
    public Name getName() {
        return name;
    }
}

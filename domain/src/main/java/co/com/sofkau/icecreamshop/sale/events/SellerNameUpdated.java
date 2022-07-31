package co.com.sofkau.icecreamshop.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.sale.values.Name;

public class SellerNameUpdated extends DomainEvent {
    private final Name name;

    public SellerNameUpdated(Name name) {
        super("sofka.sale.sellerupdated");
        this.name = name;
    }

    //Getters
    public Name getName() {
        return name;
    }

}

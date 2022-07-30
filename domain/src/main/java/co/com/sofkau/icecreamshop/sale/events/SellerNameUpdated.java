package co.com.sofkau.icecreamshop.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.sale.values.Name;
import co.com.sofkau.icecreamshop.sale.values.SellerId;

public class SellerNameUpdated extends DomainEvent {
    private final Name name;
    private final SellerId sellerId;

    public SellerNameUpdated(SellerId sellerId, Name name) {
        super("sofka.sale.sellerupdated");
        this.sellerId = sellerId;
        this.name = name;
    }

    //Getters
    public Name getName() {
        return name;
    }

    public SellerId getSellerId() {
        return sellerId;
    }
}

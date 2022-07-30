package co.com.sofkau.icecreamshop.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.sale.values.Name;
import co.com.sofkau.icecreamshop.sale.values.PhoneNumber;
import co.com.sofkau.icecreamshop.sale.values.SellerId;

public class SellerAdded extends DomainEvent {
    private final Name name;
    private final PhoneNumber phoneNumber;
    private final SellerId sellerId;

    public SellerAdded(SellerId sellerId, Name name, PhoneNumber phoneNumber) {
        super("sofka.sale.sellercreated");
        this.sellerId = sellerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //Getters
    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public SellerId getSellerId() {
        return sellerId;
    }
}

package co.com.sofkau.icecreamshop.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.sale.values.PhoneNumber;
import co.com.sofkau.icecreamshop.sale.values.SellerId;

public class SellerPhoneNumberUpdated extends DomainEvent {
    private final PhoneNumber phoneNumber;
    private final SellerId sellerId;

    public SellerPhoneNumberUpdated(SellerId sellerId, PhoneNumber phoneNumber) {
        super("sofka.sale.sellerphonenumberupdated");
        this.sellerId = sellerId;
        this.phoneNumber = phoneNumber;
    }

    //Getters
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public SellerId getSellerId() {
        return sellerId;
    }
}

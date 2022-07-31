package co.com.sofkau.icecreamshop.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.sale.values.PhoneNumber;

public class SellerPhoneNumberUpdated extends DomainEvent {
    private final PhoneNumber phoneNumber;

    public SellerPhoneNumberUpdated(PhoneNumber phoneNumber) {
        super("sofka.sale.sellerphonenumberupdated");
        this.phoneNumber = phoneNumber;
    }

    //Getters
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

}

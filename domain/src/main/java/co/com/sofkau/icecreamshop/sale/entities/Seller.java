package co.com.sofkau.icecreamshop.sale.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.icecreamshop.sale.values.Name;
import co.com.sofkau.icecreamshop.sale.values.PhoneNumber;
import co.com.sofkau.icecreamshop.sale.values.SellerId;

import java.util.Objects;

public class Seller extends Entity<SellerId> {
    private Name name;
    private PhoneNumber phoneNumber;

    public Seller(SellerId sellerId, Name name, PhoneNumber phoneNumber) {
        super(sellerId);
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void updateName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    public void updatePhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
    }

    //Getters
    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}

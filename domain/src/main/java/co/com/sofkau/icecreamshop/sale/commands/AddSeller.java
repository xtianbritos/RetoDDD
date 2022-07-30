package co.com.sofkau.icecreamshop.sale.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.icecreamshop.sale.values.Name;
import co.com.sofkau.icecreamshop.sale.values.PhoneNumber;
import co.com.sofkau.icecreamshop.sale.values.SellerId;

public class AddSeller extends Command {
    private SellerId sellerId;
    private PhoneNumber phoneNumber;
    private Name name;

    public AddSeller(SellerId sellerId, Name name, PhoneNumber phoneNumber) {
        this.sellerId = sellerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //Getters
    public SellerId getSellerId() {
        return sellerId;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Name getName() {
        return name;
    }
}

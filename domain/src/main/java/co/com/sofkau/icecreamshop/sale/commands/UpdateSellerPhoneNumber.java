package co.com.sofkau.icecreamshop.sale.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.icecreamshop.sale.values.PhoneNumber;
import co.com.sofkau.icecreamshop.sale.values.SellerId;

public class UpdateSellerPhoneNumber extends Command {
    private final SellerId sellerId;
    private final PhoneNumber phoneNumber;

    public UpdateSellerPhoneNumber(SellerId sellerId, PhoneNumber phoneNumber) {
        this.sellerId = sellerId;
        this.phoneNumber = phoneNumber;
    }

    //Getters
    public SellerId getSellerId() {
        return sellerId;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}

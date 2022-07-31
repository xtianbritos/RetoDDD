package co.com.sofkau.icecreamshop.sale.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.icecreamshop.sale.values.Name;
import co.com.sofkau.icecreamshop.sale.values.PhoneNumber;
import co.com.sofkau.icecreamshop.sale.values.SaleId;
import co.com.sofkau.icecreamshop.sale.values.SellerId;

public class AddSeller extends Command {
    private SaleId saleId;
    private PhoneNumber phoneNumber;
    private Name name;

    public AddSeller(SaleId saleId, Name name, PhoneNumber phoneNumber) {
        this.saleId = saleId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //Getters
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Name getName() {
        return name;
    }

    public SaleId getSaleId() {
        return saleId;
    }
}

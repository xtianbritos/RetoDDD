package co.com.sofkau.icecreamshop.sale.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.icecreamshop.sale.values.PhoneNumber;
import co.com.sofkau.icecreamshop.sale.values.SaleId;

public class UpdateSellerPhoneNumber extends Command {
    private final SaleId saleId;
    private final PhoneNumber phoneNumber;

    public UpdateSellerPhoneNumber(SaleId saleId, PhoneNumber phoneNumber) {
        this.saleId = saleId;
        this.phoneNumber = phoneNumber;
    }

    //Getters
    public SaleId getSaleId() {
        return saleId;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}

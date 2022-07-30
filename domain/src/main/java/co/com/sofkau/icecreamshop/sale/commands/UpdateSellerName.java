package co.com.sofkau.icecreamshop.sale.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.icecreamshop.sale.values.Name;
import co.com.sofkau.icecreamshop.sale.values.SellerId;

public class UpdateSellerName extends Command {
    private final SellerId sellerId;
    private final Name name;

    public UpdateSellerName(SellerId sellerId, Name name) {
        this.sellerId = sellerId;
        this.name = name;
    }

    //Getters
    public SellerId getSellerId() {
        return sellerId;
    }

    public Name getName() {
        return name;
    }
}

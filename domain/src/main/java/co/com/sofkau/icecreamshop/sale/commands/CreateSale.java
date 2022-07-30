package co.com.sofkau.icecreamshop.sale.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.icecreamshop.sale.values.Name;
import co.com.sofkau.icecreamshop.sale.values.SaleId;

public class CreateSale extends Command {
    final SaleId saleId;
    final Name name;

    public CreateSale(SaleId saleId, Name name) {
        this.saleId = saleId;
        this.name = name;
    }

    //Getters
    public SaleId getSaleId() {
        return saleId;
    }

    public Name getName() {
        return name;
    }
}

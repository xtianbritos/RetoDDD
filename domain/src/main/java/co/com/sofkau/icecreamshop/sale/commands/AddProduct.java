package co.com.sofkau.icecreamshop.sale.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.icecreamshop.sale.values.Name;
import co.com.sofkau.icecreamshop.sale.values.Price;
import co.com.sofkau.icecreamshop.sale.values.SaleId;

public class AddProduct extends Command {
    private final SaleId saleId;
    private final Name name;
    private final Price price;

    public AddProduct(SaleId saleId, Name name, Price price) {
        this.saleId = saleId;
        this.name = name;
        this.price = price;
    }

    //Getters

    public SaleId getSaleId() {
        return saleId;
    }

    public Name getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }
}

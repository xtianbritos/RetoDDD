package co.com.sofkau.icecreamshop.sale.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.icecreamshop.sale.values.Amount;
import co.com.sofkau.icecreamshop.sale.values.Name;
import co.com.sofkau.icecreamshop.sale.values.Price;
import co.com.sofkau.icecreamshop.sale.values.ProductId;

import java.util.Objects;

public class Product extends Entity<ProductId> {
    private Price price;
    private Name name;
    private Amount amount;

    public Product(ProductId productId, Name name, Amount amount) {
        super(productId);
        this.name = name;
        this.amount = amount;
    }

    //Commands
    public void updatePrice(Price price){this.price = Objects.requireNonNull(price);
    }

    //Getters
    public Price price() {
        return price;
    }

    public Name name() {
        return name;
    }

    public Amount amount() {
        return amount;
    }
}

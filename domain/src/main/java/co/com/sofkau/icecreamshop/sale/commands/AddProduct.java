package co.com.sofkau.icecreamshop.sale.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.icecreamshop.sale.values.Amount;
import co.com.sofkau.icecreamshop.sale.values.Name;
import co.com.sofkau.icecreamshop.sale.values.Price;
import co.com.sofkau.icecreamshop.sale.values.ProductId;

public class AddProduct extends Command {
    private final ProductId productId;
    private final Name name;
    private final Amount amount;
    private final Price price;

    public AddProduct(ProductId productId, Name name, Amount amount, Price price) {
        this.productId = productId;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    //Getters
    public ProductId getProductId() {
        return productId;
    }

    public Name getName() {
        return name;
    }

    public Amount getAmount() {
        return amount;
    }

    public Price getPrice() {
        return price;
    }
}

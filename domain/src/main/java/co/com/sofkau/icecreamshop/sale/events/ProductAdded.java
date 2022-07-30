package co.com.sofkau.icecreamshop.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.sale.values.Amount;
import co.com.sofkau.icecreamshop.sale.values.Name;
import co.com.sofkau.icecreamshop.sale.values.ProductId;


public class ProductAdded extends DomainEvent {
    private final ProductId productId;
    private final Name name;
    private final Amount amount;
    public ProductAdded(ProductId productId, Name name, Amount amount) {
        super("sofka.sale.productadded");
        this.amount = amount;
        this.productId = productId;
        this.name = name;
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
}

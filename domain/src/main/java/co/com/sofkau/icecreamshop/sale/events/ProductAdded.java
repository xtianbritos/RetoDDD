package co.com.sofkau.icecreamshop.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.sale.values.Name;
import co.com.sofkau.icecreamshop.sale.values.ProductId;


public class ProductAdded extends DomainEvent {
    private final ProductId productId;
    private final Name name;
    public ProductAdded(ProductId productId, Name name) {
        super("sofka.sale.productadded");
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

}

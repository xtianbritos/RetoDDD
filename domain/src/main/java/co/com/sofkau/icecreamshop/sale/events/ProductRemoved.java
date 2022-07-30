package co.com.sofkau.icecreamshop.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.sale.values.ProductId;

public class ProductRemoved extends DomainEvent {
    private final boolean wasDeleted;
    private final ProductId productId;

    public ProductRemoved(ProductId productId) {
        super("sofka.sale.productremoved");
        this.productId = productId;
        this.wasDeleted = true;
    }

    //Getters
    public boolean getWasDeleted() {
        return wasDeleted;
    }

    public ProductId getProductId() {
        return productId;
    }
}

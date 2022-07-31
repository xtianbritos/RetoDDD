package co.com.sofkau.icecreamshop.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.sale.values.Name;
import co.com.sofkau.icecreamshop.sale.values.Price;
import co.com.sofkau.icecreamshop.sale.values.ProductId;
import co.com.sofkau.icecreamshop.sale.values.SaleId;


public class ProductAdded extends DomainEvent {
    private final ProductId productId;
    private final Name name;
    private final Price price;

    public ProductAdded(ProductId productId, Name name, Price price) {
        super("sofka.sale.productadded");
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    //Getters
    public ProductId getProductId() {
        return productId;
    }

    public Name getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }
}

package co.com.sofkau.icecreamshop.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.sale.values.Price;
import co.com.sofkau.icecreamshop.sale.values.ProductId;

public class ProductPriceUpdated extends DomainEvent {
    private final ProductId productId;
    private final Price price;

    public ProductPriceUpdated(ProductId productId, Price price) {
        super("sofka.sale.productpriceupdated");
        this.productId = productId;
        this.price = price;
    }

    //Getters
    public ProductId getProductId() {
        return productId;
    }

    public Price getPrice() {
        return price;
    }
}

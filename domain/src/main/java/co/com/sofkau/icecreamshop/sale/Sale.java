package co.com.sofkau.icecreamshop.sale;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.sale.entities.Product;
import co.com.sofkau.icecreamshop.sale.entities.Seller;
import co.com.sofkau.icecreamshop.sale.events.*;
import co.com.sofkau.icecreamshop.sale.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Sale extends AggregateEvent<SaleId>{
    protected Name name;
    protected Set<Product> productSet;
    protected Seller seller;

    public Sale(SaleId saleId, Name name) {
        super(saleId);
        appendChange(new SaleCreated(name)).apply();
    }

    private Sale(SaleId saleId) {
        super(saleId);
        subscribe(new SaleChange(this));
    }

    public static Sale from(SaleId saleId, List<DomainEvent> domainEvents) {
        Sale sale = new Sale(saleId);
        domainEvents.forEach(sale::applyEvent);
        return sale;
    }

    //Commands
    public void addProduct(Name name, Price price) {
        ProductId productId = new ProductId();
        appendChange(new ProductAdded(productId, name, price)).apply();
    }

    public void removeProduct(ProductId productId) {
        appendChange(new ProductRemoved(productId)).apply();
    }

    public void updateProductPrice(ProductId productId, Price price) {
        appendChange(new ProductPriceUpdated(productId, price)).apply();
    }

    public void addSeller(Name name, PhoneNumber phoneNumber) {
        SellerId sellerId = new SellerId();
        Objects.requireNonNull(name);
        Objects.requireNonNull(phoneNumber);
        appendChange(new SellerAdded(sellerId, name, phoneNumber)).apply();
    }

    public void updateSellerName(SellerId sellerId, Name name) {
        appendChange(new SellerNameUpdated(sellerId, name)).apply();
    }
    public void updateSellerPhoneNumber(SellerId sellerId, PhoneNumber phoneNumber) {
        appendChange(new SellerPhoneNumberUpdated(sellerId, phoneNumber)).apply();
    }


    //Getters
    public Optional<Product> getProductById(ProductId productId) {
        return productSet()
                .stream()
                .filter(product -> product.identity().equals(productId))
                .findFirst();
    }
    public Set<Product> productSet() {
        return productSet;
    }

    public Seller getSeller() {
        return seller;
    }
}

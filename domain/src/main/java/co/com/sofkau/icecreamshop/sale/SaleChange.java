package co.com.sofkau.icecreamshop.sale;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.icecreamshop.sale.entities.Product;
import co.com.sofkau.icecreamshop.sale.entities.Seller;
import co.com.sofkau.icecreamshop.sale.events.*;

import java.util.HashSet;

public class SaleChange extends EventChange {

    public SaleChange(Sale sale) {

        apply((SaleCreated event) -> {
            sale.productSet = new HashSet<>();
            sale.name = event.getName();
        });

        apply((ProductAdded event) -> {
            sale.productSet.add(new Product(event.getProductId(), event.getName()));
        });

        apply((ProductRemoved event) -> {
            sale.productSet.removeIf(product -> product.identity().equals(event.getProductId()));
        });

        apply((ProductPriceUpdated event) -> {
            var product = sale.getProductById(event.getProductId())
                    .orElseThrow(() -> new IllegalArgumentException("Product of sale not found"));
            product.updatePrice(event.getPrice());
        });

        apply((SellerAdded event) -> {
            sale.seller = new Seller(event.getSellerId(), event.getName(), event.getPhoneNumber());
        });

        apply((SellerNameUpdated event) -> {
            sale.seller.updateName(event.getName());
        });

        apply((SellerPhoneNumberUpdated event) -> {
            sale.seller.updatePhoneNumber(event.getPhoneNumber());
        });
    }
}

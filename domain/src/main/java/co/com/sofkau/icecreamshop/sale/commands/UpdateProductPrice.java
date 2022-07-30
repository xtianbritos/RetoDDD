package co.com.sofkau.icecreamshop.sale.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.icecreamshop.sale.values.Price;
import co.com.sofkau.icecreamshop.sale.values.ProductId;
import co.com.sofkau.icecreamshop.sale.values.SaleId;

public class UpdateProductPrice extends Command {
    private final SaleId saleId;
    private final ProductId productId;
    private final Price price;

    public UpdateProductPrice(SaleId saleId, ProductId productId, Price price) {
        this.saleId = saleId;
        this.productId = productId;
        this.price = price;
    }

    //Getters
    public SaleId getSaleId() {
        return saleId;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Price getprice() {
        return price;
    }
}

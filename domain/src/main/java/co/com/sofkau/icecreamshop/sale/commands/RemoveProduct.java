package co.com.sofkau.icecreamshop.sale.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.icecreamshop.sale.values.ProductId;
import co.com.sofkau.icecreamshop.sale.values.SaleId;

public class RemoveProduct extends Command {
    private final SaleId saleId;
    private final ProductId productId;

    public RemoveProduct(SaleId saleId, ProductId productId) {
        this.saleId = saleId;
        this.productId = productId;
    }

    //Getters
    public SaleId getSaleId() {
        return saleId;
    }

    public ProductId getProductId() {
        return productId;
    }
}

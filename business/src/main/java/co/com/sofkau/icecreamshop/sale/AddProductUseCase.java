package co.com.sofkau.icecreamshop.sale;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.icecreamshop.sale.commands.AddProduct;

public class AddProductUseCase extends UseCase<RequestCommand<AddProduct>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddProduct> addProductRequestCommand) {
        var command = addProductRequestCommand.getCommand();
        Sale sale = Sale.from(command.getSaleId(), repository().getEventsBy(command.getSaleId().value()));

        sale.addProduct(command.getName(), command.getPrice());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));

    }
}
package co.com.sofkau.icecreamshop.sale;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.icecreamshop.sale.commands.RemoveProduct;

public class RemoveProductUseCase extends UseCase<RequestCommand<RemoveProduct>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<RemoveProduct> removeProductRequestCommand) {
        var command = removeProductRequestCommand.getCommand();
        Sale sale = Sale.from(command.getSaleId(), repository().getEventsBy(command.getSaleId().value()));

        sale.removeProduct(command.getProductId());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
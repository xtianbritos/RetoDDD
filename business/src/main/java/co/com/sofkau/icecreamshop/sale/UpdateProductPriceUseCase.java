package co.com.sofkau.icecreamshop.sale;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.icecreamshop.sale.commands.UpdateProductPrice;

public class UpdateProductPriceUseCase extends UseCase<RequestCommand<UpdateProductPrice>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateProductPrice> updateClientNameRequestCommand) {
        var command = updateClientNameRequestCommand.getCommand();
        Sale sale = Sale.from(command.getSaleId(), repository().getEventsBy(command.getSaleId().value()));
        sale.updateProductPrice(command.getProductId(), command.getprice());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}

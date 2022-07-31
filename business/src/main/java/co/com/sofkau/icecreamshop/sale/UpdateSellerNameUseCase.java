package co.com.sofkau.icecreamshop.sale;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.icecreamshop.sale.commands.UpdateSellerName;

public class UpdateSellerNameUseCase extends UseCase<RequestCommand<UpdateSellerName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateSellerName> updateSellerNameRequestCommand) {
        var command = updateSellerNameRequestCommand.getCommand();
        Sale sale = Sale.from(command.getSaleId(), repository().getEventsBy(command.getSaleId().value()));
        sale.updateSellerName(command.getName());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}

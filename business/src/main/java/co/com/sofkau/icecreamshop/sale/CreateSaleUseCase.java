package co.com.sofkau.icecreamshop.sale;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.icecreamshop.sale.commands.CreateSale;

public class CreateSaleUseCase extends UseCase<RequestCommand<CreateSale>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateSale> createSaleRequestCommand) {
        var command = createSaleRequestCommand.getCommand();

        var sale = new Sale(command.getSaleId(), command.getName());

        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}

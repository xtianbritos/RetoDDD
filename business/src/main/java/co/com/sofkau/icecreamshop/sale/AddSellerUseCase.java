package co.com.sofkau.icecreamshop.sale;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.icecreamshop.sale.commands.AddSeller;

public class AddSellerUseCase extends UseCase<RequestCommand<AddSeller>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddSeller> addSellerRequestCommand) {
        var command = addSellerRequestCommand.getCommand();
        var sale = Sale.from(
                command.getSaleId(), repository().getEventsBy(command.getCoursoId().value())
        );
        sale.addSeller(command.getSellerId(), command.getName(), command.getPhoneNumber());

        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}

package co.com.sofkau.icecreamshop.sale;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.icecreamshop.sale.commands.UpdateSellerPhoneNumber;

public class UpdateSellerPhoneNumberUseCase  extends UseCase<RequestCommand<UpdateSellerPhoneNumber>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateSellerPhoneNumber> updateSellerPhoneNumberRequestCommand) {
        var command = updateSellerPhoneNumberRequestCommand.getCommand();
        Sale sale = Sale.from(command.getSaleId(), repository().getEventsBy(command.getSaleId().value()));
        sale.updateSellerPhoneNumber(command.getPhoneNumber());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}

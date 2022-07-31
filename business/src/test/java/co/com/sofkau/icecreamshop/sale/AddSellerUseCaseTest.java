package co.com.sofkau.icecreamshop.sale;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.sale.commands.AddSeller;
import co.com.sofkau.icecreamshop.sale.events.SaleCreated;
import co.com.sofkau.icecreamshop.sale.events.SellerAdded;
import co.com.sofkau.icecreamshop.sale.values.Name;
import co.com.sofkau.icecreamshop.sale.values.PhoneNumber;
import co.com.sofkau.icecreamshop.sale.values.SaleId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddSellerUseCaseTest {
    @InjectMocks
    private AddSellerUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addSellerToSaleSuccessfully() {
//        given
        SaleId saleId = SaleId.of("fakeSaleId");
        Name name = new Name("Pepe");
        PhoneNumber phoneNumber = new PhoneNumber("123456789");
        var command = new AddSeller(saleId, name, phoneNumber);

        Mockito.when(repository.getEventsBy("fakeSaleId")).thenReturn(history());
        useCase.addRepository(repository);

//        when
        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSaleId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

//        assert
        var event = (SellerAdded) domainEvents.get(0);
        assertEquals("fakeSaleId", event.aggregateRootId());
        assertEquals("Pepe", event.getName().value());
    }

    private List<DomainEvent> history() {
        SaleId saleId = SaleId.of("fakeSaleId");
        Name name = new Name("Pepe");
        var event = new SaleCreated(name);
        event.setAggregateRootId(saleId.value());
        return List.of(event);
    }
}
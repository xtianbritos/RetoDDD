package co.com.sofkau.icecreamshop.sale;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.sale.commands.UpdateSellerName;
import co.com.sofkau.icecreamshop.sale.events.ProductAdded;
import co.com.sofkau.icecreamshop.sale.events.SaleCreated;
import co.com.sofkau.icecreamshop.sale.events.SellerAdded;
import co.com.sofkau.icecreamshop.sale.events.SellerNameUpdated;
import co.com.sofkau.icecreamshop.sale.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UpdateSellerNameUseCaseTest {
    @InjectMocks
    private UpdateSellerNameUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateSellerNameSuccessfully() {
        SaleId fakeSaleId = SaleId.of("fakeSaleId");
        Name name = new Name("updated name");

        var command = new UpdateSellerName(fakeSaleId, name);

        Mockito.when(repository.getEventsBy("fakeSaleId")).thenReturn(List.of(
                new SaleCreated(new Name("Sale")),
                new SellerAdded(SellerId.of("fakeSeller"), new Name("oldName"), new PhoneNumber("123456789")),
                new ProductAdded(ProductId.of("fakeProductId"), new Name("IceCream"), new Price(123)),
                new ProductAdded(ProductId.of("anotherProduct"), new Name("Cake"), new Price(456))
        ));

        useCase.addRepository(repository);

        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor("fakeSaleId")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (SellerNameUpdated) domainEvents.get(0);
        assertEquals("updated name", event.getName().value());
        Mockito.verify(repository).getEventsBy("fakeSaleId");
    }
}
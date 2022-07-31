package co.com.sofkau.icecreamshop.sale;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.sale.commands.RemoveProduct;
import co.com.sofkau.icecreamshop.sale.events.ProductAdded;
import co.com.sofkau.icecreamshop.sale.events.ProductRemoved;
import co.com.sofkau.icecreamshop.sale.events.SaleCreated;
import co.com.sofkau.icecreamshop.sale.values.Name;
import co.com.sofkau.icecreamshop.sale.values.Price;
import co.com.sofkau.icecreamshop.sale.values.ProductId;
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
class RemoveProductUseCaseTest {

    @InjectMocks
    private RemoveProductUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void removeProductFromSaleSuccessfully() {

        SaleId fakeSaleId = SaleId.of("fakeSaleId");
        ProductId fakeProductId = ProductId.of("fakeProductId");

        var command = new RemoveProduct(fakeSaleId, fakeProductId);

        Mockito.when(repository.getEventsBy("fakeSaleId")).thenReturn(List.of(
                new SaleCreated(new Name("Sale")),
                new ProductAdded(ProductId.of("fakeProductId"), new Name("IceCream"), new Price(123)),
                new ProductAdded(ProductId.of("anotherProduct"), new Name("Cake"), new Price(456))
        ));

        useCase.addRepository(repository);

        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor("fakeSaleId")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ProductRemoved) domainEvents.get(0);
        assertEquals("fakeProductId", event.getProductId().value());
        assertTrue(event.getWasDeleted());
        Mockito.verify(repository).getEventsBy("fakeSaleId");
    }

}

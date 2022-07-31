package co.com.sofkau.icecreamshop.sale;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.sale.commands.UpdateProductPrice;
import co.com.sofkau.icecreamshop.sale.events.ProductAdded;
import co.com.sofkau.icecreamshop.sale.events.ProductPriceUpdated;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UpdateProductPriceUseCaseTest {
    @InjectMocks
    private UpdateProductPriceUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateProductPriceSuccessfully() {
        SaleId fakeSaleId = SaleId.of("fakeSaleId");
        ProductId fakeProductId = ProductId.of("fakeProductId");
        Price price = new Price(123);

        var command = new UpdateProductPrice(fakeSaleId, fakeProductId, price);

        Mockito.when(repository.getEventsBy("fakeSaleId")).thenReturn(List.of(
                new SaleCreated(new Name("Juan")),
                new ProductAdded(ProductId.of("fakeProductId"), new Name("david"), new Price(1234)),
                new ProductAdded(ProductId.of("anotherProduct"), new Name("Luis"), new Price(5678))
        ));

        useCase.addRepository(repository);

        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor("fakeSaleId")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ProductPriceUpdated) domainEvents.get(0);
        assertEquals(123, event.getPrice().value());
        assertEquals("fakeProductId", event.getProductId().value());
        Mockito.verify(repository).getEventsBy("fakeSaleId");
    }
}
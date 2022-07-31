package co.com.sofkau.icecreamshop.sale;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.sale.commands.AddProduct;
import co.com.sofkau.icecreamshop.sale.events.ProductAdded;
import co.com.sofkau.icecreamshop.sale.values.Name;
import co.com.sofkau.icecreamshop.sale.values.Price;
import co.com.sofkau.icecreamshop.sale.values.ProductId;
import co.com.sofkau.icecreamshop.sale.values.SaleId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddProductUseCaseTest {

    @InjectMocks
    private AddProductUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addProductToSaleSuccessfully() {

        //arrange
        SaleId saleId = SaleId.of("fakeSaleId");
        Name name = new Name("Christian");
        Price price = new Price(12345);
        var command = new AddProduct(saleId, name, price);

        when(repository.getEventsBy("fakeSaleId")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSaleId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ProductAdded) events.get(0);
        Assertions.assertEquals("Christian", event.getPrice().value());
    }

    private List<DomainEvent> history() {
        Name name = new Name("Christian");
        Price price = new Price(12345);
        var event = new ProductAdded(
                name,
                price
        );
        event.setAggregateRootId("fakeSaleId");
        return List.of(event);
    }
}
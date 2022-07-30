package co.com.sofkau.icecreamshop.sale;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.sale.commands.CreateSale;
import co.com.sofkau.icecreamshop.sale.events.SaleCreated;
import co.com.sofkau.icecreamshop.sale.values.Name;
import co.com.sofkau.icecreamshop.sale.values.SaleId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateSaleUseCaseTest {
    private CreateSaleUseCase useCase;

    @BeforeEach
    public void setUp() {
        useCase = new CreateSaleUseCase();
    }

    @Test
    public void createSaleSuccessfully() {
//        given
        SaleId saleId = SaleId.of("fakeSaleId");
        Name name = new Name("Juan");
        CreateSale command = new CreateSale(saleId, name);
//        when
        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

//        assert
        SaleCreated trainerCreated = (SaleCreated) domainEvents.get(0);
        assertEquals("fakeSaleId", trainerCreated.aggregateRootId());
        assertEquals("Juan", trainerCreated.getName().value());

    }
}
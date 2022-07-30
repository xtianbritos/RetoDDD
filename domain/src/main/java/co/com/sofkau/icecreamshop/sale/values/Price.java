package co.com.sofkau.icecreamshop.sale.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Price implements ValueObject<Integer> {
    private final Integer value;

    public Price(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return this.value;
    }
}

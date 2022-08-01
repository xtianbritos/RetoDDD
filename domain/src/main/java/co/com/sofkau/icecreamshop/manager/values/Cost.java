package co.com.sofkau.icecreamshop.manager.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cost implements ValueObject<Integer> {
    private final Integer value;

    public Cost(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return this.value;
    }
}

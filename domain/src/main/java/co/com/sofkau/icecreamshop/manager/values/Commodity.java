package co.com.sofkau.icecreamshop.manager.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Commodity implements ValueObject<String> {
    private final String value;

    public Commodity(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return value == commodity.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

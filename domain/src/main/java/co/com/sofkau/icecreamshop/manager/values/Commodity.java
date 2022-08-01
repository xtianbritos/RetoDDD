package co.com.sofkau.icecreamshop.manager.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Commodity implements ValueObject<String> {
    private final String name;

    public Commodity(String name) {
        this.name = Objects.requireNonNull(name);
        if(this.name.isBlank()){
            throw new IllegalArgumentException("Commodity cannot be empty");
        }
    }
    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return Objects.equals(name, commodity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

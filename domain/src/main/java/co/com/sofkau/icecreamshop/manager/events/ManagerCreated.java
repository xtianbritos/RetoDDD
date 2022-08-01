package co.com.sofkau.icecreamshop.manager.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.icecreamshop.manager.values.Name;

public class ManagerCreated extends DomainEvent {
    protected Name name;

    public ManagerCreated(Name name) {
        super("sofka.manager.managercreated");
        this.name = name;
    }

    //Getters

    public Name getName() {
        return name;
    }
}

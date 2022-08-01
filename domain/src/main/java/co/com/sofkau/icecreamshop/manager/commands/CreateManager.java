package co.com.sofkau.icecreamshop.manager.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.icecreamshop.manager.values.ManagerId;
import co.com.sofkau.icecreamshop.manager.values.Name;

public class CreateManager extends Command {
    final ManagerId managerId;
    final Name name;

    public CreateManager(ManagerId managerId, Name name) {
        this.managerId = managerId;
        this.name = name;
    }

    //Getters
    public ManagerId getSaleId() {
        return managerId;
    }

    public Name getName() {
        return name;
    }
}

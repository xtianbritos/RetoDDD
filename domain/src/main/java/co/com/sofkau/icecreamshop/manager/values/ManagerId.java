package co.com.sofkau.icecreamshop.manager.values;

import co.com.sofka.domain.generic.Identity;

public class ManagerId extends Identity {
    public ManagerId (){
    }

    private ManagerId(String id) {
        super(id);
    }

    public static ManagerId of(String id) {
        return new ManagerId(id);
    }
}

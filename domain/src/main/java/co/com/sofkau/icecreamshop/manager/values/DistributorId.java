package co.com.sofkau.icecreamshop.manager.values;

import co.com.sofka.domain.generic.Identity;

public class DistributorId extends Identity {
    public DistributorId (){
    }

    private DistributorId(String id) {
        super(id);
    }

    public static DistributorId of(String id) {
        return new DistributorId(id);
    }
}

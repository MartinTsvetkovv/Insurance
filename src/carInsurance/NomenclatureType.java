package carInsurance;

import carInsurance.interfaces.INomenclatureProvider;

public abstract class NomenclatureType {

    private INomenclatureProvider provider;
    private String name;
    private String secondName;

    public NomenclatureType(INomenclatureProvider provider, String name) {
        this.provider = provider;
        this.name = name;
    }

    public NomenclatureType(INomenclatureProvider provider, String name, String secondName){
        this.provider = provider;
        this.name = name;
        this.secondName = secondName;
    }

    protected INomenclatureProvider getProvider() {
        return this.provider;
    }

    protected String getName() {
        return this.name;
    }

    String getSecondName() {
        return secondName;
    }
}

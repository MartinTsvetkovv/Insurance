package carInsurance.insuranceFileInfo;
import carInsurance.INomenclatureProvider;
import carInsurance.NomenclatureType;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.Map;

 public class CarInsuranceFileReader extends NomenclatureType {

    public CarInsuranceFileReader(INomenclatureProvider provider, String name) {
        super(provider, name);
    }

    public Map<Integer, String> getEngineVolumes() throws FileNotFoundException, SQLException {
        return getProvider().getNomenclature(getName());
    }


}

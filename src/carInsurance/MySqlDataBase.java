package carInsurance;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public class MySqlDataBase extends NomenclatureType {

    public MySqlDataBase(INomenclatureProvider provider, String name) {
        super(provider, name);
    }

    public MySqlDataBase(INomenclatureProvider provider, String name, String secondName){
        super(provider, name,secondName);

    }

    public Map<Integer, String> getDataBaseInfo() throws FileNotFoundException, SQLException {
        return getProvider().getNomenclature(getName());
    }

    public  Map<String, Set<String>> getRegionMunicTowns(){
        return getProvider().getColumnsFromTable(getName(), getSecondName());
    }
}

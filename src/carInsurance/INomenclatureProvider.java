package carInsurance;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.Map;
import java.util.Set;

public interface INomenclatureProvider {
    Map<Integer, String> getNomenclature(String name) throws FileNotFoundException, SQLException;

    Map<String, Set<String>> getColumnsFromTable(String firstColumn, String secondColumn);

}

package carInsurance;

import carInsurance.insuranceFileInfo.MapFileReader;
import carInsurance.interfaces.INomenclatureProvider;

public class NomenclatureFactory {
    private NomenclatureFactory() {

    }

    public static INomenclatureProvider createNomenclature(DataSourceType dsType) {

        if (dsType.equals(DataSourceType.RESOURCE_FILES)) {
            String projectPath = System.getProperty("user.dir");
            return new MapFileReader(projectPath + "/src/carInsurance/resources/");

        }else if(dsType.equals(DataSourceType.DATABASE)){
            String myUrl = "jdbc:mysql://localhost:3309/insurance?autoReconnect=true&useSSL=false";
            return new MySqlDataBaseReader(myUrl);
        }
        return null;
    }

}

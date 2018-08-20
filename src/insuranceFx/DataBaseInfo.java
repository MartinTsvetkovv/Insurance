package insuranceFx;

import carInsurance.DataSourceType;
import carInsurance.interfaces.INomenclatureProvider;
import carInsurance.MySqlDataBase;
import carInsurance.NomenclatureFactory;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.*;

public class DataBaseInfo<K, V> {
    private List<String> userYears;
    private List<String> carYears;

    public DataBaseInfo() {
        this.userYears = new ArrayList<>();
        this.carYears = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    protected Map<K, V> readDataBaseInfo(String name) throws FileNotFoundException, SQLException {
        INomenclatureProvider provider = NomenclatureFactory.createNomenclature(DataSourceType.DATABASE);
        MySqlDataBase mySqlDataBase = new MySqlDataBase(provider, name);
        Map<Integer, String> dataBaseInfo = mySqlDataBase.getDataBaseInfo();
        return (Map<K, V>) dataBaseInfo;

    }

    protected Map<String, Set<String>> readRegionData(String firstTable, String secondTable) {
        INomenclatureProvider provider = NomenclatureFactory.createNomenclature(DataSourceType.DATABASE);
        MySqlDataBase mySqlDataBase = new MySqlDataBase(provider, firstTable, secondTable);
        return mySqlDataBase.getRegionMunicTowns();
    }


    public List<String> addUserYears() {
        for (int i = 18; i < 100; i++) {
            this.userYears.add(i + " години");
        }
        return this.userYears;
    }

    public List<String> addCarYears() {
        for (int i = 1960; i <= 2018; i++) {
            this.carYears.add(i + " г.");
        }
        return this.carYears;
    }



}

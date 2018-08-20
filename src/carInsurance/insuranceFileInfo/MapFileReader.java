package carInsurance.insuranceFileInfo;

import carInsurance.interfaces.INomenclatureProvider;

import java.io.*;
import java.util.*;

public class MapFileReader implements INomenclatureProvider {
    private Map<Integer, String> fileData;
    private String path;

    public MapFileReader(String path) {
        this.path = path;
        fileData = new HashMap<>();
    }
    @Override
    public Map<Integer, String> getNomenclature(String fileName) throws FileNotFoundException {

        String pathFile = path + fileName;

        File file = new File(pathFile);
        FileReader fr = new FileReader(file);

        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = (br.readLine())) != null) {
                String[] tokens = line.split(", ");
                int key = Integer.parseInt(tokens[0]);
                String value = tokens[1];
                fileData.put(key, value);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.fileData;
    }

    @Override
    public Map<String, Set<String>> getColumnsFromTable(String firstTable, String secondTable) {
        return null;
    }
}

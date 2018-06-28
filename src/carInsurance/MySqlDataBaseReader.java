package carInsurance;

import java.sql.*;
import java.util.*;

public class MySqlDataBaseReader implements INomenclatureProvider {
    private Map<Integer, String> dataBaseInfo;
    private Map<String, Set<String>> areaMunicipalities;
    private String connection;


    MySqlDataBaseReader(String connection) {
        this.dataBaseInfo = new HashMap<>();
        this.areaMunicipalities = new TreeMap<>();
        this.connection = connection;
    }

    @Override
    public Map<Integer, String> getNomenclature(String name) throws SQLException {

        try {

            String myDriver = "com.mysql.jdbc.Driver";
//            String myUrl = "jdbc:mysql://localhost:3309/insurance?autoReconnect=true&useSSL=false";
//
            Class.forName(myDriver);
            String fullPath = this.connection;
            Connection connection = DriverManager.getConnection(fullPath, "root", "Clarinet8310");

                String query = "SELECT id, name FROM " + name;

                Statement statement = connection.createStatement();
                ResultSet res = statement.executeQuery(query);
                this.dataBaseInfo.clear();
                while (res.next()) {
                    int key = res.getInt(1);
                    String value = res.getString(2);
                    this.dataBaseInfo.put(key, value);
            }
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return dataBaseInfo;
    }

    @Override
    public Map<String, Set<String>> getColumnsFromTable(String firstTable, String secondTable) {

        try {
            String driver = "com.mysql.jdbc.Driver";
            //String url = "jdbc:mysql://localhost:3309/insurance?autoReconnect=true&useSSL=false";
            String urlPath = this.connection;
            Class.forName(driver);
            Connection con = DriverManager.getConnection(urlPath, "root", "Clarinet8310");

            String query = "SELECT " + firstTable + ".name, " + secondTable + ".name FROM " + firstTable + ", " + secondTable + " " +
                    " WHERE " + secondTable + "." + firstTable + "_id =" + firstTable + ".id";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            areaMunicipalities.clear();
            while (resultSet.next()) {
                String areaName = resultSet.getString(1);
                String municipalityName = resultSet.getString(2);
                this.areaMunicipalities.putIfAbsent(areaName, new TreeSet<>());
                this.areaMunicipalities.get(areaName).add(municipalityName);
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return this.areaMunicipalities;
    }


    //    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//
//        // String path = System.getProperty("user.dir");
//        String filePath = "C:\\Users\\marti_000\\Desktop\\cities.csv";
//        //String fullPath = path +"/src/carInsurance/resources/municipalities.txt";
//        String myUrl = "jdbc:mysql://localhost:3309/insurance?autoReconnect=true&useSSL=false&characterEncoding=UTF-8";
//        String driver = "com.mysql.jdbc.Driver";
//        //String unicode= "?useUnicode=yes&characterEncoding=UTF-8";
//
//        Class.forName(driver);
//        Connection connection = DriverManager.getConnection(myUrl, "root", "Clarinet8310");
//
//
//        List<String> regions = new ArrayList<>();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                Pattern pattern = Pattern.compile("^(\")(\\D*)(\";\")([0-9]+)\\3(.*)\\3(.*)[\"]$");
//                Matcher matcher = pattern.matcher(line);
//                while (matcher.find()) {
//                    String s = matcher.group(5);
//                    char c = s.charAt(0);
//                    String s1 = s.substring(1).toLowerCase();
//                    String region = c + s1;
//                    //regions.add(region);
//                    String town = matcher.group(2);
//                    char c1 = town.charAt(0);
//                    String s2 = town.substring(1).toLowerCase();
//                    String town1 = c1+s2;
//                    String municipality = matcher.group(6);
//                    //regions.add(municipality);
//
//                }
//            }
////            for (String region : regions) {
////                System.out.println(region);
////                String name = new String(region.getBytes(), "UTF-8");
////
////                String query = "INSERT INTO municipality(name) VALUES(?)";
////
////                PreparedStatement statement = connection.prepareStatement(query);
////                statement.setString(1, name);
////                statement.execute();
////                statement.close();
////            }
//            //System.out.println(regions.size());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    private static int getByName(String areaName) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        String myUrl = "jdbc:mysql://localhost:3309/insurance?autoReconnect=true&useSSL=false&characterEncoding=UTF-8";
//        Connection con = DriverManager.getConnection(myUrl,"root", "Clarinet8310");
//        Statement statement = con.createStatement();
//        String query = "SELECT id,name FROM insurance.area WHERE name= '" + areaName +"'" ;
//        ResultSet resultSet = statement.executeQuery(query);
//
//        int id = 0;
//        while (resultSet.next()){
//            String name = resultSet.getString(2);
//            if (name.equals(areaName)){
//                id = resultSet.getInt(1);
//                System.out.println(id);
//            }
//        }
//
//        return  id;
//    }


}

package org.example;

import java.sql.*;

public class MySQLService {
    public static boolean isRunningTest = false;

    public static Connection conn(String hostname, String dbname, String username, String password) throws SQLException, SQLException {
        String url = "jdbc:mysql://" + hostname + ":3306/"+ dbname;
        return DriverManager.getConnection(url, username, password);
    }

    public static boolean CreateDog(Connection conn, Dogs dog) {
        try{
            //dog: id, name, age, male?, ownerid
            String query = "INSERT INTO dogs (id, name, age, isMale, ownerid) VALUES (" +
                    dog.getId() + ", " +
                    "\"" + dog.getName() + "\"" + ", " +
                    dog.getAge() + ", " +
                    dog.isMale() + ", " +
                    dog.getOwnerId() +
                    ");";

            PreparedStatement stmt = conn.prepareStatement(query);

            return stmt.execute();
        }
        catch(SQLException e){
            System.out.println("SQL Error: " + e);
            return false;
        }

    }

    public static boolean CreateOwner(Connection conn, Owners owner) {
        try{
            //owner: id, name, address, phone
            String query = "INSERT INTO owners (id, name) VALUES " +
                            "(" +
                            owner.getId() +
                            "," +
                            "\"" + owner.getName() + "\"" +
                            ");";

            PreparedStatement stmt = conn.prepareStatement(query);

            return stmt.execute();
        }
        catch(SQLException e){
            System.out.println("SQL Error: " + e);
            return false;
        }
    }

    public static boolean DeleteDog(Connection conn, int dogId) {
        try{
            String query = "DELETE FROM dogs WHERE id = " + dogId + ";";
            PreparedStatement stmt = conn.prepareStatement(query);
            return stmt.execute();
        }
        catch(SQLException e){
            System.out.println("SQL Error: " + e);
            return false;
        }
    }

    public static boolean DeleteOwner(Connection conn, int ownerId) throws SQLException {
        try{
            String query = "DELETE FROM owners WHERE id = " + ownerId + ";";
            PreparedStatement stmt = conn.prepareStatement(query);
            return stmt.execute();
        }
        catch(SQLException e){
            System.out.println("SQL Error: " + e);
            return false;
        }
    }





}

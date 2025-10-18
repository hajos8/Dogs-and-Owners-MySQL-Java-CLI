package org.example;

import java.sql.*;

public class MySQLService {
    public static boolean isRunningTest = false;

    public static String hostname = "localhost";
    public static String dbname = "dogs_and_owners";
    public static String username = "root";
    public static String password = "";

    public static Connection createConnection() throws SQLException {
        try {
            String url = "jdbc:mysql://" + hostname + ":3306/" + dbname;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        }
        catch (ClassNotFoundException e) {
            System.out.println("SQL Error: " + e);
            return null;
        }
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e);
        }
    }

    public static boolean createDog(Connection conn, Dogs dog) {
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

    public static boolean createOwner(Connection conn, Owners owner) {
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

    public static boolean deleteDog(Connection conn, int dogId) {
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

    public static boolean deleteOwner(Connection conn, int ownerId) throws SQLException {
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

    public static boolean updateDog(Connection conn, Dogs newDog) {
        try{
            String query = "UPDATE dogs SET " +
                    "name = \"" + newDog.getName() + "\", " +
                    "age = " + newDog.getAge() + ", " +
                    "isMale = " + newDog.isMale() + ", " +
                    "ownerId = " + newDog.getOwnerId() + " " +
                    "WHERE id = " + newDog.getId() + ";";
            PreparedStatement stmt = conn.prepareStatement(query);
            return stmt.execute();
        }
        catch(SQLException e){
            System.out.println("SQL Error: " + e);
            return false;
        }
    }

    public static boolean updateOwner(Connection conn, Owners newOwner) {
        try{
            String query = "UPDATE dogs SET " +
                    "name = " + newOwner.getName() + " " +
                    "WHERE id = " + newOwner.getId() + ";";
            PreparedStatement stmt = conn.prepareStatement(query);
            return stmt.execute();
        }
        catch(SQLException e){
            System.out.println("SQL Error: " + e);
            return false;
        }
    }

    public static ResultSet getDogs(Connection conn) {
        try {
            String query = "SELECT * FROM dogs;";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            return rs;

        }
        catch (SQLException e) {
            System.out.println("SQL Error: " + e);
            return null;
        }
    }

    public static ResultSet getOwners(Connection conn) {
        try {
            String query = "SELECT * FROM owners;";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            return rs;

        }
        catch (SQLException e) {
            System.out.println("SQL Error: " + e);
            return null;
        }
    }

    public static void printResultSet(ResultSet rs) {
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = rs.getString(i);
                    System.out.print(rsmd.getColumnName(i) + ": " + columnValue + " ");
                }
                System.out.println();
            }
        }
        catch (SQLException e) {
            System.out.println("SQL Error: " + e);
        }
    }

}

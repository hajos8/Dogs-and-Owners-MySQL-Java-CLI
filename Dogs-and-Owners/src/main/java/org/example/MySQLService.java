package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLService {
    public static Connection conn(String hostname, String dbname, String username, String password) throws SQLException, SQLException {
        String url = "jdbc:mysql://" + hostname + ":3306/"+ dbname;
        return DriverManager.getConnection(url, username, password);
    }

    public static boolean CreateDog(Connection conn, Dogs dog) throws SQLException {
        //dog: id, name, age, male?, ownerid
        String sql = "INSERT INTO dogs (id, name, age, isMale, ownerid) VALUES (" +
                dog.getId() + ", " +
                "\"" + dog.getName() + "\"" + ", " +
                dog.getAge() + ", " +
                dog.isMale() + ", " +
                dog.getOwnerId() +
                ");";

        return conn.createStatement().execute(sql);
    }

    public static boolean CreateOwner(Connection conn, Owners owner) throws SQLException {
        //owner: id, name, address, phone
        return conn.createStatement().execute(
                "INSERT INTO owners (id, name) VALUES " +
                        "(" +
                        owner.getId() +
                        "," +
                        "\"" + owner.getName() + "\"" +
                        ");"
        );
    }

    public static boolean DeleteDog(Connection conn, int dogId) throws SQLException {
        return conn.createStatement().execute(
                "DELETE FROM dogs WHERE id = " + dogId + ";"
        );
    }

    public static boolean DeleteOwner(Connection conn, int ownerId) throws SQLException {
        return conn.createStatement().execute(
                "DELETE FROM owners WHERE id = " + ownerId + ";"
        );
    }





}

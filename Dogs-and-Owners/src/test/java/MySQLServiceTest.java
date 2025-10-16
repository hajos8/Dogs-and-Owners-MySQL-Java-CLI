import org.example.Dogs;
import org.example.MySQLService;
import org.example.Owners;
import org.junit.Test;

import java.sql.Connection;

public class MySQLServiceTest {
    @Test
    public void testConnect() {
        try {
            String hostname = "localhost";
            String dbname = "dogs_and_owners";
            String username = "root";
            String password = "";

            MySQLService.conn(hostname, dbname, username, password);

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void testCreateDog() {
        try {
            String hostname = "localhost";
            String dbname = "dogs_and_owners";
            String username = "root";
            String password = "";

            Connection conn = MySQLService.conn(hostname, dbname, username, password);
            Dogs dog = new Dogs(99, "czigany", 3, true, 1);
            MySQLService.CreateDog(conn, dog);

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void testCreateOwner() {
        try {
            String hostname = "localhost";
            String dbname = "dogs_and_owners";
            String username = "root";
            String password = "";

            Connection conn = MySQLService.conn(hostname, dbname, username, password);
            Owners owner = new Owners(99, "Lakatos");
            MySQLService.CreateOwner(conn, owner);

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void testDeleteDog() {
        try {
            String hostname = "localhost";
            String dbname = "dogs_and_owners";
            String username = "root";
            String password = "";

            Connection conn = MySQLService.conn(hostname, dbname, username, password);
            MySQLService.DeleteDog(conn, 99);

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void testDeleteOwner() {
        try {
            String hostname = "localhost";
            String dbname = "dogs_and_owners";
            String username = "root";
            String password = "";

            Connection conn = MySQLService.conn(hostname, dbname, username, password);
            MySQLService.DeleteOwner(conn, 99);

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

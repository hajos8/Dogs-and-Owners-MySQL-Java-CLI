import org.example.Dogs;
import org.example.MySQLService;
import org.example.Owners;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class MySQLServiceTest {
    @Before
    public void setUp() {
        MySQLService.isRunningTest = true;
    }

    @Test
    public void testConnection() throws SQLException {
        Connection conn = MySQLService.createConnection();
        MySQLService.closeConnection(conn);
    }

    @Test
    public void testCreateDog() {
        try {
            Connection conn = MySQLService.createConnection();
            assert conn != null;

            Dogs dog = new Dogs(99, "czigany", 3, true, 1);

            MySQLService.createDog(conn, dog);
            MySQLService.closeConnection(conn);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void testCreateOwner() {
        try {
            Connection conn = MySQLService.createConnection();
            assert conn != null;

            Owners owner = new Owners(99, "Lakatos");

            MySQLService.createOwner(conn, owner);
            MySQLService.closeConnection(conn);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void testUpdateDog() {
        try {
            Connection conn = MySQLService.createConnection();
            assert conn != null;

            Dogs dog = new Dogs(99, "czigany", 4, false, 1);

            MySQLService.updateDog(conn, dog);
            MySQLService.closeConnection(conn);

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void testUpdateOwner() {
        try {
            Connection conn = MySQLService.createConnection();
            assert conn != null;

            Owners owner = new Owners(99, "Lakatlan");

            MySQLService.updateOwner(conn, owner);
            MySQLService.closeConnection(conn);

        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    @Test
    public void testDeleteDog() {
        try {
            Connection conn = MySQLService.createConnection();
            assert conn != null;

            MySQLService.deleteDog(conn, 99);
            MySQLService.closeConnection(conn);

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void testDeleteOwner() {
        try {
            Connection conn = MySQLService.createConnection();
            assert conn != null;

            MySQLService.deleteOwner(conn, 99);
            MySQLService.closeConnection(conn);

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void testGetDogs() {
        try {
            Connection conn = MySQLService.createConnection();
            assert conn != null;

            MySQLService.printResultSet(Objects.requireNonNull(MySQLService.getDogs(conn)));
            MySQLService.closeConnection(conn);

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void testGetOwners() {
        try {
            Connection conn = MySQLService.createConnection();
            assert conn != null;

            MySQLService.printResultSet(Objects.requireNonNull(MySQLService.getOwners(conn)));
            MySQLService.closeConnection(conn);

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

import org.example.Dogs;
import org.example.MySQLService;
import org.example.Owners;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class MySQLServiceTest {
    @Test
    public void testConnection() throws SQLException {
        MySQLService.conn = MySQLService.createConnection();
        MySQLService.closeConnection();
    }

    @Test
    public void testAllMySQLServiceCreateUpdateDelete() {
        try {
            //testCreateDog
            Connection conn = MySQLService.createConnection();
            assert conn != null;

            Dogs dog = new Dogs(99,"czigany", 3, true, 1);

            MySQLService.createDog(dog);

            //testCreateOwner

            Owners owner = new Owners(99, "Lakatos");
            MySQLService.createOwner(owner);

            //testUpdateDog

            Dogs newDog = new Dogs(99, "czigany", 4, false, 1);
            MySQLService.updateDog(newDog);

            //testUpdateOwner

            Owners newOwner = new Owners(99, "Lakatlan");
            MySQLService.updateOwner(newOwner);

            //testDeleteDog

            MySQLService.deleteDog(99);

            //testDeleteOwner
            MySQLService.deleteOwner(99);

            MySQLService.closeConnection();
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

            MySQLService.printResultSet(Objects.requireNonNull(MySQLService.getDogs()));
            MySQLService.closeConnection();

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

            MySQLService.printResultSet(Objects.requireNonNull(MySQLService.getOwners()));
            MySQLService.closeConnection();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

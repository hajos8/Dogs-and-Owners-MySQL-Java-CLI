import org.example.Dogs;
import org.example.MySQLService;
import org.example.Owners;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
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
            //connect
            Connection conn = MySQLService.createConnection();
            assert conn != null;

            //testCreateDog
            Dogs dog = new Dogs(99,"czigany", 3, true, 1);
            MySQLService.createDog(dog);

            //testCreateOwner
            Owners owner = new Owners(99, "Lakatos");
            MySQLService.createOwner(owner);

            //testUpdateDog
            HashMap<String, String> updates = new HashMap<>();
            updates.put("name_str", "ubul");

            MySQLService.updateDog(updates, 99);

            //testUpdateOwner
            Owners newOwner = new Owners(99, "Lakatlan");
            MySQLService.updateOwner(newOwner);

            //testDeleteDog
            MySQLService.deleteDog(99);

            //testDeleteOwner
            MySQLService.deleteOwner(99);

            //close connection
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

    @Test
    public void invalidValuesTest() {
        try {
            //test invalid dog creation
            Dogs dog = new Dogs(null, null, -1, true, -5);
            MySQLService.createDog(dog);

            //test invalid owner creation
            Owners owner = new Owners(null, null);
            MySQLService.createOwner(owner);

            //test invalid dog update
            HashMap<String, String> updates = new HashMap<>();
            updates.put("age_str", "5");
            updates.put("age_double", "-3");

            //test invalid owner update
            Owners newOwner = new Owners(-10, null);
            MySQLService.updateOwner(newOwner);

            //test invalid dog deletion
            MySQLService.deleteDog(-10);

            //test invalid owner deletion
            MySQLService.deleteOwner(-10);

            MySQLService.getDogs();
            MySQLService.getOwners();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

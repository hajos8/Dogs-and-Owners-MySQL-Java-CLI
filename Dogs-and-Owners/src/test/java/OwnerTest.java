import org.example.Owners;
import org.junit.Test;

public class OwnerTest {
    @Test
    public void testCreateOwner(){
        Owners owner = new Owners(1, "Alice");
    }

    @Test
    public void testOwnerGettersAndSetters() {
        Owners owner = new Owners(2, "Bob");

        // Test getters
        assert owner.getId() == 2;
        assert owner.getName().equals("Bob");

        // Test setters
        owner.setId(3);
        owner.setName("Charlie");
        assert owner.getId() == 3;
        assert owner.getName().equals("Charlie");
    }
}

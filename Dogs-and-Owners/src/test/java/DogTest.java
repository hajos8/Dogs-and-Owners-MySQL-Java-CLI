import org.example.Dogs;
import org.junit.Test;

public class DogTest {
    @Test
    public void testCreateDog(){
        Dogs dog = new Dogs(1, "Buddy", 4.0, true, 1);
    }

    @Test
    public void testDogGettersAndSetters() {
        Dogs dog = new Dogs(2, "Max", 2.5, false, 2);

        // Test getters
        assert dog.getId() == 2;
        assert dog.getName().equals("Max");
        assert dog.getAge() == 2.5;
        assert !dog.isMale();
        assert dog.getOwnerId() == 2;
        // Test setters
        dog.setId(3);
        dog.setName("Rocky");
        dog.setAge(3.0);
        dog.setMale(true);
        dog.setOwnerId(3);
        assert dog.getId() == 3;
        assert dog.getName().equals("Rocky");
        assert dog.getAge() == 3.0;
        assert dog.isMale();
        assert dog.getOwnerId() == 3;
    }
}

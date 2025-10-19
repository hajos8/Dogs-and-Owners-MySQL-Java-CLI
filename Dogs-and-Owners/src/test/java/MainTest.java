import org.example.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainTest {
    @Before
    public void setup(){
        Main.isRunningTest = true;
        MainHelper.isRunningTest = true;

        MainHelper.testDogId = 100;
        MainHelper.testDogNameInput = "TestDog";
        MainHelper.testDogAgeInput = 3.5;
        MainHelper.testDogIsMaleInput = true;
        MainHelper.testDogOwnerIdInput = 1;

        MainHelper.testOwnerId = 100;
        MainHelper.testOwnerName = "TestOwner";
        MainHelper.testSubMenuChoice = 1;


    }

    @Test
    public void mainTest() {
        Main.testMenuInput = 1;
        Main.main(null);

        Main.testMenuInput = 2;
        Main.main(null);

        MainHelper.testOwnerName = "Benő nem segít :c";
        Main.testMenuInput = 3;
        Main.main(null);


        Main.testMenuInput = 7;
        Main.main(null);
    }

    @Test
    public void mainTestMainOption4() {
        Main.testMenuInput = 1;
        Main.main(null);

        Main.testMenuInput = 4;
        MainHelper.testSubMenuChoice = 1;
        MainHelper.testDogNameInput = "UpdatedTestDog";
        Main.main(null);

        Main.testMenuInput = 4;
        MainHelper.testSubMenuChoice = 2;
        MainHelper.testDogAgeInput = 5.0;
        Main.main(null);

        Main.testMenuInput = 4;
        MainHelper.testSubMenuChoice = 3;
        MainHelper.testDogIsMaleInput = false;
        Main.main(null);

        Main.testMenuInput = 4;
        MainHelper.testSubMenuChoice = 4;
        MainHelper.testDogOwnerIdInput = 2;
        Main.main(null);
    }

    @Test
    public void mainTestOption5(){
        Owners owner = new Owners(99, "Lakatos");
        MySQLService.createConnection();
        MySQLService.createOwner(owner);
        MySQLService.closeConnection();

        Main.testMenuInput = 5;
        MainHelper.testOwnerId = 99;
        Main.main(null);
    }

    @Test
    public void mainTestOption6(){
        Dogs dog = new Dogs(99, "Kormi", 4.0, true, 1);
        MySQLService.createConnection();
        MySQLService.createDog(dog);
        MySQLService.closeConnection();

        Main.testMenuInput = 6;
        MainHelper.testDogId = 99;
        Main.main(null);
    }

    @After
    public void teardown(){
        Main.isRunningTest = false;
        MainHelper.isRunningTest = false;
    }
}

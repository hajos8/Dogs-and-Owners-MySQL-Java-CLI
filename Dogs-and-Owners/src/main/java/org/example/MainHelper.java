package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class MainHelper {
    public static boolean isRunningTest = false;

    public static int testDogId;
    public static String testDogNameInput;
    public static float testDogAgeInput;
    public static boolean testDogIsMaleInput;
    public static int testDogOwnerIdInput;

    public static int testOwnerId;
    public static String testOwnerName;

    public static int testSubMenuChoice;

    public static void showDog(){
        try{
            MySQLService.printResultSet(MySQLService.getDogs());
        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public static void showOwner(){
        try{
            MySQLService.printResultSet(MySQLService.getOwners());
        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public static void insertDog(){
        Scanner scanner = new Scanner(System.in);

        showDog();

        System.out.print("Enter Dog Name: ");
        String dogName = isRunningTest ? testDogNameInput : scanner.nextLine();

        System.out.print("Enter Dog Age (yr): ");
        float dogAge = isRunningTest ? testDogAgeInput : scanner.nextFloat();
        if(!isRunningTest) scanner.nextLine();

        System.out.print("Enter whether the dog is male (y/n): ");
        boolean dogIsMale = isRunningTest ? testDogIsMaleInput :
                (scanner.nextLine().toLowerCase().charAt(0) == 'y');

        System.out.print("Enter Owner ID: ");
        int dogOwnerId = isRunningTest ? testDogOwnerIdInput : scanner.nextInt();
        if(!isRunningTest) scanner.nextLine();

        System.out.println();

        //user cannot set the id, it is auto generated
        Dogs newDog = new Dogs(null, dogName, dogAge, dogIsMale, dogOwnerId);

        if(!MySQLService.createDog(newDog)){
            System.out.println("Dog created successfully.");
        } else {
            System.out.println("Failed to create Dog.");
        }
    }

    public static void insertOwner(){
        Scanner scanner = new Scanner(System.in);

        showOwner();

        System.out.print("Enter Owner Name: ");
        String ownerName = isRunningTest ? testOwnerName : scanner.nextLine();

        System.out.println();

        //user cannot set the id, it is auto generated
        Owners newOwner = new Owners(null, ownerName);

        if(!MySQLService.createOwner(newOwner)){
            System.out.println("Owner created successfully.");
        } else {
            System.out.println("Failed to create Owner.");
        }
    }

    public static void deleteDog(){
        Scanner scanner = new Scanner(System.in);

        showDog();

        System.out.print("Enter Dog ID to delete: ");
        int dogId = scanner.nextInt();
        if(!isRunningTest) scanner.nextLine();

        System.out.println();

        if(!MySQLService.deleteDog(dogId)){
            System.out.println("Dog with ID " + dogId + " deleted successfully.");
        } else {
            System.out.println("Failed to delete Dog with ID " + dogId + ".");
        }
    }

    public static void deleteOwner(){
        Scanner scanner = new Scanner(System.in);

        showOwner();

        System.out.print("Enter Owner ID to delete: ");
        int ownerId = scanner.nextInt();
        if(!isRunningTest) scanner.nextLine();

        System.out.println();

        if(!MySQLService.deleteOwner(ownerId)){
            System.out.println("Owner with ID " + ownerId + " deleted successfully.");
        } else {
            System.out.println("Failed to delete Owner with ID " + ownerId + ".");
        }
    }

    public static void updateDog(){
        Scanner scanner = new Scanner(System.in);

        showDog();

        System.out.print("Enter Dog ID to update: ");
        int DogId = isRunningTest ? testDogId : scanner.nextInt();
        if(!isRunningTest) scanner.nextLine();

        int submenuChoice = 0;
        StringBuilder updateChoices = new StringBuilder();

        while(submenuChoice != 5) {
            System.out.println("Update Dog Menu");
            System.out.println("---------------");
            System.out.println("1. Update Name");
            System.out.println("2. Update Age");
            System.out.println("3. Update whether Male"); //fidesz ezt nem engedi
            System.out.println("4. Update Owner ID");
            System.out.println("5. Exit from Update Dog Menu");
            System.out.println("---------------");

            System.out.print("Make your choice: ");

            submenuChoice = isRunningTest ? testSubMenuChoice : scanner.nextInt();
            if(!isRunningTest) scanner.nextLine();


            switch (submenuChoice){
                case 1 -> updateChoices.append("1");
                case 2 -> updateChoices.append("2");
                case 3 -> updateChoices.append("3");
                case 4 -> updateChoices.append("4");
                case 5 -> System.out.println("Exit from Update Dog Menu...");
            }
        }

        HashMap<String, String> updates = new HashMap<>();

        for(char choice : updateChoices.toString().toCharArray()){
            switch (choice){
                case '1' -> {
                    System.out.print("Enter new Dog Name: ");
                    String dogName = isRunningTest ? testDogNameInput : scanner.nextLine();

                    updates.put("name_str", dogName);

                }
                case '2' -> {
                    System.out.print("Enter new Dog Age (yr): ");
                    float dogAge = isRunningTest ? testDogAgeInput : scanner.nextFloat();
                    if(!isRunningTest) scanner.nextLine();

                    updates.put("age_float", String.valueOf(dogAge));

                }
                case '3' -> {
                    System.out.print("Enter whether the dog is male (y/n): ");
                    boolean dogIsMale = isRunningTest ?
                            testDogIsMaleInput
                            :
                            (scanner.nextLine().toLowerCase().charAt(0) == 'y');

                    updates.put("isMale_boolean", String.valueOf(dogIsMale));
                }
                case '4' -> {
                    System.out.print("Enter new Owner ID: ");
                    int dogOwnerId = isRunningTest ? testDogOwnerIdInput : scanner.nextInt();
                    if(!isRunningTest) scanner.nextLine();

                    updates.put("ownerid_int", String.valueOf(dogOwnerId));
                }
            }
        }

        for(String key : updates.keySet()){
            System.out.println("Key: " + key + ", " + "value: " + updates.get(key));
        }

        if(!MySQLService.updateDog(updates, DogId)){
            System.out.println("Dog with ID " + DogId + " updated successfully.");
        } else {
            System.out.println("Failed to update Dog with ID " + DogId + ".");
        }

    }


    public static void updateOwner(){
        Scanner scanner = new Scanner(System.in);

        showOwner();

        System.out.print("Enter Owner ID to update: ");
        int ownerId = isRunningTest ? testOwnerId : scanner.nextInt();
        if(!isRunningTest) scanner.nextLine();

        System.out.print("Enter new Owner Name: ");
        String ownerName = isRunningTest ? testOwnerName : scanner.nextLine();

        System.out.println();

        Owners updatedOwner = new Owners(ownerId, ownerName);

        if(!MySQLService.updateOwner(updatedOwner)){
            System.out.println("Owner with ID " + ownerId + " updated successfully.");
        } else {
            System.out.println("Failed to update Owner with ID " + ownerId + ".");
        }
    }
}

package org.example;

import java.util.Scanner;

public class MainHelper {
    public static boolean isRunningTest = false;

    public static String testDogNameInput;
    public static float testDogAgeInput;
    public static boolean testDogIsMaleInput;
    public static int testDogOwnerIdInput;


    public static void showDog(){
        try{
            MySQLService.getDogs();
        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public static void showOwner(){
        try{
            MySQLService.getOwners();
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
        if(!isRunningTest) scanner.nextLine();

        System.out.print("Enter Dog Age (yr): ");
        float dogAge = isRunningTest ? testDogAgeInput : scanner.nextFloat();
        if(!isRunningTest) scanner.nextLine();

        System.out.print("Enter whether the dog is male (y/n): ");
        boolean dogIsMale = isRunningTest ? testDogIsMaleInput :
                (scanner.nextLine().toLowerCase().charAt(0) == 'y');
        if(!isRunningTest) scanner.nextLine();

        System.out.print("Enter Owner ID: ");
        int dogOwnerId = isRunningTest ? testDogOwnerIdInput : scanner.nextInt();
        if(!isRunningTest) scanner.nextLine();

        System.out.println();

        //user cannot set the id, it is auto generated
        Dogs newDog = new Dogs(null, dogName, dogAge, dogIsMale, dogOwnerId);

        if(MySQLService.createDog(newDog)){
            System.out.println("Dog created successfully.");
        } else {
            System.out.println("Failed to create Dog.");
        }
    }

    public static void insertOwner(){
        Scanner scanner = new Scanner(System.in);

        showOwner();

        System.out.print("Enter Owner Name: ");
        String ownerName = scanner.nextLine();
        if(!isRunningTest) scanner.nextLine();

        System.out.println();

        //user cannot set the id, it is auto generated
        Owners newOwner = new Owners(null, ownerName);

        if(MySQLService.createOwner(newOwner)){
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

        if(MySQLService.deleteDog(dogId)){
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

        if(MySQLService.deleteOwner(ownerId)){
            System.out.println("Owner with ID " + ownerId + " deleted successfully.");
        } else {
            System.out.println("Failed to delete Owner with ID " + ownerId + ".");
        }
    }
}

package org.example;

import java.util.Scanner;

public class MainHelper {
    public static boolean isRunningTest = false;

    public static int testMenuInput;

    public static int testDogIdInput;
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

        System.out.print("Enter Dog ID: ");
        int dogId = isRunningTest ? testDogIdInput : scanner.nextInt();
        if(!isRunningTest) scanner.nextLine();

        System.out.print("Enter Dog Name: ");
        String dogName = isRunningTest ? testDogNameInput : scanner.nextLine();
        if(!isRunningTest) scanner.nextLine();

        System.out.print("Enter Dog Age: ");
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

        MySQLService.insertDog(dogId, dogName, dogAge, dogIsMale, dogOwnerId);
    }
}

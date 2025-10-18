package org.example;

import java.util.Scanner;

public class Main {
    public static boolean isRunningTest = false;
    public static int testMenuInput;

    public static void main(String[] args) {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        /*
        Menu
        -----
        1. Insert new Owner
        2. Insert new Dog
        3. Update existing Owner
        4. Update existing Dog
        5. Delete existing Owner
        6. Delete existing Dog
        7. Exit program
        -----
        Make your choice:
        */

        while(!exit){
            System.out.println("Menu");
            System.out.println("-----");
            System.out.println("1. Insert new Owner");
            System.out.println("2. Insert new Dog");
            System.out.println("3. Update existing Owner");
            System.out.println("4. Update existing Dog");
            System.out.println("5. Delete existing Owner");
            System.out.println("6. Delete existing Dog");
            System.out.println("7. Exit program");
            System.out.println("-----");
            System.out.print("Make your choice: ");

            int choice = isRunningTest ? testMenuInput : scanner.nextInt();

            switch(choice){
                case 1 -> {

                    MainHelper.insertDog();
                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 5 -> {

                }
                case 6 -> {

                }
                case 7 -> {
                    exit = true;
                    System.out.println("Exiting...");
                }
            }
        }

    }
}
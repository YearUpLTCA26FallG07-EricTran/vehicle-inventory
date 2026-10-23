package com.pluralsight;

import java.util.Scanner;

public class Console {

    private static final Scanner scanner = new Scanner(System.in);

    public static String promptForString(String prompt){
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int promptForInt(String prompt){
        System.out.print(prompt);
        int result =  scanner.nextInt();
        scanner.nextLine();
        return result;
    }

}
package com.pluralsight;


import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        Vehicle[] vehicles = new Vehicle[20];
        int countVehicles = 0;

        vehicles [countVehicles++] = new Vehicle(101121,"Ford Explorer","Red",45000,13500);
        vehicles [countVehicles++] = new Vehicle(101122,"Toyota Camry","Blue",60000,11000);
        vehicles [countVehicles++] = new Vehicle(101123,"Malibu","Black",50000,9700);
        vehicles [countVehicles++] = new Vehicle(101124,"Honda Civic","White",70000,7500);
        vehicles [countVehicles++] = new Vehicle(101125,"Subaru Outback","Green",55000,14500);
        vehicles [countVehicles++] = new Vehicle(101126,"Jeep Wrangler", "Yellow", 30000, 16000);



        String mainMenuText = """
        
        
        === MAIN MENU ===
        
        What do you want to do?
        1 - List all vehicles
        2 - Search by make/model
        3 - Search by price range
        4 - Search by color
        5 - Add a vehicle
        6 - Quit
        Enter your command:""";

        int choice;

        do{
            choice = Console.promptForInt(mainMenuText);
            switch(choice){
                case 1 -> processListAllVehicles(vehicles, countVehicles);
                case 2 -> processSearchByMakeModel();
                case 3 -> processSearchByPrice(vehicles,countVehicles);
                case 4 -> processSearchByColor(vehicles, countVehicles);
                case 5 -> countVehicles = processAddVehicle(vehicles, countVehicles);

                //case 5 -> countVehicles = processAddVehicle(vehicles, countVehicles);
                default -> System.out.println("Invalid command, please try again...");
            }
        }  while (choice != 6);

    }

    private static void processListAllVehicles(Vehicle[] vehicles, int countVehicles) {
        for (int i = 0; i < countVehicles; i++) {
            System.out.println(vehicles[i].getMakeModel());

        }
    }

    private static void processSearchByMakeModel() {
        //todo search make model
        System.out.println("Input Model: ");
    }


    private static void processSearchByPrice(Vehicle[] vehicles, int countVehicles) {
        int minPrice = Console.promptForInt("Minimum Price: ");
        int maxPrice = Console.promptForInt("Maximum Price: ");
        for (int i = 0; i < countVehicles; i++) { //
            if (vehicles[i].getPrice() > minPrice && vehicles[i].getPrice() < maxPrice) {
                System.out.println(vehicles[i].getPrice());
            }
        }


    }

    private static void processSearchByColor(Vehicle[] vehicles, int countVehicles) {

        //todo search color
        System.out.println("Input Color: ");
        String color = scanner.nextLine().trim();
        for (int i = 0; i < countVehicles; i++) {

            if (color.equals(vehicles[i].getColor())) {
                System.out.println(vehicles[i].getMakeModel());

            }

        }
    }

    private static int processAddVehicle(Vehicle[] vehicles, int countVehicles) {
        if (vehicles.length == countVehicles) {
            System.out.println("Max Vehicle");
            return countVehicles;
        }
        System.out.println("Add Vehicle ID: ");
        long vehicleId = scanner.nextLong();

        scanner.nextLine();

        System.out.println("Add Vehicle makeModel: ");
        String makeModel = scanner.nextLine();

        System.out.println("Add Vehicle Color: ");
        String modelColor = scanner.nextLine();

        System.out.println("Add Vehicle Odometer: ");
        int carOdometer = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Vehicle Price: ");
        double vehiclePrice = scanner.nextDouble();

        scanner.nextLine();

        vehicles[countVehicles] = new Vehicle(vehicleId, makeModel, modelColor, carOdometer, vehiclePrice);
        countVehicles = countVehicles + 1;
        return countVehicles;
    }





}
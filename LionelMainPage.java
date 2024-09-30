package MainPackage;

import java.io.*;
import java.util.*;

public class LionelMainPage {

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        LionelInventory inventory = new LionelInventory();
        LionelUsers users = new LionelUsers();
        LionelSupplier suppliers = new LionelSupplier();

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Manage Inventory");
            System.out.println("2. Manage Suppliers");
            System.out.println("3. Manage Users");
            System.out.println("4. Exit");
            System.out.println("Please select an option (1, 2, 3, or 4): ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nProduct Management");
                    inventory.showMenu();
                    break;
                case 2:
                    System.out.println("\nSupplier Management");
                    suppliers.showMenu();
                    break;
                case 3:
                    System.out.println("\nUser Management");
                    users.showMenu();
                    break;
                case 4:
                    System.out.println("\nExiting program...");
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice.");
            }
        }
    }

    public static void main(String[] args) {
        mainMenu();
    }
}

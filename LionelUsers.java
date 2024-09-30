package MainPackage;

import java.io.*;
import java.util.Scanner;

public class LionelUsers extends LionelDatabase {

    public LionelUsers() {
        super("C:/Users/Lionel Seow/Downloads/sampleUsers.txt");
    }

    @Override
    protected String generateNextId() {
        int highestId = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                if (id > highestId) {
                    highestId = id;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return String.format("%04d", highestId + 1);
    }

    // Method to show the user management menu
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nUsers Page");
            System.out.println("1. Display Data");
            System.out.println("2. Create Data");
            System.out.println("3. Update Data");
            System.out.println("4. Delete Data");
            System.out.println("5. Main Page");
            System.out.println("6. Exit Program");
            System.out.println("Please select an option:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    displayData();
                    break;
                case 2:
                    addUser();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    return; // Exit to Main Page
                case 6:
                    System.out.println("Exiting program...");
                    System.exit(0); // Exit the program
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to display all user data
    public void displayData() {
        System.out.println("\nDisplaying all user data:");
        readFile();
    }

    // Method to add a new user
    public void addUser() {
        String newId = generateNextId();
        
        System.out.println("\nGenerated Product ID: " + newId);
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        String data = newId + "," + username + "," + password;
        createData(data);
        System.out.println("User added successfully!");
    }

    // Method to update user information
    public void updateUser() {
        System.out.print("\nEnter User ID to update: ");
        String id = scanner.nextLine();
        System.out.print("Enter new Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter new Password: ");
        String password = scanner.nextLine();

        String updatedData = id + "," + username + "," + password;
        updateData(id, updatedData);
        System.out.println("User updated successfully!");
    }

    // Method to delete a user from the database
    public void deleteUser() {
        System.out.print("\nEnter User ID to delete: ");
        String id = scanner.nextLine();
        deleteData(id);
        System.out.println("User deleted successfully!");
    }
}

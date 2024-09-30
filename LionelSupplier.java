package MainPackage;

import java.io.*;
import java.util.Scanner;

public class LionelSupplier extends LionelDatabase {

    public LionelSupplier() {
        super("C:/Users/Lionel Seow/Downloads/sampleSupplier.txt");
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

    // Method to show the supplier management menu
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSupplier Page");
            System.out.println("Please select an option:");
            System.out.println("1. Display Data");
            System.out.println("2. Create Data");
            System.out.println("3. Update Data");
            System.out.println("4. Delete Data");
            System.out.println("5. Main Page");
            System.out.println("6. Exit Program");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    displayData();
                    break;
                case 2:
                    addSupplier();
                    break;
                case 3:
                    updateSupplier();
                    break;
                case 4:
                    deleteSupplier();
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

    // Method to display all supplier data
    public void displayData() {
        System.out.println("\nDisplaying all supplier data:");
        readFile();
    }

    // Method to add a new supplier
    public void addSupplier() {
        String newId = generateNextId();
        
        System.out.println("\nGenerated Product ID: " + newId);
        System.out.print("Enter Supplier Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact Person: ");
        String contact = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        String data = newId + "," + name + "," + contact + "," + phone + "," + address;
        createData(data);
        System.out.println("Supplier added successfully!");
    }

    // Method to update supplier information
    public void updateSupplier() {
        System.out.print("Enter Supplier ID to update: ");
        String id = scanner.nextLine();
        System.out.print("Enter new Supplier Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new Contact Person: ");
        String contact = scanner.nextLine();
        System.out.print("Enter new Phone Number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter new Address: ");
        String address = scanner.nextLine();

        String updatedData = id + "," + name + "," + contact + "," + phone + "," + address;
        updateData(id, updatedData);
        System.out.println("Supplier updated successfully!");
    }

    // Method to delete a supplier from the database
    public void deleteSupplier() {
        System.out.print("Enter Supplier ID to delete: ");
        String id = scanner.nextLine();
        deleteData(id);
        System.out.println("Supplier deleted successfully!");
    }
}

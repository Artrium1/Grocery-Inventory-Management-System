package MainPackage;

import java.io.*;
import java.util.Scanner;

public class LionelInventory extends LionelDatabase {

    public LionelInventory() {
        super("C:/Users/Lionel Seow/Downloads/sampleData.txt");
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

    // Method to show the inventory menu
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nInventory Page");
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
                    addProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
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

    // Method to display all product data
    public void displayData() {
        System.out.println("\nDisplaying all inventory data:");
        readFile();
    }

    // Method to add a new product to the inventory
    public void addProduct() {
        String newId = generateNextId();
      
        System.out.println("\nGenerated Product ID: " + newId);
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
        String expiryDate = scanner.nextLine();

        String data = newId + "," + name + "," + category + "," + quantity + "," + price + "," + expiryDate;
        createData(data);
        System.out.println("Product added successfully!");
    }

    // Method to update product information
    public void updateProduct() {
        System.out.print("\nEnter Product ID to update: ");
        String id = scanner.nextLine();
        System.out.print("Enter new Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new Category: ");
        String category = scanner.nextLine();
        System.out.print("Enter new Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter new Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter new Expiry Date (YYYY-MM-DD): ");
        String expiryDate = scanner.nextLine();

        String updatedData = id + "," + name + "," + category + "," + quantity + "," + price + "," + expiryDate;
        updateData(id, updatedData);
        System.out.println("Product updated successfully!");
    }

    // Method to delete a product from the inventory
    public void deleteProduct() {
        System.out.print("\nEnter Product ID to delete: ");
        String id = scanner.nextLine();
        deleteData(id);
    }
}

package MainPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LoginPage {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
        loginPage.authenticateUser();
    }

    public void authenticateUser() {
        System.out.println("Please Enter Your User Id:");
        String userId = scanner.nextLine().trim();
        
        System.out.println("Please Enter Your Password:");
        String password = scanner.nextLine().trim();
        
        boolean isAuthenticated = checkCredentials(userId, password);
        
        if (isAuthenticated) {
            System.out.println("Login Successful!");
            // Navigate to the main menu
            LionelMainPage lmp = new LionelMainPage();
            lmp.mainMenu();
        } else {
            System.out.println("Invalid User Id or Password. Please try again.\n");
            authenticateUser();
        }
    }

    private boolean checkCredentials(String userId, String password) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("C:/Users/Lionel Seow/Downloads/sampleUsers.txt"));
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                
                // Check if the ID and password match
                if (data.length >= 3 && data[0].trim().equals(userId) && data[2].trim().equals(password)) {
                    return true; // Credentials match
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false; // No match found
    }
}

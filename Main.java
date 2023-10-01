package BaseConverter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the base converter! Type 'E' to stop: ");

        // Calls the procedure that asks the primary base
        // Type 5 to stop the execution
        Convert.askBase();
        
        // Closes the Scanner Object
        scanner.close();
    }
}
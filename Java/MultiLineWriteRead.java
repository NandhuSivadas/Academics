import java.io.*;
import java.util.Scanner;

class Product {
    int pid;
    String name;
    double price;

    Product(int pid, String name, double price) {
        this.pid = pid;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return pid + "," + name + "," + price;
    }
}

public class MultiLineWriteRead {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "products.txt";

        System.out.print("Enter number of products: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Write product details to file
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename));
            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter details for Product " + (i + 1));
                System.out.print("Product ID: ");
                int pid = scanner.nextInt();
                scanner.nextLine(); // consume newline

                System.out.print("Product Name: ");
                String name = scanner.nextLine();

                System.out.print("Product Price: ");
                double price = scanner.nextDouble();
                scanner.nextLine(); // consume newline

                Product p = new Product(pid, name, price);
                writer.write(p.toString());
                writer.newLine();
            }
            System.out.println("\nProduct details written to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("Error closing writer: " + e.getMessage());
            }
        }

        // Read only product names from file
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            System.out.println("\nProduct Names read from file:");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    System.out.println(parts[1]); // parts[1] is the name
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Error closing reader: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

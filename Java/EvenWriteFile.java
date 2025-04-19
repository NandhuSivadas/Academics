import java.io.*;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {10, 25, 30, 45, 60, 75, 80};
        String filename = "even_numbers.txt";

        BufferedWriter writer = null;
        BufferedReader reader = null;

        // Writing even numbers to the file
        try {
            writer = new BufferedWriter(new FileWriter(filename));
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0) {
                    writer.write(numbers[i] + "\n");
                }
            }
            System.out.println("Even numbers written to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                System.out.println("Error closing writer: " + e.getMessage());
            }
        }

        // Reading even numbers from the file
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            System.out.println("Even numbers read from file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                System.out.println("Error closing reader: " + e.getMessage());
            }
        }
    }
}

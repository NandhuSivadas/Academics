import java.util.Scanner;

class Animal {
    private String species;
    int age;
    float weight;
    protected String color;

    // Constructor for Animal
    public Animal(String species, int age, float weight, String color) {
        this.species = species;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    // Method to display Animal details
    public void displayAnimal() {
        System.out.println(age + " years & " + weight + " kg " + "in " + color);
    }
}

class Dog extends Animal {
    private String name;
    private String owner;

    // Constructor for Dog
    public Dog(String species, int age, float weight, String color, String name, String owner) {
        super(species, age, weight, color);
        this.name = name;
        this.owner = owner;
    }

    // Method to display Dog details
    public void displayDog() {
        System.out.println(name + " owned by " + owner);
    }
}

class Cat extends Animal {
    private String name;
    private double tailLength; // Tail length in centimeters
    private String eyeColor;

    // Constructor for Cat
    public Cat(String species, int age, float weight, String color, String name, double tailLength, String eyeColor) {
        super(species, age, weight, color);
        this.name = name;
        this.tailLength = tailLength;
        this.eyeColor = eyeColor;
    }

    // Method to display Cat details
    public void displayCat() {
        System.out.println(name + " with a " + tailLength + " cm long tail and " + eyeColor + " eyes.");
    }
}

public class AnimalDemo {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for Dog
        System.out.println("Enter Dog details:");
        System.out.print("Enter Dog species: ");
        String dogSpecies = scanner.nextLine();

        System.out.print("Enter Dog age: ");
        int dogAge = scanner.nextInt();

        System.out.print("Enter Dog weight (kg): ");
        float dogWeight = scanner.nextFloat();
        scanner.nextLine();  // Consume the remaining newline character

        System.out.print("Enter Dog color: ");
        String dogColor = scanner.nextLine();

        System.out.print("Enter Dog name: ");
        String dogName = scanner.nextLine();

        System.out.print("Enter Dog owner: ");
        String dogOwner = scanner.nextLine();

        // Create Dog object with user input data
        Dog dog = new Dog(dogSpecies, dogAge, dogWeight, dogColor, dogName, dogOwner);

        // Display the Dog and Animal details
        dog.displayDog();
        dog.displayAnimal();

        // Taking input for Cat
        System.out.println("\nEnter Cat details:");
        System.out.print("Enter Cat species: ");
        String catSpecies = scanner.nextLine();

        System.out.print("Enter Cat age: ");
        int catAge = scanner.nextInt();

        System.out.print("Enter Cat weight (kg): ");
        float catWeight = scanner.nextFloat();
        scanner.nextLine();  // Consume the remaining newline character

        System.out.print("Enter Cat color: ");
        String catColor = scanner.nextLine();

        System.out.print("Enter Cat name: ");
        String catName = scanner.nextLine();

        System.out.print("Enter Cat tail length (cm): ");
        double tailLength = scanner.nextDouble();
        scanner.nextLine();  // Consume the remaining newline character

        System.out.print("Enter Cat eye color: ");
        String eyeColor = scanner.nextLine();

        // Create Cat object with user input data
        Cat cat = new Cat(catSpecies, catAge, catWeight, catColor, catName, tailLength, eyeColor);

        // Display the Cat and Animal details
        cat.displayCat();
        cat.displayAnimal();

        // Close the scanner
        scanner.close();
    }
}


// output
// ------

// Enter Dog details:
// Enter Dog species: Golden Retriver
// Enter Dog age: 2
// Enter Dog weight (kg): 8
// Enter Dog color: brown
// Enter Dog name: Jmmy
// Enter Dog owner: Nandhu
// Jmmy owned by Nandhu
// 2 years & 8.0 kg in brown

// Enter Cat details:
// Enter Cat species: persion
// Enter Cat age: 1
// Enter Cat weight (kg): 5
// Enter Cat color: brown
// Enter Cat name: minnu
// Enter Cat tail length (cm): 15
// Enter Cat eye color: black
// minnu with a 15.0 cm long tail and black eyes.
// 1 years & 5.0 kg in brown

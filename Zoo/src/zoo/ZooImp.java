/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.*;

/**
 * @author Tarquin, Caroline, Primmy and James
 * Class ZooImp implements the Zoo interface,
 * providing the required methods
 */
public class ZooImp implements Zoo {
    
    // Instead of a single list, 
    // we use Map from String (type) to a List of Animals,
    // this allows dynamic categories/types of animals.
    private Map<String, List<Animal>> animalsByType;

    // Constructor: sets up initial data
    public ZooImp() {
        
        // Initialize the HashMap that will store animal types as keys,
        // and lists of Animals as values.
        animalsByType = new HashMap<>();
        
        // Put known categories into the map with empty lists
        animalsByType.put("Mammal", new ArrayList<>());
        animalsByType.put("Bird", new ArrayList<>());
        animalsByType.put("Fish", new ArrayList<>());

        // Populate the collection with initial records,
        // this has been updated with 3 new attributes:
        // healthStatus, hungerStatus and behaviour.
        animalsByType.get("Mammal").add(new Mammal("Lion", 12, 200, 
                "Jungle", "Healthy", "Full", "Sleepy"));
        
        animalsByType.get("Bird").add(new Bird("Eagle", 5, 9, "Trees", 
                "Very Healthy", "Very Full", "Active"));
        
        animalsByType.get("Fish").add(new Fish("Baby Shark", 2, 3, "Ocean", 
                "Not Healthy", "Very Hungry", "Aggresive"));
    }

    @Override
    // Method to list all animals in all categories.
    public void listAllAnimals() {
        
        System.out.println("\nListing all Animals: ");
        System.out.println("-----------------------");
        
        // Loop through each entry in the map: each entry has a type (key) and a list of animals (value).
        for (Map.Entry<String, List<Animal>> entry : animalsByType.entrySet()) {
            
            // type is the category name, e.g., "Mammal".
            String type = entry.getKey();
            
            // Loop through the list of Animals for this type.
            for (Animal animal : entry.getValue()) {
                
                // Print out all animal details.
                // Below are the original attributes.
                System.out.println("Type: " + type);
                System.out.println("Name: " + animal.getName());
                System.out.println("Age: " + animal.getAge());
                System.out.println("Weight: " + animal.getWeight());
                System.out.println("Habitat: " + animal.getHabitat());
                
                // Below are the 3 new attributes added.
                System.out.println("Health Status: " + animal.getHealthStatus());
                System.out.println("Hunger Status: " + animal.getHungerStatus());
                System.out.println("Behaviour: " + animal.getBehaviour());
                System.out.println("-----------------------");
            }
        }
    }

    @Override
    // Method to list all types of animals currently stored,
    // and how many of each animal.
    public void listAllTypes() {
        
        System.out.println("\nType of Animals: ");
        System.out.println("--------------------");
        
        // Iterate over the keys (types) of the map.
        for (String type : animalsByType.keySet()) {
            
            // size is how many animals are in this category.
            int size = animalsByType.get(type).size();
            System.out.println(type + ": " + size);
        }
        System.out.println("--------------------\n");
    }

    @Override
    // Adds an Animal to the collection without specifying type explicitly.
    // We determine the type by checking the instance of the animal.
    // For example, if animal is unknown it will create a new animal class.
    public void addAnimal(Animal animal) {
        
        String type;
        if (animal instanceof Mammal) {
            type = "Mammal";
            
        } else if (animal instanceof Fish) {
            type = "Fish";
            
        } else if (animal instanceof Bird) {
            type = "Bird";
        
        // If it doesn't match known subclasses, we call it "Unknown".
        } else {
            type = "Unknown";
            
        }
        // Delegate to the overloaded method that accepts a type and an animal.
        addAnimal(type, animal);
    }

    // Overloaded method: adds an animal to a specified type category.
    // If the type doesn't exist, create a new entry in the map.
    public void addAnimal(String type, Animal animal) {
        
        // If this is a new type, we create a new list.
        if (!animalsByType.containsKey(type)) {
            animalsByType.put(type, new ArrayList<>());
        }
        
        // Add the animal to the list corresponding to the given type.
        animalsByType.get(type).add(animal);
        
        // Once animal has been added successfully we print.
        System.out.println("Animal has been added successfully to type: " + type);
    }

    // Picks a random animal from all categories.
    @Override
    public void getRandom() {
        
        // Create a combined list of all animals from all types.
        List<Animal> allAnimals = new ArrayList<>();
        for (List<Animal> list : animalsByType.values()) {
            allAnimals.addAll(list);
        }

        // If no animals are present, print a message and return.
        if (allAnimals.isEmpty()) {
            System.out.println("No animals available.");
            return;
        }

        // Pick a random index in the combined list.
        Random random = new Random();
        Animal animal = allAnimals.get(random.nextInt(allAnimals.size()));
        
        System.out.println("\nRandom Animal: ");
        System.out.println("-----------------------");

        // Determine the animal type for display purposes.
        String type;
        if (animal instanceof Mammal) {
            type = "Mammal";
        } else if (animal instanceof Fish) {
            type = "Fish";
        } else if (animal instanceof Bird) {
            type = "Bird";
        } else {
            type = "Unknown";
        }

        // Print the details of this random animal.
        System.out.println("Type: " + type);
        System.out.println("Name: " + animal.getName());
        System.out.println("Age: " + animal.getAge());
        System.out.println("Weight: " + animal.getWeight());
        System.out.println("Habitat: " + animal.getHabitat());
        System.out.println("Health Status: " + animal.getHealthStatus());
        System.out.println("Hunger Status: " + animal.getHungerStatus());
        System.out.println("Behaviour: " + animal.getBehaviour());
        System.out.println("-----------------------");
    }
    
    // Utility method to check if a string represents a numeric value.
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    // Main method: entry point for the program.
    public static void main(String[] args) {
        
        // Create an instance of ZooImp, initializing our data structure.
        ZooImp zoo = new ZooImp();
        
        // Scanner for reading user input from the console.
        Scanner scanner = new Scanner(System.in);
        
        // Variable to store the user's selected menu option.
        MenuOptions selectOption = null;

        // Main menu loop, continues until user selects EXIT,
        // this has been improved if the user typed an invalid option,
        // it will correct the user and reloop.
        do {
            
            System.out.println("Select an Option:\n");
            System.out.println("1. List All Animals");
            System.out.println("2. List Animal Types");
            System.out.println("3. Add Animal");
            System.out.println("4. Random Animal");
            System.out.println("5. Exit");

            // We use a loop to ensure user enters a valid menu number.
            int option = -1;
            
            // Repeat until break when user enters a valid option.
            while (true) { 
                
                try {
                    
                    // Read the user’s input as a string.
                    String input = scanner.nextLine();
                    
                    // Try to parse it as an integer.
                    option = Integer.parseInt(input);
                    
                    // If the number is out of range, prompt again.
                    if (option < 1 || option > MenuOptions.values().length) {
                        System.out.println("Please make a valid selection (1-5):");
                        
                    // Valid option, break the loop    
                    } else {
                        break;
                    }
                    
                // If parsing fails (not a number), print an error and prompt again.
                } catch (NumberFormatException e) {
                    
                    System.out.println("Invalid input! Please enter a number (1-5):");
                }
            }

            // Convert the valid integer into the corresponding MenuOptions enum value.
            selectOption = MenuOptions.values()[option - 1];

            // Switch based on the user's selection.
            switch (selectOption) {
                
                // If user selects 1, list all animals
                case LIST_ANIMALS:
                    zoo.listAllAnimals();
                    break;
                    
                // If user selects 2, list all types
                case LIST_TYPES:
                    zoo.listAllTypes();
                    break;
                    
                // If user selects 3, we add a new animal    
                case ADD_ANIMAL:
                    
                    // Ask the user for the animal type (can be known or unknown)
                    System.out.println("Please enter the Animal type to add (e.g., Mammal, Fish, Bird, or a new type):");                   
                    String typeInput = scanner.nextLine().trim();

                    // We will store the user-provided details here.
                    String[] details;
                    
                    // Keep asking for input until we get exactly 7 details.
                    while (true) {
                        
                        System.out.println("Please provide the Animal details in the format:");
                        System.out.println("Name, Age, Weight, Habitat, HealthStatus, HungerStatus, Behaviour");
                        String line = scanner.nextLine();
                        details = line.split(",");
                        
                        // If we get 7 details, break loop.
                        if (details.length == 7) {
                            break;
                            
                        // Otherwise, tell the user what's wrong and retry,
                        // this would they did not provide 7 correct details.
                        } else {
                            System.out.println("Invalid number of fields! Please provide exactly 7 comma-separated values.");
                        }
                    }

                    // Trim whitespace from each detail.
                    for (int i = 0; i < details.length; i++) {
                        details[i] = details[i].trim();
                    }

                    // Check if Age and Weight are numeric, if not we re-prompt.
                    while (!isNumeric(details[1]) || !isNumeric(details[2])) {
                       
                        System.out.println("Invalid input for Age or Weight! Please re-enter Age and Weight as numbers.");
                        
                        // Re-prompt the entire line.
                        while (true) {
                            System.out.println("Re-enter details (Name, Age, Weight, Habitat, HealthStatus, HungerStatus, Behaviour):");
                            String line = scanner.nextLine();
                            details = line.split(",");
                            
                            // Trim again.
                            if (details.length == 7) {
                                for (int i = 0; i < details.length; i++) {
                                    details[i] = details[i].trim();
                                }
                                
                                // Check numeric fields again.
                                if (isNumeric(details[1]) && isNumeric(details[2])) {
                                    break;
                                    
                                // If still not correct, prompt again.    
                                } else {
                                    System.out.println("Age or Weight still invalid!");
                                }
                                
                            // If user again enters incorrect number of fields.    
                            } else {
                                System.out.println("Invalid number of fields! Please provide exactly 7 comma-separated values.");
                            }
                        }
                        
                        // Break after fixing the input.
                        break;
                    }

                    // Now we have valid numeric fields
                    int age = Integer.parseInt(details[1]);
                    double weight = Double.parseDouble(details[2]);

                    // Based on the type input, 
                    // create the appropriate subclass or a base Animal.
                    Animal newAnimal;
                    
                    switch(typeInput.toLowerCase()) {
                        
                        case "mammal":
                            newAnimal = new Mammal(details[0], age, weight, details[3],
                                    details[4], details[5], details[6]);
                            break;
                            
                        case "fish":
                            newAnimal = new Fish(details[0], age, weight, details[3],
                                    details[4], details[5], details[6]);
                            break;
                            
                        case "bird":
                            newAnimal = new Bird(details[0], age, weight, details[3],
                                    details[4], details[5], details[6]);
                            break;
                            
                        // If user enters a completely new type, we create a base Animal.
                        // This dynamically creates a new category as requested in the CA.
                        default:
                            System.out.println("Unrecognized animal type. Creating a new category: " + typeInput);
                            newAnimal = new Animal(details[0], age, weight, details[3],
                                    details[4], details[5], details[6]);
                            break;
                    }

                    // Format the type name to make it nicer,
                    // (capitalize first letter).
                    String properTypeName = typeInput.substring(0,1).toUpperCase() + typeInput.substring(1).toLowerCase();
                    
                    // Add the new animal to the chosen or newly created category.
                    zoo.addAnimal(properTypeName, newAnimal);
                    break;
                  
                // If user selects 4, show a random animal    
                case RANDOM_ANIMAL:
                    zoo.getRandom();
                    break;
                 
                // If user selects 5, exit the program.    
                case EXIT:
                    System.out.println("Exiting program..");
                    break;
                    
                // This shouldn't occur if we've validated input correctly, 
                // but we leave a default case to complete the code.   
                default:
                    System.out.println("Please try again, make sure your selection is a number!");
            }

        // Loop until user chooses EXIT.
        } while (selectOption != MenuOptions.EXIT);

        // Close the scanner.
        scanner.close();
    }
}
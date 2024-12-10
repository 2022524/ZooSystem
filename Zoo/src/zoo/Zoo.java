/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zoo;

/**
 * @author Tarquin, Caroline, Primmy and James
 * The Zoo interface sets out the methods that any class must provide.
 * It ensures that all implementing classes share the same functionality.
 */
public interface Zoo {
    
    // The Zoo interface defines a contract that any implementing class must follow.
    // It declares methods that represent the functionalities required by the zoo system.
    
        // This enum defines the possible menu options the user can choose from.
        enum MenuOptions {
            LIST_ANIMALS,    // 1. Option displays all animals in the zoo.
            LIST_TYPES,      // 2. Option displays all types of animals in the zoo.
            ADD_ANIMAL,      // 3. Option lets you add an animal to the zoo.
            RANDOM_ANIMAL,   // 4. Option outputs a random animal from the zoo.
            EXIT             // 5. Option closes the zoo program.
        }

        void listAllAnimals(); // Method to list all animals in the system.
        void listAllTypes(); // Method to list all current animal types.
        void addAnimal(Animal animal); // Method to add a new animal.
        void getRandom(); // Method to retrieve and display a random animal.
}
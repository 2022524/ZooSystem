/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zoo;

/**
 *
 * @author Lecturer
 */
public interface Zoo {

        enum MenuOptions{
        
        // contain a couple of options 
            
            LIST_ANIMALS, // 0 +1
            LIST_TYPES, // 1 +1
            ADD_ANIMAL, // 2 +1
            RANDOM_ANIMAL, // 3 +1 
            EXIT // 5

        }
   
        // implementing interfaces requires 
        // that we implement all of the abstarct methods
        
        void listAllAnimals();
        
        void listAllTypes();
        
        void addAnimal(Animal animal); // requires we pas in animal information
        
        void getRandom();
    
}
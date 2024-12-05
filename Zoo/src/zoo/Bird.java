/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo;

/**
 *
 * @author Tarquin, Caroline, Primmy and James
 */
public class Bird extends Animal{
    
    // Once the Mammal extends the animal class
    // it will inherent the animal class attributes
    // we can use to create new animal types 
    // with the parent class attributes
    
    // Create a Dog name: Flix,    2,         12.5,         Home 
    public Bird(String name, int age, double weight, String habitat){
            
            // we want to send this back to the parent 
            super(name, age, weight, habitat);
    }

}
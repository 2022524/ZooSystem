/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo;

/**
 * @author Tarquin, Caroline, Primmy and James
 * The Fish class represents fish, another category of animals.
 * It extends Animal, inheriting all its attributes and behaviours.
 */
public class Fish extends Animal {
    
    // Fish does not add any new attributes or methods,
    // it just categorises a certain type of Animal as Fish.
    
    // Constructor for Fish takes the same parameters as Animal,
    // and passes them to the superclass (Animal) constructor.
    public Fish(String name, int age, double weight, String habitat,
                String healthStatus, String hungerStatus, String behaviour) {
        
        // Calling super initializes the Animal part of the Fish with these values:
        // name, age, weight, habitat, healthStatus, hungerStatus and behaviour.
        super(name, age, weight, habitat, healthStatus, hungerStatus, behaviour);
    }
}
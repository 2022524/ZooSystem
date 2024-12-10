/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo;

/**
 * @author Tarquin, Caroline, Primmy and James
 * The Mammal class represents mammal type animals.
 * It extends Animal, inheriting all its attributes and behaviours.
 */
public class Mammal extends Animal {
    
    // Mammal does not add any new attributes or methods,
    // it just categorises a certain type of Animal as Mammal.
    
    // Constructor for Mammal takes the same parameters as Animal,
    // and passes them to the superclass (Animal) constructor.
    public Mammal(String name, int age, double weight, String habitat,
                  String healthStatus, String hungerStatus, String behaviour) {
        
        // Calling super initializes the Animal part of the Mammel with these values:
        // name, age, weight, habitat, healthStatus, hungerStatus and behaviour.
        super(name, age, weight, habitat, healthStatus, hungerStatus, behaviour);
    }
}
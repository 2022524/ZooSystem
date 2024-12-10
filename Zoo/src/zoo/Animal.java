/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo;

/**
 * @author Tarquin, Caroline, Primmy and James
 * The Animal class is the base class for all animal types.
 * It holds the common attributes that all animals share:
 * For example, name, age, weight, habitat, healthStatus, 
 * hungerStatus and behaviour.
 */
public class Animal {
    
        private String name; // Name of the animal.
        private int age; // Age of the animal (in years).
        private double weight; // Weight of the animal (in kg).
        private String habitat; // Habitat where the animal lives.
        private String healthStatus; // The health status of the animal.
        private String hungerStatus; // The hunger status of the animal.
        private String behaviour; // The animals behaviour eg, Calm.
        
        // Constructor to initialise all attributes of the animal.
        public Animal(String name, int age, double weight, String habitat, String healthStatus, String hungerStatus, String behaviour) {
            
            this.name = name; // Set Name.
            this.age = age; // Set Age.
            this.weight = weight; // Set Weight.
            this.habitat = habitat; // Set Habitat.
            this.healthStatus = healthStatus; // Set Health Status.
            this.hungerStatus = hungerStatus; // Set Hunger Status.
            this.behaviour = behaviour; // Set Behaviour.
        }

        // Getters and Setters for each attribute.
        // Other classes access these through methods.
        // These Getters and Setters maintain encapsulation,
        // by preventing direct access to fields.
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }

        public double getWeight() { return weight; }
        public void setWeight(double weight) { this.weight = weight; }

        public String getHabitat() { return habitat; }
        public void setHabitat(String habitat) { this.habitat = habitat; }

        public String getHealthStatus() { return healthStatus; }
        public void setHealthStatus(String healthStatus) { this.healthStatus = healthStatus; }

        public String getHungerStatus() { return hungerStatus; }
        public void setHungerStatus(String hungerStatus) { this.hungerStatus = hungerStatus; }

        public String getBehaviour() { return behaviour; }
        public void setBehaviour(String behaviour) { this.behaviour = behaviour; }
}

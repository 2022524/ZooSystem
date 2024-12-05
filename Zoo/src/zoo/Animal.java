/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo;

/**
 *
 * @author Tarquin, Caroline, Primmy and James
 */
public class Animal {
    
    // Create some attributes 
    
    private String name;
    private int age;
    private double weight;
    private String habitat;
    
    
//    / The constructor is our point of reference when communicating with this class
    public Animal(String name, int age, double weight, String habitat){
    
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.habitat = habitat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }   
    
}

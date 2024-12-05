/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Lecturer
 */
public class ZooImp implements Zoo{
    // interface implementation 
    // Create a ZooImp constructor 
    // Pick a collection type
    private List<Animal> animals;
    
    public ZooImp(){
        
    this.animals = new ArrayList<>();
     // populate the collection with initial records    
    animals.add(new Mammal("Lion", 12, 200, "Jungle"));
    animals.add(new Bird("Eagle", 5, 9,"Trees"));
    animals.add(new Fish("Baby Shark", 2,3,"Ocean"));
    
    }

    
   // list all animals 
    @Override
    public void listAllAnimals(){
    
            // in order to list all animals we will need to 
            // iterate through the collections and 
            // print out all of the entries 
            
            System.out.println("\nListing all Animals: ");
            System.out.println("-----------------------");
            
            for(Animal animal: animals){
                // for each animals instance 
                // check the animals class
                if(animal instanceof Mammal){
                    // this means that we are iterating in the Mammal class list 
                    // since we know this animal is an instance of mammal 
                    // create a Mammal reference for that animal
                    Mammal mammal = (Mammal) animal;
                    System.out.println("Type: Mammal");
                    System.out.println("Name: " + mammal.getName());
                    System.out.println("Age: " + mammal.getAge());
                    System.out.println("Weight: " + mammal.getWeight());
                    System.out.println("Habitat: " + mammal.getHabitat());   
            }else if(animal instanceof Fish){
                    Fish fish = (Fish) animal;
                    System.out.println("Type: Fish");
                    System.out.println("Name: " + fish.getName());
                    System.out.println("Age: " + fish.getAge());
                    System.out.println("Weight: " + fish.getWeight());
                    System.out.println("Habitat: " + fish.getHabitat()); 
            
            } else if (animal instanceof Bird){
            
                    Bird bird = (Bird) animal;
                    System.out.println("Type: Bird");
                    System.out.println("Name: " + bird.getName());
                    System.out.println("Age: " + bird.getAge());
                    System.out.println("Weight: " + bird.getWeight());
                    System.out.println("Habitat: " + bird.getHabitat()); 
            } 
            System.out.println("-----------------------");              
          }
    }
    
    @Override
    public void listAllTypes(){
        
        // List all animal types 
        // by counting how many of each type we have 
        
        // we need to construct seperate collection spaces for each type
        // then we need to populate each of the 
        // collections according to their types of animals
        // we need to return the sizes of each of these collections 
        // change this so you could use HashMaps
        List<Mammal> mammals = new ArrayList<>();
        List<Bird> birds = new ArrayList<>();
        List<Fish> fish = new ArrayList<>();
        
        // iterate and populate 
        for(Animal animal: animals){
        
            if(animal instanceof Mammal){
                mammals.add((Mammal) animal);
            }else if(animal instanceof Fish){
                fish.add((Fish) animal);
            } else if(animal instanceof Bird){
                birds.add((Bird) animal);
            }
        }
        
        System.out.println("\nType of Animals: ");
        System.out.println("--------------------");
        System.out.println("Mammals: " + mammals.size());
        System.out.println("Fish: " + fish.size());
        System.out.println("Bird: " + birds.size());
        System.out.println("--------------------\n");
        
    }
    
    
    @Override    
//                        Animal(String name, int age, double weight, String habitat)
    public void addAnimal(Animal animal){
    
        animals.add(animal);
        System.out.println("Amimal has been added successfully!");
    
    } // requires we pass in animal information
    
    @Override    
    public void getRandom(){
    
            // Get a random index position
            // then use that random index position to retrieve an animal at that location
            Random random = new Random();
            // whatever number we get back we can use to get a random entry at that location
            int index = random.nextInt(animals.size()); // get the size of the list 
//           random number will be between 0 and list size 3
            
            Animal animal = animals.get(index);
        
            System.out.println("\nRandom Animal: ");
            System.out.println("-----------------------");
            
                // for each animals instance 
                // check the animals class
                if(animal instanceof Mammal){
                    // this means that we are iterating in the Mammal class list 
                    // since we know this animal is an instance of mammal 
                    // create a Mammal reference for that animal
                    Mammal mammal = (Mammal) animal;
                    System.out.println("Type: Mammal");
                    System.out.println("Name: " + mammal.getName());
                    System.out.println("Age: " + mammal.getAge());
                    System.out.println("Weight: " + mammal.getWeight());
                    System.out.println("Habitat: " + mammal.getHabitat());   
            }else if(animal instanceof Fish){
                    Fish fish = (Fish) animal;
                    System.out.println("Type: Fish");
                    System.out.println("Name: " + fish.getName());
                    System.out.println("Age: " + fish.getAge());
                    System.out.println("Weight: " + fish.getWeight());
                    System.out.println("Habitat: " + fish.getHabitat()); 
            
            } else if (animal instanceof Bird){
            
                    Bird bird = (Bird) animal;
                    System.out.println("Type: Bird");
                    System.out.println("Name: " + bird.getName());
                    System.out.println("Age: " + bird.getAge());
                    System.out.println("Weight: " + bird.getWeight());
                    System.out.println("Habitat: " + bird.getHabitat()); 
            } 
            System.out.println("-----------------------");              
  
    }
    
    public static Boolean isNumeric(String str){
            // the input coming from the users mammalDetails contains
//             mammalDetails = ["Lion", "12", "120", "Jungle"]
//          We need to validate the string number values to be numeric 
//                          -?  ?  "2" "2.2" are true
            return str.matches("-?\\d+(\\.\\d+)?");
//             return true or false if the string is a numeric value == "2"
    }
    
    
    
    public static void main(String[] args){
    
    
    // construct a zooImp constructor reference 
    ZooImp zoo = new ZooImp();
    
    Scanner scanner = new Scanner(System.in);
    // create an interface reference to access 
    // the enums to use as our set of options and test against userinput
    // the enums are in the interface Zoo
    MenuOptions selectOption = null;
    
    do{
    
        System.out.println("Select an Option:\n");
        System.out.println("1. List All Animals");
        System.out.println("2. List Animal Types");
        System.out.println("3. Add Animal");
        System.out.println("4. Random Animal");
        System.out.println("5. Exit");
        
        // capture user selection as a number
        int option = scanner.nextInt(); // this is the user choice == 3
    
    // validate user choice 
    if(option < 1 || option > MenuOptions.values().length){
    // as long as the value is not less than the choices of enums or more 
        System.out.println("Please make a valid selection from the menu ranges");
    }else{
//        the userinput will not match the enums 
//        because ethe enums are 0 indexed
//        our menu starts at 1
        selectOption = MenuOptions.values()[option -1]; // 3 - 1 = [0] index enum
        // this will match the user input with the enum index
        
        switch(selectOption){
            
            case LIST_ANIMALS: // instead of using a number for cases we use enums 
                zoo.listAllAnimals();
                break;
            case LIST_TYPES: // 1
                zoo.listAllTypes();
                break;
            case ADD_ANIMAL:
                
//                We need to know what type of Animal instance the user wants to add
//                We have Mammal Bird or Fish 3 instances of 3 classes
                System.out.println("Please select the Animal type to add:\n(1. Mammal\n2. Fish\n3. Bird) ");    
//                Capture the user input 
                int type = scanner.nextInt();
//                Create a switch case on the user type of animal
                switch(type){
                // if 1. We add a Mammal               
                    case 1:
                        System.out.println("Please provide the Mammal (Name, Age, Weight, Habitat)");
//                        Take the user input and store it in a string array []
//                        The data structure is a CSV comma seperated 
//                        userinput = "Lion, 12, 120, Jungle"
//                        Specify the delim using split() == ,
//                        make it a string array = ["Lion", "12", "120", "Jungle"]
//                                                   1        2     3        4
//                        String[] mammalDetails = ["Lion", "12", "120", "Jungle"]
                        scanner.nextLine();
                        String[] mammalDetails = scanner.nextLine().split(",");
//                        System.out.println("printing split" + mammalDetails);
                        if (mammalDetails.length == 4){
//                            System.out.println("printing split" + mammalDetails);
//                            do this because we have 4 fields 
//                            mammalDetails = ["Lion", "12", "120", "Jungle"]
                //              Animal(String name, int age, double weight, String habitat)                
                //              Mammal [name, age, weight, habitat] 
                //              zoo.addAnimal(Animal animal); 
                            // create a method to validate numeric entries 
                                // Validate that the string in the age and weight fields are numeric
//                            mammalDetails = [" Lion ", " 12", " 120 ", " Jungle"]
//                                              0,      1,      2,      3
//                                    System.out.println("Is Numeric check");
                                if(isNumeric(mammalDetails[1].trim()) && isNumeric(mammalDetails[2].trim())){                        
//                                Do this insert the data into the matching class instance
//                                            System.out.println("printing split" + mammalDetails);
                                            zoo.addAnimal(new Mammal(
                                                    mammalDetails[0].trim(), // Name 
                                                    Integer.parseInt(mammalDetails[1].trim()), // Age
                                                    Double.parseDouble(mammalDetails[2].trim()), // Weight
                                                    mammalDetails[3].trim() // Habitat
                                            ));
                                }else{
//                                    If the input is mismatching the type of value 
//                                      ValueError
                                        System.out.println("Invalid input for Age or Weight!\nMake sure both are numeric i.e (2 or 2.2)");
                                }
                        }else{
                            System.out.println("Invalid Input!");
                            System.out.println("Please make sure to use a comma seperated format");
                            System.out.println("Name, Age, Weight, Habitat");
                        } 
                    break;
                    case 2:
                        System.out.println("Please provide the Fish (Name, Age, Weight, Habitat)");
//                        Take the user input and store it in a string array []
//                        The data structure is a CSV comma seperated 
//                        userinput = "Lion, 12, 120, Jungle"
//                        Specify the delim using split() == ,
//                        make it a string array = ["Lion", "12", "120", "Jungle"]
//                                                   1        2     3        4
//                        String[] mammalDetails = ["Lion", "12", "120", "Jungle"]
                        scanner.nextLine();
                        String[] fishDetails = scanner.nextLine().split(",");
//                        System.out.println("printing split" + mammalDetails);
                        if (fishDetails.length == 4){
//                            System.out.println("printing split" + mammalDetails);
//                            do this because we have 4 fields 
//                            mammalDetails = ["Lion", "12", "120", "Jungle"]
                //              Animal(String name, int age, double weight, String habitat)                
                //              Mammal [name, age, weight, habitat] 
                //              zoo.addAnimal(Animal animal); 
                            // create a method to validate numeric entries 
                                // Validate that the string in the age and weight fields are numeric
//                            mammalDetails = [" Lion ", " 12", " 120 ", " Jungle"]
//                                              0,      1,      2,      3
//                                    System.out.println("Is Numeric check");
                                if(isNumeric(fishDetails[1].trim()) && isNumeric(fishDetails[2].trim())){                        
//                                Do this insert the data into the matching class instance
//                                            System.out.println("printing split" + mammalDetails);
                                            zoo.addAnimal(new Fish(
                                                    fishDetails[0].trim(), // Name 
                                                    Integer.parseInt(fishDetails[1].trim()), // Age
                                                    Double.parseDouble(fishDetails[2].trim()), // Weight
                                                    fishDetails[3].trim() // Habitat
                                            ));
                                }else{
//                                    If the input is mismatching the type of value 
//                                      ValueError
                                        System.out.println("Invalid input for Age or Weight!\nMake sure both are numeric i.e (2 or 2.2)");
                                }
                        }else{
                            System.out.println("Invalid Input!");
                            System.out.println("Please make sure to use a comma seperated format");
                            System.out.println("Name, Age, Weight, Habitat");
                        } 
                    break;
                    case 3:
                        System.out.println("Please provide the Bird (Name, Age, Weight, Habitat)");
//                        Take the user input and store it in a string array []
//                        The data structure is a CSV comma seperated 
//                        userinput = "Lion, 12, 120, Jungle"
//                        Specify the delim using split() == ,
//                        make it a string array = ["Lion", "12", "120", "Jungle"]
//                                                   1        2     3        4
//                        String[] mammalDetails = ["Lion", "12", "120", "Jungle"]
                        scanner.nextLine();
                        String[] birdDetails = scanner.nextLine().split(",");
//                        System.out.println("printing split" + mammalDetails);
                        if (birdDetails.length == 4){
//                            System.out.println("printing split" + mammalDetails);
//                            do this because we have 4 fields 
//                            mammalDetails = ["Lion", "12", "120", "Jungle"]
                //              Animal(String name, int age, double weight, String habitat)                
                //              Mammal [name, age, weight, habitat] 
                //              zoo.addAnimal(Animal animal); 
                            // create a method to validate numeric entries 
                                // Validate that the string in the age and weight fields are numeric
//                            mammalDetails = [" Lion ", " 12", " 120 ", " Jungle"]
//                                              0,      1,      2,      3
//                                    System.out.println("Is Numeric check");
                                if(isNumeric(birdDetails[1].trim()) && isNumeric(birdDetails[2].trim())){                        
//                                Do this insert the data into the matching class instance
//                                            System.out.println("printing split" + mammalDetails);
                                            zoo.addAnimal(new Bird(
                                                    birdDetails[0].trim(), // Name 
                                                    Integer.parseInt(birdDetails[1].trim()), // Age
                                                    Double.parseDouble(birdDetails[2].trim()), // Weight
                                                    birdDetails[3].trim() // Habitat
                                            ));
                                }else{
//                                    If the input is mismatching the type of value 
//                                      ValueError
                                        System.out.println("Invalid input for Age or Weight!\nMake sure both are numeric i.e (2 or 2.2)");
                                }
                        }else{
                            System.out.println("Invalid Input!");
                            System.out.println("Please make sure to use a comma seperated format");
                            System.out.println("Name, Age, Weight, Habitat");
                        } 
                    break;
                    default:
                        System.out.println("Invalid selection from default");
                }
                break;
            case RANDOM_ANIMAL: // 2
                zoo.getRandom();
                break;
            case EXIT: // 3
                System.out.println("Exiting program..");
                break;
            default:
                System.out.println("Please try again, make sure your selection is a number!");
            }
        } 
    }while(selectOption != MenuOptions.EXIT);
   }
 
}

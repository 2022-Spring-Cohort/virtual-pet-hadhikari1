package PetsAmok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VirtualPetShelter {

    public Map<String, VirtualPets> allPetsInShelter = new HashMap<>();

    public void allOrganicPetStatus(){
        for(VirtualPets pet :allPetsInShelter.values()){
            if(pet instanceof OrganicCat){
                System.out.println(pet.toString() + "\n");
            }
            if (pet instanceof OrganicDog){
                System.out.println(pet.toString() + "\n");
            }
        }
    }
    public void allRoboticPetStatus(){
        for(VirtualPets pet :allPetsInShelter.values()){
            if(pet instanceof RoboticDog){
                System.out.println(pet.toString() + "\n");
            }
            if(pet instanceof RoboticCat){
                System.out.println(pet.toString() + "\n");
            }
        }
    }
    public void allPetsStatus(){
        for(VirtualPets pet :allPetsInShelter.values()){
            if(pet instanceof OrganicCat){
                System.out.println(pet.toString() + "\n");
            }
            if (pet instanceof OrganicDog){
                System.out.println(pet.toString() + "\n");
            }
            if(pet instanceof RoboticDog){
                System.out.println(pet.toString() + "\n");
            }
            if(pet instanceof RoboticCat){
                System.out.println(pet.toString() + "\n");
            }
        }
    }
    public void allDogsStatus(){
        for(VirtualPets pet :allPetsInShelter.values()){
            if (pet instanceof OrganicDog || pet instanceof RoboticDog){
                System.out.println(pet.toString() + "\n");
            }
        }
    }
    public void organicDogsStatus(){
        for(VirtualPets pet :allPetsInShelter.values()){

            if (pet instanceof OrganicDog){
                System.out.println(pet.toString() + "\n");
            }
        }
    }
    public void organicCatsStatus(){
        for(VirtualPets pet :allPetsInShelter.values()){

            if (pet instanceof OrganicCat){
                System.out.println(pet.toString() + "\n");
            }
        }
    }

    public List<String> getListOfAllPetsNames(){
        List<String> names = new ArrayList<>();
        for(VirtualPets pet : allPetsInShelter.values()){
            names.add(pet.getName());
        }
        return names;
    }

//    public String getPetNamesByType(int userInput){
//        List<String> names = new ArrayList<>();
//        if(userInput == 1){
//            for(VirtualPets pet: allPetsInShelter.values()){
//                if(pet instanceof RoboticCat || pet instanceof RoboticDog){
//                    names.add(pet.getName());
//                }
//            }
//        }
//        if(userInput == 2){
//            for(VirtualPets pet: allPetsInShelter.values()){
//                if(pet instanceof OrganicCat || pet instanceof OrganicDog){
//                    names.add(pet.getName());
//                }
//            }
//        }
//        if(userInput == 3){
//            for(VirtualPets pet: allPetsInShelter.values()){
//                    names.add(pet.getName());
//
//            }
//        }
//        return names.toString();
//    }

    public VirtualPets getPetsByName(String givenName){
        VirtualPets pet = allPetsInShelter.get(givenName.toLowerCase());
        return pet;
    }

    public void addPetsToShelter(VirtualPets needsHome){
        allPetsInShelter.put(needsHome.getName().toLowerCase(), needsHome);
    }
// exit game/ choose pet to adopt
    public void adoption(String petNameToBeAdopted){
        if(allPetsInShelter.isEmpty()){
            System.out.println("All pets have been adopted :)");
        }
        else {
            allPetsInShelter.remove(petNameToBeAdopted.toLowerCase());
        }
    }

//    public Map<String, OrganicPets> getOrganicPets(){
//        Map<String, OrganicPets> allOrganicPets = new HashMap<>();
//        for( VirtualPets allOrganic: allPetsInShelter.values()){
//            if(allOrganic instanceof OrganicDog || allOrganic instanceof OrganicCat){
//                allOrganicPets.put(allOrganic.getName(), (OrganicPets) allOrganic);
//            }
//        }
//        return allOrganicPets;
//    }
//
//    public Map<String, OrganicDog> getOrganicDogs(){
//        Map<String, OrganicDog> allOrganicDog = new HashMap<>();
//        for(VirtualPets dogs: allPetsInShelter.values()){
//            if(dogs instanceof OrganicDog){
//                allOrganicDog.put(dogs.getName(), (OrganicDog) dogs);
//            }
//        }
//        return allOrganicDog;
//    }
//
//        public Map<String, RoboticPets> getRoboticPets(){
//        Map<String, RoboticPets> roboPets = new HashMap<>();
//        for(VirtualPets pets: allPetsInShelter.values()){
//            if(pets instanceof RoboticDog || pets instanceof RoboticCat){
//                roboPets.put(pets.getName(), (RoboticPets) pets);
//            }
//        }
//        return roboPets;
//    }
//
//    public Map<String, RoboticDog> getRoboticDogs(){
//        Map<String, RoboticDog> roboticDogs = new HashMap<>();
//        for (VirtualPets pets : allPetsInShelter.values()){
//            if(pets instanceof RoboticDog) {
//                roboticDogs.put(pets.getName(), (RoboticDog) pets);
//            }
//        }
//        return roboticDogs;
//    }

    public void walkAllDogs() {
        for(VirtualPets dog : allPetsInShelter.values()){
            if(dog instanceof RoboticDog || dog instanceof OrganicDog){
                ((Walkable) dog).walkable();
            }
        }
    }

    public void cleanCagesForOrganicDogs(){
        for (VirtualPets dog: allPetsInShelter.values()){
            if(dog instanceof OrganicDog){
                ((OrganicDog) dog).clean();
            }
        }
    }

//    public void cleanLitterBoxOfOrganicCats(){
//        for(VirtualPets cat: allPetsInShelter.values()){
//            if(cat instanceof OrganicCat){
//                ((OrganicCat) cat).clean();
//            }
//        }
//    }

    public void oilAllRoboticPets(){
        for(VirtualPets pets: allPetsInShelter.values()){
            if(pets instanceof RoboticDog || pets instanceof RoboticCat){
                ((RoboticPets) pets).oilRoboticPet();
            }
        }
    }

    public void chargeAllPets(){
        for (VirtualPets pets: allPetsInShelter.values()){
            if(pets instanceof RoboticCat || pets instanceof RoboticDog){
                ((RoboticPets) pets).chargeBattery();
            }
        }
    }
//    public void oilSingleRoboticPets(String givenName){
//        VirtualPets pet = getPetsByName(givenName);
//        if(pet instanceof RoboticDog || pet instanceof RoboticCat) {
//            ((RoboticPets) pet).oilRoboticPet();
//        }
//        else{
//            System.out.println("Wrong Pet Type");
//        }
//    }
//    public void chargeSinglePet(String givenName){
//        VirtualPets pet = getPetsByName(givenName);
//        if(pet instanceof RoboticDog || pet instanceof RoboticCat){
//            ((RoboticPets) pet).chargeBattery();
//        }
//        else {
//            System.out.println("Wrong Pet Type");
//        }
//    }

    public void feedAllOrganicPets(){
        for(VirtualPets pets: allPetsInShelter.values()){
            if(pets instanceof OrganicDog || pets instanceof OrganicCat){
                ((OrganicPets) pets).feedPet();
            }
        }
    }

//    public void feedSingleOrganicPet(String givenName){
//        VirtualPets pet = getPetsByName(givenName);
//        if(pet instanceof OrganicCat || pet instanceof OrganicDog){
//            ((OrganicPets) pet).feedPet();
//        }
//        else{
//            System.out.println("Wrong Pet Type");
//        }
//    }

    public void bathroomBreakOrganicPets(){
        for(VirtualPets pets: allPetsInShelter.values()){
            if(pets instanceof OrganicDog || pets instanceof OrganicCat){
                ((OrganicPets) pets).bathroomBreak();
            }
        }
    }

    public void playWithSinglePet(String givenName){
        VirtualPets pet = getPetsByName(givenName);
        pet.playTime();
    }
//paywith allpets
    public void playWithAllPets(){
        for(VirtualPets pets: allPetsInShelter.values()){
            pets.playTime();
        }
    }

    public void tickAllPets(){
        for(VirtualPets pet: allPetsInShelter.values()){
            pet.tick();
        }
    }
    public void tickRoboticPets(){
        for(VirtualPets pet: allPetsInShelter.values()){
            if (pet instanceof RoboticDog || pet instanceof RoboticCat){
                pet.tick();
            }
        }
    }
    public void tickOrganicPets(){
        for(VirtualPets pet: allPetsInShelter.values()){
            if (pet instanceof OrganicCat || pet instanceof OrganicDog){
                pet.tick();
            }
        }
    }

    public void tickASinglePet(String givenName){
        VirtualPets pet = getPetsByName(givenName);
        pet.tick();
    }

    public boolean areNeedsForAnyPetsHigh(){
        boolean areNeedsForAnyPetsHigh = true;
        for(VirtualPets pet: allPetsInShelter.values()){
            if(!pet.needs()){
                areNeedsForAnyPetsHigh = false;
            }
        }
        return areNeedsForAnyPetsHigh;
    }
//    public boolean areNeedsForRoboticPetsHigh(){
//        boolean areNeedsForAnyPetsHigh = true;
//        for(VirtualPets pet: allPetsInShelter.values()){
//            if((pet instanceof RoboticCat || pet instanceof RoboticDog) && pet.needs()){
//                areNeedsForAnyPetsHigh = false;
//                break;
//            }
//        }
//        return areNeedsForAnyPetsHigh;
//    }

}

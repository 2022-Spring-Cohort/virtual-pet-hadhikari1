package virtual_pet.shelter;

import virtual_pet.VirtualPet;

import java.util.*;

public class Shelter{
    List<VirtualPet> virtualPetList = new ArrayList<>();
    public void addPet(VirtualPet pet){
        virtualPetList.add(pet);
    }

    public void adoptAPet(VirtualPet pet){
        for(int i = 0; i < virtualPetList.size(); i++) {
            if(pet.getName().equals(virtualPetList.get(i).getName())){
                virtualPetList.remove(i);
            }
        }
    }

    public List<VirtualPet> getAllPets(){
        return virtualPetList;
    }

    public void feedAllPets(List<VirtualPet> petList){
        for(VirtualPet pets: petList){
            pets.feedPet();
        }
    }

    public void playTimeWithAllPets(List<VirtualPet> petList){
        for(VirtualPet virtualPets: petList){
            virtualPets.playTime();
        }
    }

    public void napTimeForAllPets(List<VirtualPet> petList){
        for(VirtualPet allPets: petList){
            allPets.napTime();
        }
    }

    public void tickAllPets(List<VirtualPet> petList){
        for(VirtualPet allVirtualPet: petList){
            allVirtualPet.tick();
        }
    }

    public void getAllPetsStatus(List<VirtualPet> petList){
        for(VirtualPet pet: petList){
            System.out.println("\nStatus For "+ pet.getName());
            pet.getPetStatus();
        }
    }

    public void feedSinglePet(VirtualPet pet){
        pet.feedPet();
    }

    public void playWithSinglePet(VirtualPet pet){
        pet.playTime();
    }

    public void singlePetNapTime(VirtualPet pet){
        pet.napTime();
    }

    public void tickSinglePet( VirtualPet pet){
        pet.tick();
    }

    public void getSinglePetStatus(VirtualPet pet){
        pet.getPetStatus();
    }
}

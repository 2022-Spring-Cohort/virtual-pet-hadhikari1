package virtual_pet.PetsAmok;

import PetsAmok.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class VirtualPetShelterTest {
    VirtualPetShelter shelter;
    @BeforeEach
    public void setUp() {
        shelter = new VirtualPetShelter();

        VirtualPets organicCat1 = new OrganicCat("daisy",100,100,100,100,
                100,100);
        VirtualPets organicCat2 = new OrganicCat("simba",100,100,100,100,
                100,100);
        VirtualPets organicDog1 = new OrganicDog("luna",100,100,100,100,
                100,100);
        VirtualPets organicDog2 = new OrganicDog("sadie",100,100,100,100,
                100,100);
        VirtualPets roboticCat1 = new RoboticCat("milo",100,100,100,100);
        VirtualPets roboticCat2 = new RoboticCat("shadow",100,100,100,100);
        VirtualPets roboticDog1 = new RoboticDog("bear",100,100,100,100);
        VirtualPets roboticDog2 = new RoboticDog("buddy",100,100,100,100);


        shelter.allPetsInShelter.put(organicCat1.getName().toLowerCase(), organicCat1);
        shelter.allPetsInShelter.put(organicCat2.getName().toLowerCase(), organicCat2);
        shelter.allPetsInShelter.put(organicDog1.getName().toLowerCase(), organicDog1);
        shelter.allPetsInShelter.put(organicDog2.getName().toLowerCase(), organicDog2);
        shelter.allPetsInShelter.put(roboticCat1.getName().toLowerCase(), roboticCat1);
        shelter.allPetsInShelter.put(roboticCat2.getName().toLowerCase(), roboticCat2);
        shelter.allPetsInShelter.put(roboticDog1.getName().toLowerCase(), roboticDog1);
        shelter.allPetsInShelter.put(roboticDog2.getName().toLowerCase(), roboticDog2);
    }

    @Test
    public void allOrganicPetStatusTest() {
        shelter.allOrganicPetStatus();
        VirtualPets pet = shelter.getPetsByName("simba");
        assertEquals(pet.getName(), "simba");
    }
    @Test
    public void allRoboticPetStatusTest() {
        shelter.allRoboticPetStatus();
        VirtualPets pet = shelter.getPetsByName("bear");
        assertEquals(pet.getHappiness(), 100);
    }

    @Test
    public void getListOfAllPetsNames() {
        List<String> list = shelter.getListOfAllPetsNames();
        assertEquals(list, List.of(new String[]{"sadie", "simba", "shadow", "bear", "daisy", "milo", "buddy", "luna"}));

    }

    @Test
    public void getPetsByNameTest(){
        VirtualPets pet = shelter.getPetsByName("buddy");
        assertEquals(pet.getName(), "buddy");
    }

    @Test
    public void walkAllDogsTest(){
        shelter.walkAllDogs();
        VirtualPets pet = shelter.getPetsByName("bear");
        assertEquals(pet.getHealth(), 95);
    }

    @Test
    public void cleanCagesForOrganicDogsTest(){
        shelter.cleanCagesForOrganicDogs();
        VirtualPets pet = shelter.getPetsByName("luna");
        assertEquals(pet.getHappiness(),105);
    }

    @Test
    public void areNeedsForAnyPetsHigTest(){
        boolean isNeedHigh = shelter.areNeedsForAnyPetsHigh();
        assertEquals(false, isNeedHigh);

    }
    @Test
    public void adoptionTest() {
        shelter.adoption("luna");
        assertEquals(shelter.allPetsInShelter.size(), 7);
    }

    @Test
    public void addPetsToShelterTest() {
        VirtualPets pet = new RoboticCat("lulu",100,100,100,100);
        shelter.addPetsToShelter(pet);
        assertEquals(shelter.allPetsInShelter.size(), 9);
    }
}

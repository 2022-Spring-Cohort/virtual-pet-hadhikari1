package virtual_pet.PetsAmok;

import PetsAmok.OrganicCat;
import PetsAmok.OrganicDog;
import PetsAmok.RoboticCat;
import PetsAmok.VirtualPets;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {
    @Test
    public void tickTest(){
        VirtualPets pet = new OrganicCat("whiskers",100,100,100,
                100,100,100);
        pet.tick();
        assertEquals(pet.getHappiness(),95);
    }
    public void tickTest1(){
        VirtualPets pet = new RoboticCat("whiskers",100,100,100,
                100);
        pet.tick();
        assertEquals(pet.getHappiness(),95);
    }



}

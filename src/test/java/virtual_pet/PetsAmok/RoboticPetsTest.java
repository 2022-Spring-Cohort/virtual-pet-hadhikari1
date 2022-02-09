package virtual_pet.PetsAmok;

import PetsAmok.RoboticCat;
import PetsAmok.RoboticDog;
import PetsAmok.RoboticPets;
import PetsAmok.VirtualPets;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoboticPetsTest {
    @Test
    public void chargeBatteryTest(){
        RoboticPets pet = new RoboticDog("bear",100,100,100,100);
        pet.chargeBattery();
        assertEquals(pet.getBatteryLife(), 105);
    }
    @Test
    public void oilRoboticPetTest(){
        RoboticPets pet = new RoboticCat("lulu",100,100,100,100);
        pet.oilRoboticPet();
        assertEquals(pet.getBatteryLife(), 95);
    }
    @Test
    public void tick(){
        RoboticPets pet = new RoboticCat("swan",100,100,100,100);
        pet.tick();
        assertEquals(pet.getMaintenance(), 95);
    }



}

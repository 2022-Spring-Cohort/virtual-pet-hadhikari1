package virtual_pet.PetsAmok;

import PetsAmok.RoboticDog;
import PetsAmok.RoboticPets;
import PetsAmok.VirtualPets;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoboticDogTest {
    @Test
    public void walkableTest(){
        RoboticDog pet = new RoboticDog("bear",100,100,100,100);
        pet.walkable();
        assertEquals(pet.getHealth(),95);
    }

}

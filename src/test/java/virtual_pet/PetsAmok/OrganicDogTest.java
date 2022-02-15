package virtual_pet.PetsAmok;

import PetsAmok.OrganicDog;
import PetsAmok.RoboticDog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrganicDogTest {
    @Test
    public void walkableTest(){
        OrganicDog pet = new OrganicDog("bear",40,50,55,80,90,70);
        pet.walkable();
        assertEquals(pet.getHealth(),45);
    }

    @Test
    public void isCageCleanTest(){
        OrganicDog pet = new OrganicDog("lulu",40,50,55,80,90,70);
        pet.clean();
        assertEquals(pet.getCageCleanliness(),75);
    }

    @Test
    public void organicDogTick(){
        OrganicDog pet = new OrganicDog("lulu",40,50,55,80,90,70);
        pet.tick();
        assertEquals(pet.getCageCleanliness(),75);
    }


}

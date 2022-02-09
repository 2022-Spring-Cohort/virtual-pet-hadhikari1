package virtual_pet.PetsAmok;

import PetsAmok.OrganicCat;
import PetsAmok.OrganicDog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrganicCatTest {
    @Test
    public void isLitterBoxCleanTest() {
        OrganicCat pet = new OrganicCat("whiskers", 40, 50, 55, 80, 90, 70);
        pet.clean();
        assertEquals(pet.getHappiness(), 55);
    }
}

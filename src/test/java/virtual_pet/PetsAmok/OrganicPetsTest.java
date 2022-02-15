package virtual_pet.PetsAmok;

import PetsAmok.OrganicPets;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrganicPetsTest {
    @Test
    public void feedPetTest(){
        OrganicPets pet = new OrganicPets("Shadow",100,100,100,100,100);
        pet.feedPet();
        assertEquals(pet.getWaste(), 90);
    }
    @Test
    public void bathroomBreakTest(){
        OrganicPets pet = new OrganicPets("lea",100,10,100,100,100);
        pet.feedPet();
        assertEquals(pet.getHappiness(), 15);
    }
    @Test
    public void playTimeTest(){
        OrganicPets pet = new OrganicPets("whiskers",100,100,100,100,100);
        pet.playTime();
        assertEquals(pet.getHunger(),95 );
    }
    @Test
    public void tickOrganicPetsTest(){
        OrganicPets pet = new OrganicPets("susu",40,45,40,50,50);
        pet.tick();
        assertEquals(pet.getBoredom(),45);
    }
}

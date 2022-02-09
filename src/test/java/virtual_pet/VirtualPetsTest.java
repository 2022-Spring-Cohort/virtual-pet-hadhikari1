package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetsTest {
    @Test
    public void getNameTest() {
      VirtualPet pet = new VirtualPet("Whiskers");
      String actual = pet.getName();
      assertEquals("Whiskers", actual);
    }
    @Test
    public void feedPetTest() {
        VirtualPet pet = new VirtualPet("Whiskers");
        pet.feedPet();
        assertEquals(1,pet.getHunger());
        assertEquals(3,pet.getBoredom());
        assertEquals(3,pet.getSleepy());
    }
    @Test
    public void playTimeTest() {
        VirtualPet pet = new VirtualPet("Whiskers");
        pet.playTime();
        assertEquals(3,pet.getHunger());
        assertEquals(3,pet.getSleepy());
        assertEquals(1,pet.getBoredom());
    }
    @Test
    public void napTimeTest() {
        VirtualPet pet = new VirtualPet("Whiskers");
        pet.napTime();
        assertEquals(3,pet.getBoredom());
        assertEquals(3,pet.getHunger());
        assertEquals(1,pet.getSleepy());
    }
    @Test
    public void tickTest(){
        VirtualPet pet = new VirtualPet("Whiskers");
        pet.tick();
        assertEquals(6,pet.getHunger());
        assertEquals(6,pet.getBoredom());
        assertEquals(6,pet.getSleepy());
    }

}

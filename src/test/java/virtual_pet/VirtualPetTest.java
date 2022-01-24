package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {
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
        assertEquals(2,pet.getHunger());
        assertEquals(4,pet.getBoredom());
        assertEquals(4,pet.getSleepy());
    }
    @Test
    public void playTimeTest() {
        VirtualPet pet = new VirtualPet("Whiskers");
        pet.playTime();
        assertEquals(4,pet.getHunger());
        assertEquals(4,pet.getSleepy());
        assertEquals(2,pet.getBoredom());
    }
    @Test
    public void napTimeTest() {
        VirtualPet pet = new VirtualPet("Whiskers");
        pet.napTime();
        assertEquals(4,pet.getBoredom());
        assertEquals(4,pet.getHunger());
        assertEquals(2,pet.getSleepy());
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

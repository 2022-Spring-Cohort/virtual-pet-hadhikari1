package virtual_pet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virtual_pet.shelter.Shelter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class shelterTest {
    Shelter underTest;
    @BeforeEach
    public void setUp() {
        underTest = new Shelter();
        VirtualPet pet1 = new VirtualPet("Rex");
        VirtualPet pet2 = new VirtualPet("Spot");
        VirtualPet pet3 = new VirtualPet("Whiskers");
        underTest.addPet(pet1);
        underTest.addPet(pet2);
        underTest.addPet(pet3);
    }

    @Test
    public void shouldAddPetsToListTest() {
        VirtualPet pet4 = new VirtualPet("Gertrude");
        underTest.addPet(pet4);
        List<VirtualPet> petList = underTest.getAllPets();
        assertEquals(4,petList.size());
        assertEquals("Gertrude",petList.get(3).getName());
    }

    @Test
    public void shouldAdoptAPetFromListTest() {
        List<VirtualPet> petList = underTest.getAllPets();
        underTest.adoptAPet(petList.get(0));
        assertEquals(2,petList.size());
    }
    @Test
    public void shouldGetAllPetsFromListTest(){
        List<VirtualPet> petList = underTest.getAllPets();
        assertEquals(3,petList.size());
    }
    @Test
    public void shouldFeedAllPetsFromListTest(){
        List<VirtualPet> petList = underTest.getAllPets();
       underTest.feedAllPets(petList);
        assertEquals(1,petList.get(0).getHunger());
        assertEquals(1,petList.get(1).getHunger());
        assertEquals(1,petList.get(2).getHunger());
        underTest.feedAllPets(petList);
        assertEquals(-1,petList.get(0).getHunger());
        assertEquals(-1,petList.get(1).getHunger());
        assertEquals(-1,petList.get(2).getHunger());
    }
    @Test
    public void shouldPlayWithAllPetsFromListTest(){
        List<VirtualPet> petList = underTest.getAllPets();
        underTest.playTimeWithAllPets(petList);
        assertEquals(1,petList.get(0).getBoredom());
        assertEquals(1,petList.get(1).getBoredom());
        assertEquals(1,petList.get(2).getBoredom());
        underTest.playTimeWithAllPets(petList);
        assertEquals(-1,petList.get(0).getBoredom());
        assertEquals(-1,petList.get(1).getBoredom());
        assertEquals(-1,petList.get(2).getBoredom());
    }
    @Test
    public void shouldNapTimeForAllPetsFromListTest(){
        List<VirtualPet> petList = underTest.getAllPets();
        underTest.napTimeForAllPets(petList);
        assertEquals(1,petList.get(0).getSleepy());
        assertEquals(1,petList.get(1).getSleepy());
        assertEquals(1,petList.get(2).getSleepy());
        underTest.napTimeForAllPets(petList);
        assertEquals(-1,petList.get(0).getSleepy());
        assertEquals(-1,petList.get(1).getSleepy());
        assertEquals(-1,petList.get(2).getSleepy());
    }
    @Test
    public void shouldTickAllPetsFromListTest(){
        List<VirtualPet> petList = underTest.getAllPets();
        underTest.tickAllPets(petList);
        assertEquals(6,petList.get(0).getSleepy());
        assertEquals(6,petList.get(0).getBoredom());
        assertEquals(6,petList.get(0).getHunger());
        underTest.tickAllPets(petList);
        assertEquals(9,petList.get(0).getSleepy());
        assertEquals(9,petList.get(0).getBoredom());
        assertEquals(9,petList.get(0).getHunger());
    }
    @Test
    public void shouldFeedASingleFromListTest(){
      List<VirtualPet> petList = underTest.getAllPets();
      underTest.feedSinglePet(petList.get(0));
      assertEquals(1,petList.get(0).getHunger());
        underTest.feedSinglePet(petList.get(0));
        assertEquals(-1,petList.get(0).getHunger());
    }
    @Test
    public void shouldPlayWithSingleFromListTest(){
        List<VirtualPet> petList = underTest.getAllPets();
        underTest.playWithSinglePet(petList.get(0));
        assertEquals(1,petList.get(0).getBoredom());
        underTest.playWithSinglePet(petList.get(0));
        assertEquals(-1,petList.get(0).getBoredom());
    }
    @Test
    public void shouldBeNapTimeForSingleFromListTest(){
        List<VirtualPet> petList = underTest.getAllPets();
        underTest.singlePetNapTime(petList.get(0));
        assertEquals(1,petList.get(0).getSleepy());
        underTest.singlePetNapTime(petList.get(0));
        assertEquals(-1,petList.get(0).getSleepy());
    }
    @Test
    public void shouldTickSingleFromListTest(){
        List<VirtualPet> petList = underTest.getAllPets();
        underTest.tickSinglePet(petList.get(0));
        assertEquals(6,petList.get(0).getSleepy());
        assertEquals(6,petList.get(0).getBoredom());
        assertEquals(6,petList.get(0).getHunger());
        underTest.tickSinglePet(petList.get(0));
        assertEquals(9,petList.get(0).getSleepy());
        assertEquals(9,petList.get(0).getBoredom());
        assertEquals(9,petList.get(0).getHunger());

    }
}


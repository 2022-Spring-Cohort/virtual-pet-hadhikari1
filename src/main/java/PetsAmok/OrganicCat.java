package PetsAmok;

public class OrganicCat extends OrganicPets implements Clean{
    private int cleanLitterBox;
    public OrganicCat(String name, int health, int happiness, int hunger, int boredom, int waste, int cleanLitterBox) {
        super(name, health, happiness, hunger, boredom, waste);
        this.cleanLitterBox = cleanLitterBox;
    }

    public int getCleanLitterBox() {
        return cleanLitterBox;
    }


    @Override
    public int clean() {
        cleanLitterBox += 5;
        waste += 5;
        happiness += 5;
        health += 5;
        return cleanLitterBox;
    }

    @Override
    public String toString() {
        return "Organic Cat" + "[Name: " + name + "\tHealth: " + health + "\tHappiness: " +
                happiness + "\tHunger: " + hunger + "\tBoredom: " + boredom  + "\tWaste: " + waste +
                "\tLitter Box: " + cleanLitterBox + "]";
    }
}

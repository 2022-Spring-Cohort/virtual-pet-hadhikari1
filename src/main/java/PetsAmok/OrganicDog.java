package PetsAmok;

public class OrganicDog extends OrganicPets implements Walkable, Clean{
    protected int cageCleanliness;

    public OrganicDog(String name, int health, int happiness, int hunger, int boredom, int waste, int cageCleanliness) {
        super(name, health, happiness, hunger, boredom, waste);
        this.cageCleanliness = cageCleanliness;
    }

    public int getCageCleanliness() {
        return cageCleanliness;
    }

    public void tick(){
        cageCleanliness += 5;
        super.tick();
    }

    protected void cleanOrganicDogCage(){
        cageCleanliness -= 2;
    }

    @Override
    public void walkable() {
        cageCleanliness += 5;
        health += 5;
        happiness += 5;
        waste += 5;
    }
    @Override
    public boolean needs(){
        return getCageCleanliness() > 50 && super.needs();
    }

    @Override
    public int clean() {
        cageCleanliness +=5;
        waste += 5;
        happiness += 5;
        health += 5;
        return cageCleanliness;
    }

    @Override
    public String toString() {
        return "Organic Dog" + "[Name: " + name + "\tHealth: " + health + "\tHappiness: " + happiness + "\tHunger: "
                + hunger + "\tBoredom: " + boredom  + "\tWaste: " + waste + "\tCage: " + cageCleanliness +"]";
    }


}
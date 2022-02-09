package PetsAmok;

public class OrganicPets extends VirtualPets {
    protected int hunger;
    protected int boredom;
    protected int waste;

    public OrganicPets(String name, int health, int happiness, int hunger, int boredom, int waste) {
        super(name, health, happiness);
        this.hunger = hunger;
        this.boredom = boredom;
        this.waste = waste;
    }

    public int getHunger() {
        return hunger;
    }
    public int getBoredom() {
        return boredom;
    }
    public int getWaste() {
        return waste;
    }

    public void feedPet(){
        hunger += 5;
        happiness += 5;
        health += 5;
        waste -= 10;
    }

    public void bathroomBreak(){
        waste -= 5;
        happiness += 5;
        health += 5;
    }

    @Override
    public void playTime(){
        happiness += 5;
        health += 5;
        hunger -=5;
        boredom += 5;
        health += 5;
    }

    @Override
    public boolean needs(){
       return super.needs() && hunger < 50 && boredom < 50 && waste < 50 ;
    }

    @Override
    public void tick(){
        super.tick();
        hunger -= 5;
        boredom -= 5;
        waste -= 5;
    }
}

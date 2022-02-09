package PetsAmok;

public abstract class VirtualPets {
    protected String name;
    protected int health;
    protected int happiness;

    public VirtualPets(String name, int health, int happiness) {
        this.name = name;
        this.health = health;
        this.happiness = happiness;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getHappiness() {
        return happiness;
    }

    public abstract void playTime();

    public void tick(){
        happiness -= 5;
        health -= 5;
    }

    public boolean needs() {
//        System.out.println("Happiness: " + happiness + "\tHealth: " + health);
        return getHealth() < 50 && getHappiness() < 50;
    }


}

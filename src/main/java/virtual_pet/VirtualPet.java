package virtual_pet;

public class VirtualPet {
    private String name;
    private int hunger;
    private int boredom;
    private int sleepy;

    public VirtualPet(String name) {
        this.name = name;
        this.hunger = 3;
        this.boredom = 3;
        this.sleepy = 3;
    }

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getBoredom() {
        return boredom;
    }

    public int getSleepy() {
        return sleepy;
    }

    public void feedPet(){
        hunger = hunger - 1;
    }

    public void playTime(){
        boredom = boredom - 1;
    }

    public void napTime(){
        sleepy = sleepy - 1;
    }

    public void tick(){
        sleepy += 3;
        hunger += 3;
        boredom += 3;
    }

    public String getPetStatus() {
        System.out.println("Hunger: " + hunger + "\tSleepiness: " + sleepy + "\tBoredom: " + boredom);
        if (hunger >= 0 && hunger < 10 ) {
            System.out.println("Hunger: I am satisfied :)");
        }
        else if (hunger >= 10 && hunger < 20) {
            System.out.println("Hunger: I am hungry :(");
        }
        if (sleepy >= 0 && sleepy < 10) {
            System.out.println("Sleepy: I am well rested :)");
        }
        else if(sleepy >= 10 && sleepy < 20) {
            System.out.println("Sleepy: I am feeling sleepy :(");
        }
        if (boredom >= 0 && boredom < 10) {
            System.out.println("Boredom: I am enjoying myself :)");
        }
        else if(boredom >= 10 && boredom < 20) {
            System.out.println("Boredom: I am bored :(");
        }
        return "";
    }

}



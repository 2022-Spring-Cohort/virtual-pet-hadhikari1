package PetsAmok;

public class RoboticPets extends VirtualPets {
    protected int maintenance;
    protected int batteryLife;

    public RoboticPets(String name, int health, int happiness, int maintenance, int batteryLife) {
        super(name, health, happiness);
        this.maintenance = maintenance;
        this.batteryLife = batteryLife;
    }

    public int getMaintenance() {
        return maintenance;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void chargeBattery(){
        happiness += 5;
        health += 5;
        batteryLife += 5;
        maintenance += 5;
    }

    public void oilRoboticPet(){
        maintenance += 5;
        health += 5;
        happiness += 5;
        batteryLife -=5;
    }

    public boolean needs(){
        return maintenance < 50 && batteryLife < 50 && super.needs();
    }

    @Override
    public void tick(){
        super.tick();
        maintenance -= 5;
        batteryLife -= 5;
    }

    @Override
    public void playTime(){
        batteryLife -= 5;
        maintenance -= 5;
        happiness +=5;
        health -= 5;
    }
}

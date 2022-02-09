package PetsAmok;

public class RoboticCat extends RoboticPets{

    public RoboticCat(String name, int health, int happiness, int maintenance, int batteryLife) {
        super(name, health, happiness, maintenance, batteryLife);
    }

    @Override
    public String toString() {
        return "Robotic Cat" + "[Name: " + name + "\tHealth: " + health + "\tHappiness: " + happiness + "\tMaintenance: "
                + maintenance + "\tBattery Life: " + batteryLife + "]";
    }
}

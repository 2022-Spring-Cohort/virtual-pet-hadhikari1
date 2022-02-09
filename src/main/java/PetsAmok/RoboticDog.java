package PetsAmok;

public class RoboticDog extends RoboticPets implements Walkable{

    public RoboticDog(String name, int health, int happiness, int maintenance, int batteryLife) {
        super(name, health, happiness, maintenance, batteryLife);
    }


    @Override
    public void walkable() {
        maintenance -= 5;
        health -= 5 ;
        happiness += 5;
        batteryLife -= 5;
    }

    @Override
    public String toString() {
        return "Robotic Dog" + "[Name: " + name + "\tHealth: " + health + "\tHappiness: " + happiness + "\tMaintenance: "
                + maintenance + "\tBattery Life: " + batteryLife + "]";
    }
}

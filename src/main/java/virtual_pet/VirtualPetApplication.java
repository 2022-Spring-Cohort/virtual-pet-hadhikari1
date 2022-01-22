package virtual_pet;

import java.util.Scanner;

import java.util.Random;

public class VirtualPetApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Virtual Pet Game.");
        System.out.println("Please enter your pet's name");
        String petName = input.nextLine();

        VirtualPet pet = new VirtualPet(petName);
        System.out.println("Hi, my name is " + petName + ".");

        Random rand = new Random();

        int chosenNumber;

        do{
            System.out.println("Choose a number to play" + "\n Press 0 to Quit." + "\n Press 1 to Feed "
                    + petName + "." + "\n Press 2 to Play with " + petName + "." +"\n Press 3 to Let "+ petName
                    + " Sleep." + "\n Press 4 to Change Time.");

            chosenNumber = input.nextInt();
            if(chosenNumber == 0){
                System.out.println("Bye, See you next time.");
                break;
            }
            else if(chosenNumber == 1){
                pet.feedPet();
                System.out.println(pet.getPetStatus());
            }
            else if(chosenNumber == 2){
                pet.playTime();
                System.out.println(pet.getPetStatus());
            }
            else if(chosenNumber == 3){
                pet.napTime();
                System.out.println(pet.getPetStatus());
            }
            else if(chosenNumber == 4){
                pet.tick();
                System.out.println(pet.getPetStatus());
            }

            if (pet.getHunger() >= 20) {
                System.out.println("Sorry your pet died of hunger.");
                break;
            }
            else if (pet.getHunger() <= 0) {
                System.out.println("Sorry your pet died due to overfeeding.");
                break;
            }
            if (pet.getSleepy() >= 20) {
                System.out.println("Sorry your pet died due to lack of sleep.");
                break;
            }
            else if (pet.getSleepy() <= 0) {
                System.out.println("Sorry your pet died due to over resting.");
                break;
            }
            if (pet.getBoredom() >= 20) {
                System.out.println("Sorry your pet died of boredom.");
                break;
            }
            else if (pet.getBoredom() <= 0) {
                System.out.println("Sorry your pet died due to too much play time.");
                break;
            }
        }
        while(chosenNumber !=0);
    }
}


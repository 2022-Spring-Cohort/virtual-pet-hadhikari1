package PetsAmok;

import java.sql.SQLOutput;
import java.util.Scanner;

public class VirtualPetApplication {
    public static void main(String[] args) {


        VirtualPetShelter shelter = new VirtualPetShelter();

        VirtualPets organicCat1 = new OrganicCat("daisy",100,100,100,100,
                100,100);
        VirtualPets organicCat2 = new OrganicCat("simba",100,100,100,100,
                100,100);
        VirtualPets organicDog1 = new OrganicDog("luna",100,100,100,100,
                100,100);
        VirtualPets organicDog2 = new OrganicDog("sadie",100,100,100,100,
                100,100);
        VirtualPets roboticCat1 = new RoboticCat("milo",100,100,100,100);
        VirtualPets roboticCat2 = new RoboticCat("shadow",100,100,100,100);
        VirtualPets roboticDog1 = new RoboticDog("bear",100,100,100,100);
        VirtualPets roboticDog2 = new RoboticDog("buddy",100,100,100,100);


        shelter.allPetsInShelter.put(organicCat1.getName().toLowerCase(), organicCat1);
        shelter.allPetsInShelter.put(organicCat2.getName().toLowerCase(), organicCat2);
        shelter.allPetsInShelter.put(organicDog1.getName().toLowerCase(), organicDog1);
        shelter.allPetsInShelter.put(organicDog2.getName().toLowerCase(), organicDog2);
        shelter.allPetsInShelter.put(roboticCat1.getName().toLowerCase(), roboticCat1);
        shelter.allPetsInShelter.put(roboticCat2.getName().toLowerCase(), roboticCat2);
        shelter.allPetsInShelter.put(roboticDog1.getName().toLowerCase(), roboticDog1);
        shelter.allPetsInShelter.put(roboticDog2.getName().toLowerCase(), roboticDog2);

        System.out.println("Welcome to Virtual Pet 3.0. \n THESE ARE THE PETS IN THE SHELTER: ");
        shelter.allPetsStatus();

        do{
            int userInput = getUserSelection();
            changesToPetStatus(userInput, shelter);

        }while(!shelter.areNeedsForAnyPetsHigh());



    }

    public static int getUserSelection(){
        System.out.println("Choose a number to play" + "\n[0] to Quit Game." +
                "\n[1] Charge Battery of All Robotic Pets" + "\n[2] Oil All Robotic Pets" +
                "\n[3] Walk Your All Dogs in Shelter" + "\n[4] Play With a Pet in Shelter" +
                "\n[5] Feed All Organic Pets" + "\n[6] Provide Bathroom Breaks TO Organic Pets" +
                 "\n[7] CLean Organic Dog Cages" + "\n[8] Clean Organic Cats Litter Box" +
                "\n[9] Admit a new pet " + "\n[10] Give a Pet For Adoption" + "\n[11] Play with all Pets");

        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();
        return userInput;
    }

    public static void changesToPetStatus(int userInput,VirtualPetShelter shelter){
        if(userInput == 0){
            System.out.println("Bye, see you next time.");
            System.exit(0);
        }
        if(userInput == 1){
            shelter.chargeAllPets();
            shelter.allRoboticPetStatus();
            shelter.tickRoboticPets();
            System.out.println("You charged all Robotic Pets.");
        }
        if(userInput == 2){
            shelter.oilAllRoboticPets();
            shelter.allRoboticPetStatus();
            shelter.tickRoboticPets();
            System.out.println("You oiled all Robotic Pets");
        }
        if(userInput == 3){
            shelter.walkAllDogs();
            shelter.allDogsStatus();
            shelter.tickAllPets();
            System.out.println("You Walked all dogs in Shelter.");

        }
        if(userInput == 4){
            System.out.println("Choose a Pet to Play With");
            String choosePetToPlay = userChosenPet(shelter);
            shelter.playWithSinglePet(choosePetToPlay);
            shelter.tickASinglePet(choosePetToPlay);
            VirtualPets pet = shelter.getPetsByName(choosePetToPlay);
            System.out.println(pet.toString());
            System.out.println("You are playing with " + choosePetToPlay);

        }
        if(userInput == 5){
            shelter.feedAllOrganicPets();
            shelter.tickOrganicPets();
            shelter.allOrganicPetStatus();
            System.out.println("You fed all Organic Pets");
        }
        if (userInput == 6){
            shelter.bathroomBreakOrganicPets();
            shelter.allOrganicPetStatus();
            shelter.tickOrganicPets();
            System.out.println("You provided Bathroom breaks to all Organic pets ");
        }
        if(userInput == 7){
            shelter.cleanCagesForOrganicDogs();
            shelter.organicDogsStatus();
            shelter.tickOrganicPets();
            System.out.println("You cleaned all Organic Dog cages");
        }
        if(userInput == 8){
            shelter.cleanCagesForOrganicDogs();
            shelter.organicCatsStatus();
            shelter.tickOrganicPets();
            System.out.println("You cleaned all Organic Cats Litter box");
        }
        if(userInput == 9){
            shelter.addPetsToShelter(petThatNeedShelter());
            shelter.tickAllPets();
            System.out.println("Congrats! You added a pet into the Shelter.");
            System.out.println(shelter.getListOfAllPetsNames());
        }
        if(userInput == 10){
            System.out.println("Which pet would you like to give for adoption?");
            String userChosen = userChosenPet(shelter);
            shelter.adoption(userChosen);
            System.out.println(shelter.getListOfAllPetsNames());
            System.out.println("Good job!");
        }
        if(userInput == 11){
            shelter.playWithAllPets();
            shelter.tickAllPets();
            shelter.allPetsStatus();
            System.out.println("You are playing with all pets");
        }
    }

    public static String userChosenPet( VirtualPetShelter shelter){
        System.out.println(shelter.getListOfAllPetsNames());
        Scanner userChosen = new Scanner(System.in);
        return userChosen.nextLine();
    }

    public static VirtualPets petThatNeedShelter(){
        System.out.println("What would you like to name the pet you're admitting?");
        Scanner userChosen = new Scanner(System.in);
        String nameOfPetBeingAdmitted = userChosen.nextLine();
        System.out.println("Choose Your pet's Type: " + "\n[1] Robotic Dog" + "\n[2] Robotic Cat" +"\n[3] Organic Cat" +
                "\n[4] Organic Dog");
        int petType = userChosen.nextInt();
        while(petType < 1 || petType > 4){
            System.out.println("Choose Your pet's Type: " + "\n[1] Robotic Dog" + "\n[2] Robotic Cat" +"\n[3] Organic Cat" +
                    "\n[4] Organic Dog");
            petType = userChosen.nextInt();
        }
        VirtualPets newPet = null;
        if(petType == 1){
            newPet = new RoboticDog(nameOfPetBeingAdmitted,100,100,100,100);
        }
        if(petType == 2){
            newPet = new RoboticCat(nameOfPetBeingAdmitted, 100,100,100,100);
        }
        if(petType == 3){
            newPet = new OrganicCat(nameOfPetBeingAdmitted,100,100,100,100,100,
                    100);
        }
        if(petType ==4 ){
            newPet = new OrganicDog(nameOfPetBeingAdmitted,100,100,100,100,100,
                    100);
        }
        return newPet;
    }
}

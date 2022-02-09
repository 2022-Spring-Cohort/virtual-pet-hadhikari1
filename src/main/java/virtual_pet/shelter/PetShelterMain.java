package virtual_pet.shelter;

import virtual_pet.VirtualPet;
import virtual_pet.shelter.Shelter;;
import java.util.List;
import java.util.Scanner;

public class PetShelterMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to play with a single pet or all pets? Please type Yes or No"
                + "\n [Yes] All Pets" + "\n [No] Single pet");
        String initialQuestion = input.nextLine();
        while (!initialQuestion.toLowerCase().equals("yes") && !initialQuestion.toLowerCase().equals("no")) {
            System.out.println("Would you like to play with a single pet or all pets? Please type Yes or No"
                    + "\n [Yes] All Pets" + "\n [No] Single pet");
            initialQuestion = input.nextLine();
        }

        int userInput;

        Shelter petShelter = new Shelter();
        VirtualPet rex = new VirtualPet("Rex");
        VirtualPet spot = new VirtualPet("Spot");
        VirtualPet whiskers = new VirtualPet("Whiskers");

        petShelter.addPet(rex);
        petShelter.addPet(spot);
        petShelter.addPet(whiskers);

        if (initialQuestion.toLowerCase().equals("yes")) {
            System.out.println("Pet in The Shelter are: Rex\t Spot\t Whiskers.");
            playingWithAllPetsInShelter(input,petShelter);

        }
        else {
            System.out.println("Welcome to the Game");
            System.out.println("To start the game, choose a pet press the number associated with  pet.");

            userInput = petListAndUserInput(input);

            VirtualPet userChosenPet = assignPetToUser(userInput, rex, spot, whiskers);

            boolean isAdopted = false;
            do {
                if (!isAdopted) {
                    System.out.println("Choose a number to play" + "\n Press [0] to Quit." +
                            "\n Press [1] to Adopt your pet" + "\n Press [2] to Return Your Pet" +
                            "\n Press [3] to Feed Your Pet" + "\n Press [4] to Play With Your Pet" +
                            "\n Press [5] to Let Your Pet Nap");
                }
                else {
                    System.out.println("Choose a number to play" + "\n Press [0] to Quit." +
                            "\n Press [2] to Return Your Pet" + "\n Press [3] to Feed Your Pet" +
                            "\n Press [4] to Play With Your Pet" + "\n Press [5] to Let Your Pet Nap");
                }
                userInput = input.nextInt();
                if (userInput == 0) {
                    System.out.println("Bye, See you next time.");
                    break;
                }
                else if (userInput == 1) {
                    isAdopted = true;
                    petShelter.adoptAPet(userChosenPet);
                    System.out.println("Thank you for Adopting " + userChosenPet.getName());
                    petShelter.getSinglePetStatus(userChosenPet);
                }
                else if (userInput == 2) {
                    isAdopted = false;
                    petShelter.addPet(userChosenPet);
                    System.out.println("Thank you for Returning " + userChosenPet.getName());
                    userInput = petListAndUserInput(input);
                    userChosenPet = assignPetToUser(userInput, rex, spot, whiskers);
                }
                else if (userInput == 3) {
                    petShelter.feedSinglePet(userChosenPet);
                    petShelter.getSinglePetStatus(userChosenPet);
                    userInput = petDeathReason(userChosenPet, userInput);
                }
                else if (userInput == 4) {
                    petShelter.playWithSinglePet(userChosenPet);
                    petShelter.getSinglePetStatus(userChosenPet);
                    userInput = petDeathReason(userChosenPet, userInput);
                }
                else if (userInput == 5) {
                    petShelter.singlePetNapTime(userChosenPet);
                    petShelter.getSinglePetStatus(userChosenPet);
                    userInput = petDeathReason(userChosenPet, userInput);
                }
                if (userInput > 2 && userInput < 6) {
                    petShelter.tickSinglePet(userChosenPet);
                }
                System.out.println("");
            } while (userInput != 0);
        }
    }

    public static VirtualPet assignPetToUser(int userInput, VirtualPet rex, VirtualPet spot, VirtualPet whiskers) {
        VirtualPet userChosenPet = null;
        if (userInput == 6) {
            userChosenPet = rex;
            System.out.println("You choose " + rex.getName());
        }
        else if (userInput == 7) {
            userChosenPet = spot;
            System.out.println("You choose " + spot.getName());
        }
        else if (userInput == 8) {
            userChosenPet = whiskers;
            System.out.println("You choose " + whiskers.getName());
        }
        return userChosenPet;
    }

    public static int petListAndUserInput(Scanner input) {
        System.out.println("Pet are: [6] Rex\t[7] Spot\t[8] Whiskers");
        int userInput = input.nextInt();
        return userInput;
    }

    public static int petDeathReason(VirtualPet pet, int userInput) {
        if (pet.getHunger() >= 20) {
            System.out.println("Sorry " + pet.getName()+ " died of hunger.");
            return 0;
        }
        else if (pet.getHunger() <= 0) {
            System.out.println("Sorry " + pet.getName()+ " died due to lack of sleep.");
            return 0;
        }
        if (pet.getSleepy() >= 20) {
            System.out.println("Sorry " + pet.getName()+ " died due to lack of sleep.");
            return 0;
        }
        else if (pet.getSleepy() <= 0) {
            System.out.println("Sorry " + pet.getName()+ " died due to over resting.");
            return 0;
        }
        if (pet.getBoredom() >= 20) {
            System.out.println("Sorry " + pet.getName()+ " died of boredom.");
            return 0;
        }
        else if (pet.getBoredom() <= 0) {
            System.out.println("Sorry " + pet.getName()+ " died due to too much play time.");
            return 0;
        }
        return userInput;
    }

    public static void playingWithAllPetsInShelter(Scanner input, Shelter petShelter){
        List<VirtualPet> allPets = petShelter.getAllPets();
        int userInput;
        do {
            System.out.println("You Have Selected to Play With All Pets");
            System.out.println("Choose a number to play" + "\n Press [0] to Quit." +
                    "\n Press [3] to Feed Your Pet" + "\n Press [4] to Play With Your Pet" +
                    "\n Press [5] to Let Your Pet Nap");
                userInput= input.nextInt();

            if (userInput == 0) {
                System.out.println("Bye, See you next time.");
                break;
            }
            else if(userInput == 3) {
                petShelter.feedAllPets(allPets);
                petShelter.getAllPetsStatus(allPets);
                userInput = deathReasonOfAllPets(allPets, userInput);
            }
            else if (userInput == 4) {
                petShelter.playTimeWithAllPets(allPets);
                petShelter.getAllPetsStatus(allPets);
                userInput = deathReasonOfAllPets(allPets, userInput);
            }
            else if (userInput == 5) {
                petShelter.napTimeForAllPets(allPets);
                petShelter.getAllPetsStatus(allPets);
                userInput = deathReasonOfAllPets(allPets, userInput);
            }
            if (userInput > 2 && userInput < 6) {
                petShelter.tickAllPets(allPets);
            }
            System.out.println("");
        } while (userInput != 0);
    }

    public static int deathReasonOfAllPets(List<VirtualPet> petList, int userInput) {
        int temp = userInput;
       for(VirtualPet pet : petList) {
           if (pet.getHunger() >= 20) {
               System.out.println("Sorry " + pet.getName()+ " died of hunger.");
               temp = 0;
           }
           else if (pet.getHunger() <= 0) {
               System.out.println("Sorry " + pet.getName()+ " died due to lack of sleep.");
               temp = 0;
           }
           if (pet.getSleepy() >= 20) {
               System.out.println("Sorry " + pet.getName()+ " died due to lack of sleep.");
               temp = 0;
           }
           else if (pet.getSleepy() <= 0) {
               System.out.println("Sorry " + pet.getName()+ " died due to over resting.");
               temp = 0;
           }
           if (pet.getBoredom() >= 20) {
               System.out.println("Sorry " + pet.getName()+ " died of boredom.");
               temp = 0;
           }
           else if (pet.getBoredom() <= 0) {
               System.out.println("Sorry " + pet.getName()+ " died due to too much play time.");
               temp = 0;
           }
       }
       return temp;
    }
}



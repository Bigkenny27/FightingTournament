package FighterGame;

import java.util.Random;
import java.util.Scanner;



public final class Helper {
    private static Random random = new Random();
    private static Scanner scan = new Scanner(System.in);


    private Helper() {

    }

    // ------------- Scanner ---------------
    public static void endScanner() {
        scan.close();
    }

    public static String scanNextLine() {
        return scan.nextLine().trim();
    }
   

    // -------------- Print -----------------
    public static void printFighterStats(Fighter fighter) {
        System.out.println(fighter.getName() + " HP: " + fighter.getCurrHP());
    }

    public static void printBar() {
        for (int i = 0; i < 2; i++) {
            System.out.print("-----------------");
        }
        System.out.println("-----------------");
    }



    // ---------------- Random ------------------

    /*
     *  This function will generate a random number INCLUSIVE of the lower and upper bound
     */
    public static int generateRandomNumber(int lowerBound, int upperBound) {
        if (upperBound < lowerBound) {
            throw new IllegalArgumentException("Lower bound input is larger than the upper bound. Lower bound: " + lowerBound + " Upper bound: " + upperBound);
        }
        int range = upperBound - lowerBound;
        int randomNumber = random.nextInt(range);
        
        return randomNumber + lowerBound;
    }

    /*
     * This function takes in the base value, the maximum increase percentage and maximum decrease percentage
     */
    public static int randomiseModifer(int baseValue, int maxDecrease, int maxIncrease) {
       float modifier = generateRandomNumber(maxDecrease, maxIncrease);
       float percentModifier = modifier/100;
       int output = (int) (baseValue * percentModifier);
       return output;        
    }


}

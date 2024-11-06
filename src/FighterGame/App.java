package FighterGame;

import java.util.Scanner;

public class App {

    public static void initaliseGameSettings() {
        // you can turn this into a function
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want (A)utomatic or (M)anual");
        while (true) {
            String test = scan.next();
    
            if (test.equals("A")) {
                Game.autoPlay = true;
                break;
            } else if (test.equals("M")) {
                Game.autoPlay = false;
                break;
            } else {
                System.out.println("invalid input, Please use type A for Automatic and M for manual.");
            }
        }
        scan.close();
    
        // Start gameLoader
        GameLoader.start();
    }

    
    






    public static void main(String[] args) throws Exception {
        initaliseGameSettings();
    }



}

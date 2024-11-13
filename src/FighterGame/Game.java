package FighterGame;

import java.util.ArrayList;


public class Game {
    
    static ArrayList<Fighter> fighters = new ArrayList<Fighter>();



    static boolean autoPlay = false;
    static boolean pauseManual = false;


    static boolean gameRunning = true;
    static int tick;





    public static void fighterPrintStatus() {
        for (int i  = 0; i < fighters.size(); i++) {
            Helper.printFighterStats(fighters.get(i));
        }
    }


    public static void fighterDeath(Fighter fighter) {
        System.out.println(fighter.getName() + " has died");
        fighters.remove(fighter);

        checkGameOver();
    }

    private static void checkGameOver() {
        if (fighters.size() == 1) {
            gameOver();
        }
    }

    public static void gameOver() {
        System.out.println(fighters.get(0).getName() + " Wins!");
        Game.gameRunning = false;
    }

    private static void manualUserInput() {

        String userInput = " ";
        
        while (true) {


            userInput = Helper.scanNextLine();

            if (userInput.equals("n")) {
                Helper.printBar();
                break;
            } else if (userInput.equals("A")) {
                autoPlay = true;
                Helper.printBar();
                break;
            }

            System.out.println("Invalid input");
            System.out.println("Input 'n' to continue or input 'A' to swtich to automatic");
        }
     
    }


    private static void gameLoop() {
        fighterPrintStatus();

        // TODO: make one where it takes 3 seconds between each input

        while (gameRunning) {
            
            if (!autoPlay && pauseManual) {manualUserInput(); pauseManual = false;}

            for (int i  = 0; i < fighters.size(); i++) {
                Fighter currentFighter = fighters.get(i);
                currentFighter.loop(tick);
            }
            tick++;
        }

        endGame();
    }

    


    public static void startGame() {
        gameRunning = true;
        fighters = GameLoader.getFighters();
        gameLoop();
    }

    private static void endGame() {
        System.out.println("Game Completed.");
        Helper.endScanner();
    }



    public static int getTick() {return tick;}

    public static void setPauseManual() {
        pauseManual = true;
    }

}

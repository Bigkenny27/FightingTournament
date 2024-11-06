package FighterGame;

import java.util.ArrayList;


public class Game {
    
    static ArrayList<Fighter> fighters = new ArrayList<Fighter>();



    static boolean autoPlay = false;


    static boolean gameRunning = true;
    static int tick;





    public static void fighterPrintStatus() {
        for (int i  = 0; i < fighters.size(); i++) {
            Helper.printHP(fighters.get(i));
        }
    }


    public static void fighterDeath(Fighter fighter) {
        System.out.println(fighter.getName() + " has died");
        fighters.remove(fighter);
    }


    public static void gameOver() {
        System.out.println(fighters.get(0).getName() + " Wins!");
        Game.gameRunning = false;
    }



    private static void GameLoop() {
        fighterPrintStatus();
        while (gameRunning) {
            for (int i  = 0; i < fighters.size(); i++) {
                Fighter currentFighter = fighters.get(i);
                currentFighter.loop(tick);
            }
            tick++;
        }
        System.out.println("Game Completed.");
    }



    public static void startGame() {
        gameRunning = true;
        fighters = GameLoader.getFighters();
        GameLoop();
    }



}

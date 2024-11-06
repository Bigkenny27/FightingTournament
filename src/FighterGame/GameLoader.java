package FighterGame;

import java.util.ArrayList;
import java.util.Scanner;

public class GameLoader {
    // This class will load the fighters and config

    static ArrayList<Fighter> fighters = new ArrayList<Fighter>();
    

    public static void addFighter(Fighter fighter) {
        fighters.add(fighter);
    }



    public static void initaliseFight() {
        

        int[] fighterStats1 = {17, 20, 44, 20, 10};
        int[] fighterStats2 = {26, 20, 34, 20, 35};

        Fighter jerry = new Fighter("Jerry", fighterStats1);
        Fighter bob = new Fighter("Bob", fighterStats2);

        jerry.setOpponent(bob);
        bob.setOpponent(jerry);

        addFighter(jerry);
        addFighter(bob);


        // TODO: Change this when configs are added.
        Game.startGame();
        
    }
    public static void start() {
        initaliseFight();
    }
    
    public static ArrayList<Fighter> getFighters() {return fighters;}

}

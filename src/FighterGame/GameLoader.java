package FighterGame;

import java.util.ArrayList;


public class GameLoader {
    // This class will load the fighters and config

    static ArrayList<Fighter> fighters = new ArrayList<Fighter>();

    public static void addFighter(Fighter fighter) {
        fighters.add(fighter);
    }


    /*
     * Stats go:
     * Str (Damage)
     * Dex (Energy) - To be implemented
     * Con (Health)
     * Eva (Dodge)
     * Spd (Speed)
     */
    public static void initaliseFight() {

        int[] fighterStats1 = {15, 52, 12, 23, 26};
        int[] fighterStats2 = {16, 12, 23, 28, 23};

        Fighter jerry = new Fighter("Jerry", fighterStats1);
        Fighter bob = new Fighter("Bob", fighterStats2);

        jerry.setOpponent(bob);
        bob.setOpponent(jerry);

        addFighter(jerry);
        addFighter(bob);


        
        
        
    }
    public static void start() {
        initaliseFight();
        // TODO: Change this when configs are added.
        Game.startGame();
    }
    
    public static ArrayList<Fighter> getFighters() {return fighters;}

}

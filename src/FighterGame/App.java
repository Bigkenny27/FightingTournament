package FighterGame;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    static ArrayList<Fighter> fighters = new ArrayList<Fighter>();

    static Random random = new Random();


    static boolean gameRunning = true;
    static int tick;


    public static void addFighter(Fighter fighter) {
        fighters.add(fighter);
    }

    public static void initaliseGame() {
        // TODO: make a auto mode and a step by step mode
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want (A)utomatic or (M)anual");

        String test = scan.nextLine();
        
    }

    public static void initaliseFight() {
        gameRunning = true;

        int[] fighterStats1 = {17, 20, 44, 20, 10};
        int[] fighterStats2 = {26, 20, 34, 20, 35};

        Fighter jerry = new Fighter("Jerry", fighterStats1);
        Fighter bob = new Fighter("Bob", fighterStats2);

        jerry.setOpponent(bob);
        bob.setOpponent(jerry);

        addFighter(jerry);
        addFighter(bob);

        GameLoop();
    }
    
    


    public static void GameLoop() {
        while (gameRunning) {
            for (int i  = 0; i < fighters.size(); i++) {
                Fighter currentFighter = fighters.get(i);
                currentFighter.loop(tick);

            }


            tick++;
        }

        System.out.println("Game Completed.");
    }



    public static void main(String[] args) throws Exception {
        initaliseGame();
    }



}

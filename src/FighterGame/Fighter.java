package FighterGame;

public class Fighter {
    private String name;

    private int maxHP;
    private int currHP;
    
    private int Str; // Damage
    private int Dex; // Energy
    private int Con; // Health
    private int Eva; // Dodge Chance
    private int Spd; // Speed

    private Fighter opponent;

    private Boolean isDead = false;


    public Fighter(String name, int[] statline) {
        initaliseStats(statline);
        initaliseHP();
        this.name = name;
    }

    private void initaliseStats(int[] statline) {
        if (statline.length != 5) return;

        Str = statline[0];
        Dex = statline[1];
        Con = statline[2];
        Eva = statline[3];
        Spd = statline[4];
    }


    private void initaliseHP() {
        
        int preModifiedHP = 200 + Con * 4;
        maxHP = Helper.randomiseModifer(preModifiedHP, 75, 125);
        currHP = maxHP;
    }


    private void attackEnemy(Fighter enemyFighter) {
        // TODO: make random choice of attacks
        punch(enemyFighter); // temp
    }

    // temp function
    private void punch(Fighter enemyFighter) {
        int damageOutput = 20 + 2 * Str;
        int accuracy = 95;
        // under could become a function
        int modifiedDamage =  Helper.randomiseModifer(damageOutput, 50, 125);
        
        enemyFighter.recieveAttack(modifiedDamage, accuracy);
    }

    private void checkDeath() {
        if (currHP <= 0) {
            deathProcedure();
        }
    }

    private void deathProcedure() {
        isDead = true; 
        Game.fighterDeath(this);
    }

    private void takeDamage(int damage) {
        currHP -= damage;
        System.out.println("Tick " + Game.getTick() + ": "+ name + " is damaged for " + damage + " damage!");
        checkDeath();   

        if (isDead) return;
        
        Helper.printFighterStats(this);
    }
    
    

    /*
     * Called when attack is recieved. Does the accuracy check then all of the effects of attack
     * TODO: potentially input could be an array for the deets of attack
     */
    public void recieveAttack(int damage, int accuracy) {

        if (attackHits(accuracy)) {
            takeDamage(damage);
        } else {
            System.out.println(name + " dodges " + opponent.getName() + "'s attack!");
        }
        
        Helper.printBar();

        // if the game is on the Manual setting, then cause the game to pause and wait for manual input
        Game.setPauseManual();
    }

    /*
     * Dodge Check - Checks if the attack hits or misses
     */
    private boolean attackHits(int accuracy) {
        // check if it hits
        int attackMissChance = 100 - accuracy;
        int modifiedMissChance = (int) Math.floor(attackMissChance * (Eva/100 + 1));
        // dice roll
        int randomNumber = Helper.generateRandomNumber(0,100);

        // debugPrintDodgeNumbers(randomNumber, modifiedMissChance);

        // Miss check
        if (randomNumber > modifiedMissChance) return true; else return false;
    }

    // ------------- CHECKS ---------------
    private Boolean checkReadyForAttack(int tick) {
        int attackDelay = 100 - Spd;

        if (tick % attackDelay == 0) return true;
        return false;
    }

    // -------------- SETS -----------------


    public void setOpponent(Fighter opponent) {
        this.opponent = opponent;
    }

    // -------------- GETS -----------------
    public String getName() {return name;}
    public int getCurrHP() {return currHP;}
    


    // -------------- LOOP -----------------
    public void loop(int tick) {
        if (checkReadyForAttack(tick)) {
            attackEnemy(opponent);
        }
    }


    // Debugging
    private void debugPrintDodgeNumbers(int randomNumber, int modifiedMissChance) {
        System.out.println("Attack random Number: " + randomNumber);
        System.out.println("Modified Miss Chance: " + modifiedMissChance);
    }


}

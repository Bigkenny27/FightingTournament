package FighterGame;

public class Fighter {
    private String name;

    private int maxHP;
    private int currHP;
    
    private int Str;
    private int Dex;
    private int Con;
    private int Eva;
    private int Spd;

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



    private void takeDamage(int damage) {
        currHP -= damage;
        System.out.println(name + " is damaged for " + damage + " damage!");

        Helper.printHP(this);

        checkDeath();   
    }

      // boolean incase revive spell or something
    private void checkDeath() {
        if (currHP <= 0) 
        isDead = true; dead();

    }

    private Boolean checkReadyForAttack(int tick) {
        int attackDelay = 100 - Spd;

        if (tick % attackDelay == 0) return true;
        return false;
    }

    // checks and does death mechanic
    private void dead() {
        Game.fighterDeath(this);
    }

    public void recieveAttack(int damage, int accuracy) {
        // check if it hits
        int attackMissChance = 100 - accuracy;
        
        int modifiedMissChance = (int) Math.floor(attackMissChance * (Eva/100 + 1));

        // dice roll
        int randomNumber = Helper.generateRandomNumber(0,100);
        if (randomNumber > modifiedMissChance) {
            // take damage
            takeDamage(damage);
        } else {
            System.out.println(name + " dodges " + opponent.getName() + "'s attack!");
        }
        
        
    }

    public void setOpponent(Fighter opponent) {
        this.opponent = opponent;
    }


    public String getName() {return name;}
    public int getCurrHP() {return currHP;}
    

    public void loop(int tick) {
        if (checkReadyForAttack(tick)) {
            attackEnemy(opponent);
        }
    }





}

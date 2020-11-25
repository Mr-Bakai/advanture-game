import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        // System objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();


        // Game variables
        String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
        int maxEnemiesHealth = 75;
        int enemyAttackDamage = 25;


        // Player variable

        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; //Percentage

        boolean running = true;

        System.out.println("Welcome to Bishkek!!!");

        GAME: // this is label
        while (running) {
            System.out.println("-------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemiesHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n");

            while (enemyHealth > 0) {       // if enemyHealth is less then 0 then while loop will stop
                System.out.println("\t YOUR HP: " + health);
                System.out.println("\t" + enemy + "s HP:" + enemyHealth);
                System.out.println("\n\t What would you like to do ? ");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");


                String input = in.nextLine();
                if (input.equals("1")){
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    //enemyHealth = enemyHealth - damageDealt;
                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " Damage");
                    System.out.println("\t> You recieve " + damageTaken + " in retaliation ");

                    if (health < 1) {
                        System.out.println("You have taken too much damage, Go drink some potion or Run Vasya! Run!");
                        break; // this break throws you out of a current while loop
                    }

                } else if (input.equals("2")) {
                    if (numHealthPotions > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You drink health potion healing yourself for " + healthPotionHealAmount + "" +
                                "\n\t> You now have " + health + "HP. " +
                                "\n\t> You have" + numHealthPotions + " health potions left.\n");
                    } else {
                        System.out.println("\t> You have no health potions left! Defeat enemies for a chance drop");
                    }
                } else if (input.equals("3")) {
                    System.out.println("\t> You run away from the " + enemy + "!");
                    continue GAME; // it throws you to label GAME
                } else {
                    System.out.println("\t Invalid command!");
                }
            }
            if(health < 1){
                System.out.println("You limp out of the Bishkek, weak from battle!");
                break; // this break throws you out of a while loop labeled GAME
            }

            System.out.println("-------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println(" # You have " + health + " HP: left. #");
            if(rand.nextInt(100) < 50){
                numHealthPotions++;
                System.out.println(" # The" + enemy + " dropped a health potion! # " );
                System.out.println(" # You now have " + numHealthPotions + " health potion. # ");
            }

            System.out.println("-------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit Bishkek");

            String input = in.nextLine();
            while(!input.equals("1") && !input.equals("2")){ // i will be looping while !input is not equals to 1 or 2
                System.out.println("Invalid command");
                input = in.nextLine();
            }

            if(input.equals("1")){
                System.out.println("You continue on your Adventure");
            }else if (input.equals("2")){
                System.out.println("You exit the Bishkek, successful from your adventure");
                break; // this break throws you out of a while loop labeled GAME
            }
        }
        System.out.println("############################");
        System.out.println("THANKS FOR PLAYING");
        System.out.println("############################");
    }
}

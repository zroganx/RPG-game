import java.util.*;
public class Scenario
{
  private boolean escape;
  private boolean blocking;
  private boolean enemyEscape;
  private boolean enemyBlocking;
  private int enemyHealth;
  private int enemyAtt;
  private String answer;
  private String area;
  public Scenario(String a, Weapon first, Character f)
  {
    area = a;
    if(area.equals("dungeon"))
    {
      System.out.println("You enter the dungeon.");
      searchDungeon(first, f);
    }
  }
  public void searchDungeon(Weapon first, Character f)
  {
     Scanner dungeon = new Scanner(System.in);
     f.falseGaveAnswer();
     System.out.println("Health: " + f.getPlayerHealth());
     System.out.println("Gold: " + f.getPlayerGold());
     while(f.getGaveAnswer() == false)
     {
      System.out.println("\nYou look around the dungeon what do you look for?\ntreasure, battle, secrets");
      answer = dungeon.next().toLowerCase();
      switch(answer)
      {
        case "treasure":
        f.trueGaveAnswer();
        treasure(first, f);
        break;
        case "battle":
        f.trueGaveAnswer();
        battle(first, f);
        break;
        case "secrets":
        f.trueGaveAnswer();
        break;
        default:
        f.falseGaveAnswer();
        System.out.println("Command not recognized.");
        break;
      }
     }
  }
  public void treasure(Weapon first, Character f)
  {
    int treasureA = (int)(Math.random() * 4) + 1; 
    System.out.println("\nYou go seraching for treasure around the dungeon.");
    switch(treasureA)
    {
      case(1): //basic chest
      int goldGained = (int)(Math.random() * 20) + 1;
      System.out.println("You discover a chest!\nIt contains " + goldGained + " gold pieces.");
      f.addPlayerGold(goldGained);
      break;
      case(2): //trap
      int trapDamage = (int)(Math.random() * (f.getMaxPlayerHealth() / 2 + 1) + (f.getMaxPlayerHealth() / 6));
      System.out.println("You trigger a trap!\nYou take " + trapDamage + " damage!");
      f.removePlayerHealth(trapDamage);  
      break;
      case(3): //speed check chest
      int speedCheck = (int)(Math.random() * 50) + 1;
      System.out.println("You discover a treasure trove!\nYou'll have to be fast to avoid the traps!");
      if(first.getSpeed() >= speedCheck)
      {
        int spGoldGained = (int)(Math.random() * 21) + 20;
        System.out.println("You easily weave through the traps to the treasure.\nYou gain " + spGoldGained + " gold pieces!");
        f.addPlayerGold(spGoldGained);
      }
      else
      System.out.println("You don't think you can get past the traps.\nYou decide to turn back.");
      break;
      case(4): //strength check chest
      int strengthCheck = (int)(Math.random() * 40) + 1;
      System.out.println("You discover a treasure trove!\nYou'll have to be strong to get through the traps!");
      if(first.getStrength() >= strengthCheck)
      {
        int stGoldGained = (int)(Math.random() * 21) + 20;
        System.out.println("You easily force your way through the traps.\nYou gain " + stGoldGained + " gold pieces!");
        f.addPlayerGold(stGoldGained);
      }
      else
      System.out.println("You don't think you can get past the traps.\nYou decide to turn back.");
      break;
    }
    if(f.getPlayerHealth() <= 0)
    playerDeath();
    searchDungeon(first, f);
  }
  public void battle(Weapon first, Character f)
  {
    escape = false;
    enemyEscape = false;
    int tCounter = 0;
    System.out.println("\nYou encounter a goblin.");
    enemyHealth = 20;
    enemyAtt = 5;
    for(;enemyHealth > 0 && f.getPlayerHealth() > 0 && escape == false && enemyEscape == false; tCounter++)
    {
      System.out.println("\nPlayer Health: " + f.getPlayerHealth()); //tells health
      System.out.println("Weapon Durability: " + first.getDurability());
      System.out.println("Goblin Health: " + enemyHealth);
      playerTurn(first, f);
      if(enemyHealth > 0)
      enemyTurn(first, f);
    }
    if(enemyHealth <= 0)
    battleVictory(f);
    else if(f.getPlayerHealth() <= 0)
    playerDeath();
    else
    battleEscaped();
    searchDungeon(first, f);
  }
  public void playerTurn(Weapon first, Character f)
  {
    blocking = false;
    Scanner battle = new Scanner(System.in);
    f.falseGaveAnswer();
    while(f.getGaveAnswer() == false)
    {
      if((first.getDurability() > 0))
      System.out.println("What do you do?\nFight, Block, Flee");
      else
      System.out.println("What do you do?\nBlock, Flee");
        answer = battle.next().toLowerCase();
        switch(answer)
        {
          case "fight":
          f.trueGaveAnswer();
            if(first.getDurability() > 0)
            {  first.removeDurability(1);
              if(first.getDurability() == 0)
              System.out.println("\nYour weapon shatters!");
              if(enemyBlocking)
              {
                if(first.getStrength() - enemyAtt <= 0)
                System.out.println("The goblin parries your strike!");
                else
                enemyHealth -= first.getStrength() - enemyAtt;
                System.out.println("\nYou strike the goblin with your " + first.getType() + " but the goblin was prepared." + " You deal only " + (first.getStrength() - enemyAtt) + " damage!"); 
              }
              else
              {
              enemyHealth -= first.getStrength(); //basic attack
              System.out.println("\nYou strike the goblin with your " + first.getType() + ".\nYou deal " + first.getStrength() + " damage!"); 
              }
            }
          break;
          case "block":
          f.trueGaveAnswer();
          blocking = true;
          System.out.println("You ready yourself for the goblin's strike.");
          break;
          case "flee": //escape 
          f.trueGaveAnswer();
          if((int)(Math.random() * 100) + first.getSpeed() >= 50)
          {
          escape = true;
          System.out.println("You successfully escaped.");
          }
          else
          System.out.println("You couldn't escape!");
          break;
          default:
          f.falseGaveAnswer();
          System.out.println("Command not recognized.");
          break;
        }
    }
      
  }  
  public void enemyTurn(Weapon first, Character f)
  {
    enemyBlocking = false;
    int eAnswer;
    int dodge = (int)(Math.random() * 100) + first.getSpeed(); // player dodge chance
    if(enemyHealth < enemyHealth/4)
    eAnswer = (int)(Math.random() * 2) + 1;
    else 
    eAnswer = (int)(Math.random() * 3) + 1; // enemy decision
    switch(eAnswer)
    {
      case 1: //enemy attack
      if(dodge <= 100)
      {
        if(blocking)
        {
          if(enemyAtt - first.getStrength() <= 0)
          {
            System.out.println("You parry the goblin's strike!");
          }
          else
          {
          f.removePlayerHealth(enemyAtt - first.getStrength());
          System.out.println("The goblin strikes you for " + (enemyAtt - first.getStrength()) + " damage!");
          }
        }
        else
        {
          f.removePlayerHealth(enemyAtt);
          System.out.println("The goblin strikes you for " + enemyAtt + " damage!");
        }
      }
      if(dodge > 100)
      {
        System.out.println("You evade the goblin's strike!");
      }
      break;
      case 2:    //enemy block
      enemyBlocking = true;
      break;
      case 3:    //enemy flee
      if((int)(Math.random() * 100) + (40 - enemyAtt) > 100)
      {
      enemyEscape = true;
      System.out.println("The goblin got away...");
      }
      else
      System.out.println("The goblin tried to escape but couldn't get away!");
      break;
    }
  }
  public void battleVictory(Character f)
  {
    int battleGold = (int)(Math.random() * 31) + 10;
    System.out.println("\nThe goblin falls!");
    System.out.println("You gain " + battleGold + " gold pieces!");
    f.addPlayerGold(battleGold);
  }
  public void playerDeath()
  {
    System.out.println("\nYou fall onto the cold floors of the dungeon");
  }
  public void battleEscaped()
  {
    System.out.println("\nYou are left alone in the dungeon.");
  }
}
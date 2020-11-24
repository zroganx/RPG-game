import java.util.*;
public class Scenario
{
    private Object[] enemyTypes = {new goblin(), new skeleton(), new slime(), new zombie(), new darkFairy(), new ogre(), new elemental(), new amalgalm()};
    private int encounter;
    private int escapeChance;
  private boolean escape;
  private boolean blocking;
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
      dungeon.close();
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
      int trapDamage = (int)(Math.random() * ((f.getMaxPlayerHealth() / 2) - (f.getMaxPlayerHealth() / 6) + 1) + (f.getMaxPlayerHealth() / 6));
      System.out.println("You trigger a trap!\nYou take " + trapDamage + " damage!");
      f.removePlayerHealth(trapDamage);  
      break;
      case(3): //speed check chest
      int speedCheck = (int)(Math.random() * 50) + 1;
      System.out.println("You discover a treasure trove!\nYou'll have to be fast to avoid the traps!");
      if(first.getSpeed() >= speedCheck)
      {
        int spGoldGained = (int)(Math.random() * 101) + 100;
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
        int stGoldGained = (int)(Math.random() * 101) + 100;
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
    if((int)(Math.random() * 100) + 1 < 40)
        encounter = (int)(Math.random() * 4) + 4; //stronger enemy
    else
        encounter = (int)(Math.random() * 4); //weaker enemy
    Enemies enemy = (Enemies)enemyTypes[encounter];
    enemy.reset();
    escape = false;
    int tCounter = 0;
    System.out.println("\nYou encounter a " + enemy.getEnemyName() + ".");
    for(;enemy.getEnemyHealth() > 0 && f.getPlayerHealth() > 0 && escape == false && enemy.getEnemyEscape() == false; tCounter++)
    {
        int dodge = (int)(Math.random() * 100) + 1; 
      System.out.println("\nPlayer Health: " + f.getPlayerHealth()); //tells health
      System.out.println("Weapon Durability: " + first.getDurability());
      System.out.println(enemy.getEnemyName().substring(0, 1).toUpperCase() + enemy.getEnemyName().substring(1) + " Health: " + enemy.getEnemyHealth());
      playerTurn(first, f, enemy);
      if(enemy.getEnemyHealth() > 0)
      switch(enemy.enemyTurn(first, f, enemy))
      {
          case 1:
          enemy.setEnemyAttacking(false);
           if(dodge > 10 + first.getSpeed())
            {
                if(blocking)
                {
                    if((enemy.getEnemyAtt() - first.getStrength()) / 2 <= 0)
                    {
                        System.out.println("You parry the "+ enemy.getEnemyName() + "'s strike!");
                    }
                    else
                    {
                        f.removePlayerHealth(((enemy.getEnemyAtt() - first.getStrength()) / 2));
                        System.out.println("The " + enemy.getEnemyName() + " strikes you for " + (enemy.getEnemyAtt() - first.getStrength()) + " damage!");
                    }
                }
                else
                {
                    f.removePlayerHealth(enemy.getEnemyAtt());
                    System.out.println("The " + enemy.getEnemyName() + " strikes you for " + enemy.getEnemyAtt() + " damage!");
                }
             }
            else
            {
                System.out.println("You evade the " + enemy.getEnemyName() + "'s strike!");
            }
            enemy.setEnemyAttacking(false);
          break;
          case 2:
            enemy.setEnemyBlocking(true);
          break;
          case 3:
            enemy.setEnemyAttacking(true);
            System.out.println("The " + enemy.getEnemyName() + " is preparing an attack!");
          case 4:
            if((int)(Math.random() * 100) + 1 < 30)
            {
                enemy.setEnemyEscape(true);
                 System.out.println("The " + enemy.getEnemyName() + " got away...");
            }
             else
                 System.out.println("The " + enemy.getEnemyName() + " tried to escape but couldn't get away!");
            break;
            
        }
    }
    if(enemy.getEnemyHealth() <= 0)
    battleVictory(f, enemy);
    else if(f.getPlayerHealth() <= 0)
    playerDeath();
    else
    battleEscaped();
    searchDungeon(first, f);
  }
  public void playerTurn(Weapon first, Character f, Enemies enemy)
  {
    int escapeChance = (int)(Math.random() * 100) + 1;
    int doubleStrike = (int)(Math.random() * 100) + 1;
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
            {  
              first.removeDurability(1);
              if(first.getDurability() == 0)
              System.out.println("\nYour weapon shatters!");
              if(enemy.getEnemyBlocking())
              {
                if(first.getStrength() - enemy.getEnemyAtt() <= 0)
                System.out.println("The " + enemy.getEnemyName() + " parries your strike!");
                else
                {
                enemy.setEnemyHealth(enemy.getEnemyHealth() - (first.getStrength() - enemy.getEnemyAtt()));
                System.out.println("\nYou strike the " + enemy.getEnemyName() + " with your " + first.getType() + " but the " + enemy.getEnemyName() + " was prepared." + " You deal only " + (first.getStrength() - enemy.getEnemyAtt()) + " damage!");
                if(doubleStrike < 10 + (first.getSpeed() * 1.5)) //doulbeStrike blocked
                {
                    System.out.println("You outmanuever the " + enemy.getEnemyName() + " and deal an additional " + (first.getStrength() - enemy.getEnemyAtt()) + " damage!");
                    enemy.setEnemyHealth(enemy.getEnemyHealth() - (first.getStrength() - enemy.getEnemyAtt()));
                }
                }
              
              }
              else
              {
              enemy.setEnemyHealth(enemy.getEnemyHealth()-first.getStrength()); //basic attack
              System.out.println("\nYou strike the " + enemy.getEnemyName() + " with your " + first.getType() + ".\nYou deal " + first.getStrength() + " damage!"); 
              if(doubleStrike < 10 + (first.getSpeed() * 1.5)) //doubleStrike
                {
                    System.out.println("You outmanuever the " + enemy.getEnemyName() + " and deal an additional " + first.getStrength() + " damage!");
                    enemy.setEnemyHealth(enemy.getEnemyHealth() - first.getStrength());
                }
              }
            }
          break;
          case "block":
          f.trueGaveAnswer();
          blocking = true;
          System.out.println("You ready yourself for the " + enemy.getEnemyName() + "'s strike.");
          break;
          case "flee": //escape 
          f.trueGaveAnswer();
          if((escapeChance + first.getSpeed()>= 50))
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
  public void battleVictory(Character f, Enemies e)
  {
    int battleGold = e.enemyGold();
    System.out.println("\nThe " + e.getEnemyName() + " falls!");
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
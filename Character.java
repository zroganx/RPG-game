import java.util.*;
public class Character
{
  private boolean gaveAnswer;
  private String name;  
  private int playerHealth;
  private int playerGold;
  private int maxPlayerHealth;
  public Character(String n)
  {
    name = n;
    playerHealth = 40;
    playerGold = 0;
    maxPlayerHealth = 40;
  }
  public void setName(String n)
  {
    name = n;
  }
 
  public String getName()
  {
    return name;
  }
  public int getPlayerHealth()
  {
    return playerHealth;
  }
  public boolean getGaveAnswer()
  {
    return gaveAnswer;
  }
  public int getPlayerGold()
  {
    return playerGold;
  }
  public int getMaxPlayerHealth()
  {
    return maxPlayerHealth;
  }
  public void addMaxPlayerHealth(int a)
  {
    maxPlayerHealth += a;
  }
  public void removePlayerHealth(int c)
  {
    playerHealth -= c;
    if(playerHealth < 0)
    playerHealth = 0;
  }
  public void addPlayerHealth(int c)
  {
    playerHealth += c;
  }
  public void addPlayerGold(int a)
  {
    playerGold += a;
  }
  public void removePlayerGold(int r)
  {
    playerGold -= r;
  }
  public void trueGaveAnswer()
  {
    gaveAnswer = true;
  }
  public void falseGaveAnswer()
  {
    gaveAnswer = false;
  }
}
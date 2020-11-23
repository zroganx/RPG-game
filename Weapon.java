import java.util.*;
public class Weapon
{
  private String type = "";
  private int strength;
  private int durability;
  private int speed;
  public Weapon(String t, int s, int d)
  {
    type = t;
    strength = s;
    durability = d;
  }
  public Weapon(String t)
  {
    type = t.toLowerCase();
    switch(type)
    {
      case "greatsword":
        strength = 15;
        durability = 15;
        speed = 3;
        break;
      case "axe":
        strength = 7;
        durability = 10;
        speed = 15;
        break;
      case "sword":
        strength = 11;
        durability = 13;
        speed = 10;
        break;
      case "hammer":
        strength = 18;
        durability = 14;
        speed = 1;
        break;

    }
  }
  public String getType()
  {
    return type;
  }
  public int getStrength()
  {
    return strength;  
  }
  public int getSpeed()
  {
    return speed;
  }
  public int getDurability()
  {
    return durability;
  }
  public void removeDurability(int r)
  {
    durability -= r;
  }
  public void addDurability(int a)
  {
    durability += a;
  }
  public String toString()
  {
    return "Type: " + type + "\nStrength: " +strength + "\nSpeed: " + speed + "\nDurability: " + durability;
  }
}
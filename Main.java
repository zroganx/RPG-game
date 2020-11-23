import java.util.*;
class Main {
  public static void main(String[] a) {
    Scanner reader = new Scanner(System.in);
    System.out.println("What is your name?");
    Character firstc = new Character(reader.next());
    System.out.println("Hello " + firstc.getName() + ", welcome to an adventure!");
    System.out.println("Select your first weapon!\n Greatsword, Axe, Sword, or Hammer");
    Weapon first = new Weapon(reader.next());
    System.out.println(first);
    System.out.println("Would you like to enter the dungeon? \ny/n");
    if(reader.next().equals("y"))
    {
      Scenario dungeon = new Scenario("dungeon", first, firstc);
    }
    else
    reader.close();
  }
}
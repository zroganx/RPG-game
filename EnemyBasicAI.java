public class EnemyBasicAI
{
    public int enemyTurn(Weapon first, Character f, Enemies e)
  {
    e.setEnemyBlocking(false);
    int eAnswer;
    if(e.getEnemyHealth() > e.getEnemyTotalHealth()/4)
    eAnswer = (int)(Math.random() * 2) + 1;
    else 
    {
    eAnswer = (int)(Math.random() * 4) + 1; // enemy decision
    while(eAnswer == 3)
    eAnswer = (int)(Math.random() * 4) + 1;
    }
    return eAnswer;
  }
}
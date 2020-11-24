public class EnemyChargeAI
{
    public int enemyTurn(Weapon first, Character f, Enemies e)
    {
    e.setEnemyBlocking(false);
    int eAnswer;
    if(e.getEnemyHealth() > e.getEnemyTotalHealth()/4)
    {
    if(e.getEnemyAttacking() == false)
    eAnswer = (int)(Math.random() * 2) + 2; // enemy decision
    else
    eAnswer = 1;
    }
    else
    {  
    if(e.getEnemyAttacking() == false)
    eAnswer = (int)(Math.random() * 3) + 2; // enemy decision
    else
    eAnswer = 1;
    }
    return eAnswer;
    }
}
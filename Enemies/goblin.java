public class goblin extends EnemyBasicAI implements Enemies
{
    private boolean enemyEscape;
    private boolean enemyBlocking;
    private boolean enemyAttacking;
    private String enemyName;
    private int enemyHealth;
    private int enemyAtt;
    private int enemyTotalHealth;
    
    public goblin()
    {
        enemyEscape = false;
        enemyBlocking = false;
        enemyName = "goblin";
        enemyHealth = 20;
        enemyAtt = 5;
        enemyTotalHealth = enemyHealth;
    }
    
    public int enemyTurn(Weapon first,Character f,Enemies e)
    {
       return super.enemyTurn(first, f, e);
    }
    public int getEnemyTotalHealth()
    {
        return enemyTotalHealth;
    }
    public boolean getEnemyAttacking()
    {
      return enemyAttacking;
    }
    public String getEnemyName()
    {
        return enemyName;
    }
    public boolean getEnemyEscape()
    {
        return enemyEscape;
    }
    public boolean getEnemyBlocking()
    {
        return enemyBlocking;
    }
    public int getEnemyHealth()
    {
        return enemyHealth;
    }
    public int getEnemyAtt()
    {
        return enemyAtt;
    }
    public void setEnemyBlocking(boolean s)
    {
        enemyBlocking = s;
    }
    public void setEnemyHealth(int s)
    {
        enemyHealth = s;
    }
    public void setEnemyEscape(boolean s)
    {
        enemyEscape = s;
    }
    public void setEnemyAttacking(boolean s)
    {
        enemyAttacking = s;
    }
    public void reset()
    {
        enemyEscape = false;
        enemyBlocking = false;
        enemyName = "goblin";
        enemyHealth = 20;
        enemyAtt = 5;
        enemyTotalHealth = enemyHealth;
    }
    public int enemyGold()
    {
        return (int)(Math.random() * 31) + 10;
    }
    
}
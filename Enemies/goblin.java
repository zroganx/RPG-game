public class goblin extends EnemyBasicAI implements Enemies
{
    private boolean enemyEscape;
    private boolean enemyBlocking;
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
    @Override
    public String getEnemyName()
    {
        return enemyName;
    }
    @Override
    public boolean getEnemyEscape()
    {
        return enemyEscape;
    }
    @Override
    public boolean getEnemyBlocking()
    {
        return enemyBlocking;
    }
    @Override
    public int getEnemyHealth()
    {
        return enemyHealth;
    }
    @Override
    public int getEnemyAtt()
    {
        return enemyAtt;
    }
    @Override
    public void setEnemyBlocking(boolean s)
    {
        enemyBlocking = s;
    }
    @Override
    public void setEnemyHealth(int s)
    {
        enemyHealth = s;
    }
    @Override
    public void setEnemyEscape(boolean s)
    {
        enemyEscape = s;
    }

    
}
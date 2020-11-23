public class ogre extends EnemyBasicAI implements Enemies
{    
    private boolean enemyEscape;
    private boolean enemyBlocking;
    private String enemyName;
    private int enemyHealth;
    private int enemyAtt;
    private int enemyTotalHealth;
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
        enemyHealth += s;
    }
    @Override
    public void setEnemyEscape(boolean s)
    {
        enemyEscape = s;
    }
}
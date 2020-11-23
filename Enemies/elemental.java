public class elemental extends EnemyBasicAI implements Enemies
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
        enemyHealth += s;
    }
    public void setEnemyEscape(boolean s)
    {
        enemyEscape = s;
    }
}
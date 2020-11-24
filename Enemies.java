interface Enemies
{
     //elemental darkFairy slime ogre zombie skeleton goblin amalgamation
    public boolean getEnemyEscape();
    public boolean getEnemyBlocking();
    public boolean getEnemyAttacking();
    public String getEnemyName();
    public int getEnemyHealth();
    public int getEnemyAtt();
    public int getEnemyTotalHealth();
    public void setEnemyEscape(boolean s);
    public void setEnemyBlocking(boolean s);
    public void setEnemyHealth(int s);
    public void setEnemyAttacking(boolean s);
    public int enemyTurn(Weapon first, Character f, Enemies e);
    public void reset();
    public int enemyGold();
    
}
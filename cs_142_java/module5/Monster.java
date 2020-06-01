
public class Monster {
    private int maxHP;
    private int currentHP = maxHP;
    private String name;

    public Monster(int maxHP, String name) {
        this.maxHP = maxHP;
        this.name = name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public void takeDamage(int damage) {
        currentHP -= damage;
        if (currentHP <= 0) {
            System.out.println( name + ": You killed me!");
        }
	}
}

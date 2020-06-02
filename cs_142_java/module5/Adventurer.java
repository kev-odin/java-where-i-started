public class Adventurer {
    // Fields
    private String name;
    private String job;
    private int[] abilityScores; // 3 elements: strength, dexterity, intel
    private int maxHP = 10; // initiallized to 10
    private int currentHP = maxHP;

    // Constructors
    public Adventurer(int str, int dex, int intel) {
        // Store the stats in an int array
        abilityScores = new int[3];
        abilityScores[0] = str;
        abilityScores[1] = dex;
        abilityScores[2] = intel;
    }

    public Adventurer(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public Adventurer(String name, String job, int str, int dex, int intel) {
        this(str, dex, intel); // three integers, runs the top constructor
        this.name = name;
        this.job = job;
    }

    // Methods
    public void introSelf() {
        System.out.println("My name is " + name + " and I am a " + job + ".");
    }

    public void attack(Monster m) {
        m.takeDamage(10);
    }

    public void rest() {
        currentHP = maxHP;
    }

    @Override
    public String toString() {
        String s = name + " " + job + "\nCurrent HP: " + currentHP;
        System.out.println();
        return s;
    }

    // Getters and Setters
    public int getCurrentHP() {
        return currentHP;
    }

    public String getName() {
        return this.name;
    }

    public String getJob() {
        return this.job;
    }

    public int getStrength() {
        return abilityScores[0];
    }

    public int getDexterity() {
        return abilityScores[1];
    }

    public int getIntelligence() {
        return abilityScores[2];
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setJob(String newJob) {
        this.job = newJob;
    }

    public void setStrength(int str) {
        abilityScores[0] = str;
    }

    public void setDexterity(int dexterity) {
        if (dexterity <= 0 || dexterity > 20) {
            System.out.println("That is not a valid score.");
        } else {
            abilityScores[1] = dexterity;
        }
    }

    public void setIntelligence(int intelligence) {
        abilityScores[2] = intelligence;
    }
}
public class Adventurer {
    // Fields
    private String name;
    private String job;
    private int[] abilityScores; // 3 elements: strength, dexterity, intel
    // private int strength;
    // private int dexterity;
    // private int intelligence;
    private int maxHP = 10; // initiallized to 10

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

    // Getters and Setters
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

    // Methods
    public void introSelf() {
        System.out.println("My name is " + name + " and I am a " + job + ".");
    }

    public void attack(Monster m) {
        m.takeDamage(10);
    }

    public void listStats() {
        System.out.println("Here are my stats: ");
        System.out.println("Strength: " + abilityScores[0]);
        System.out.println("Dexterity: " + abilityScores[1]);
        System.out.println("Intelligence: " + abilityScores[2]);
        System.out.println("Max Hit Points: " + maxHP);
    }
}
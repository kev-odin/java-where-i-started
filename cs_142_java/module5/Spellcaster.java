public class Spellcaster extends Adventurer{
    int maxMP;
    int currentMP;

    public Spellcaster(String name, String job, int str, int dex, int intel, int maxMP) {
        super(name, job, str, dex, intel);
        this.maxMP = maxMP;
        this.currentMP = maxMP;
    }

    public void heal(Adventurer a) {
        if (currentMP >= 5) {
            a.setCurrentHP(a.getMaxHP());
            currentMP -= 5;
        }
    }

    @Override
    public void rest() {
        super.rest();
        currentMP = maxMP;
    }
    @Override
    public String toString(){
        String s = super.toString();
        s += "\nCurrent MP: " + currentMP;
        return s;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    public void setCurrentMP(int currentMP) {
        this.currentMP = currentMP;
    }
}
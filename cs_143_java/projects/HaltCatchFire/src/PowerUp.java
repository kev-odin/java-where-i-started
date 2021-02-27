//Zhengqi Yang
public class PowerUp {
    private int streak;
    private boolean powerUpStatus;

    public PowerUp(int streak, boolean powerUpStatus) {
        this.streak = streak;
        powerUpStatus = false;
    }

    public int countStreak() {
        int res = 0;
        return res + streak;
    }

    public boolean status() {
        if (powerUpStatus) {
            return true;
        } else {
            return false;
        }
    }
}

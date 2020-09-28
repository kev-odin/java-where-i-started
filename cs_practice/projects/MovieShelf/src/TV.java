// Learning how to work with objects in java

public class TV {
    private int channel;
    private int volume;
    private boolean on;

    public static void main(String[] args) {
    }

    public TV(){
    }

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    public void setChannel(int channel) {
        if (on && channel >= 1 && channel <= 50) {
            this.channel = channel;
        } 
    }

    public void setVolume(int volume) {
        if (on && volume >= 0 && volume <= 100) {
            this.volume = volume;
        } 
    }

    public void channelUp() {
        if (on && channel < 50) {
            channel++;
        }
    }
    
    public void channelDown() {
        if (on && channel > 1) {
            channel--;
        }
    }

    public void volumeUp() {
        if (on && volume < 100) {
            volume++;
        }
    }

    public void volumeDown() {
        if (on && volume > 0) {
            volume--;
        }
    }

    public String toString() {
        return "The TV is set to channel " + channel + " and the volume is " + volume;
    }
}

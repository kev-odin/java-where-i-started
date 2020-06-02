import java.awt.Color;

public class ColorfulBouncingCircle extends ColorfulCircle {

    public ColorfulBouncingCircle(double radius, double centerX, double centerY, Color color, double xVelocity, double yVelocity) {
        super(radius, centerX, centerY, color);

    }

    public static void setPlayingFieldSize(double newWidth, double newHeight) {

    }

    public void tick() {

    }

    public boolean overlaps(Circle c) {

        return true;
    }

}

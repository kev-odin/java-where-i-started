import java.awt.Color;

public class ColorfulBouncingCircle extends ColorfulCircle {
    private double xVelocity;
    private double yVelocity;
    private double newWidth;
    private double newHeight;

    public ColorfulBouncingCircle(double radius, double centerX, double centerY, Color color, double xVelocity, double yVelocity) {
        super(radius, centerX, centerY, color);
        ColorfulBouncingCircle cbc = new ColorfulBouncingCircle(radius, centerX, centerY, color, xVelocity, yVelocity);

    }

    public static void setPlayingFieldSize(double newWidth, double newHeight) {


    }

    public void tick() {

    }

    public boolean overlaps(Circle c) {

    return true;
    }

}

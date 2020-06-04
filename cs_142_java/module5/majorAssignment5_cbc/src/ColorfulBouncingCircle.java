import java.awt.Color;

public class ColorfulBouncingCircle extends ColorfulCircle {
    private double xVelocity;
    private double yVelocity;

    private static double width;
    private static double height;

    public ColorfulBouncingCircle(double radius, double centerX, double centerY, Color color, double xVelocity, double yVelocity) {
        super(radius, centerX, centerY, color);
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public static void setPlayingFieldSize(double newWidth, double newHeight) { 
        width = newWidth;
        height = newHeight;
    }

    public void tick() {
        double positionX = this.getCenterX() + this.xVelocity;
        double positionY = this.getCenterY() + this.yVelocity;

        if ((positionX > 0 && positionX <= width) && (positionY > 0 && positionY <= height)) {
            this.setCenterCoordinates(positionX, positionY);
        } else if (positionX > width || positionX < 0) {
            this.xVelocity = xVelocity * (-1.0);
            positionX = this.getCenterX() + this.xVelocity;
        } else if (positionY > height || positionY < 0) {
            this.yVelocity = yVelocity * (-1.0);
            positionY = this.getCenterY() + this.yVelocity;
        }
        this.setCenterCoordinates(positionX, positionY);
    }
    
    @Override
    public boolean overlaps(Circle c) {
        if (super.overlaps(c)) {
            return true;
        }
    
    return false;
    }

    public double getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public double getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    

}

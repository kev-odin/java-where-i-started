import java.awt.Color;
// Kevin Chung

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
        double positionX = getCenterX() + getxVelocity();
        double positionY = getCenterY() + getyVelocity();

        if ((positionX >= 0 && positionX <= width) && (positionY >= 0 && positionY <= height)) { // movement is within the ball playing field, move accordingly
            if ((positionX == width || positionX == 0) && (positionY == height || positionY == 0)) { // corner case
                xVelocity *= -1;
                yVelocity *= -1;
            }
            setCenterCoordinates(positionX, positionY);
        } 
        
        else if (positionX < 0 || positionX > width || positionY < 0 || positionY > height) {  // center coordinates do not change - x and y
            setCenterCoordinates(positionX - getxVelocity(), positionY - getyVelocity()); // ball does not move, or change center position
            if (positionX < 0 || positionX > width) {
                xVelocity *= -1;
            }
            if (positionY < 0 || positionY > height) {
                yVelocity *= -1;
            }
        }
    }
    
    @Override
    public boolean overlaps(Circle c) {
        if (super.overlaps(c)) {
            if (this.getCenterX() > c.getCenterX() || this.getCenterX() < c.getCenterX()) { // overlap true - flip xVelocity
                //setxVelocity(xVelocity * (-1.0));
            } else if (this.getCenterY() > c.getCenterY() || this.getCenterY() < c.getCenterY()) { // overlap true - flip yVelocity
                //setyVelocity(yVelocity * (-1.0));
            }
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

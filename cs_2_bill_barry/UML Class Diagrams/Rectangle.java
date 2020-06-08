public class Rectangle {
    private double width;
    private double height;
    
    // Constructor with no parameters
    public Rectangle() {
        width = 1.0;
        height = 1.0;
    }
    // Constructor with 2 parameters
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Methods
    public double getArea(double width, double height) {
        return width * height;
    }

    public double getPerimeter(double width, double height) {
        return (2 * width) + (2 * height);
    }

    // Getters and Setters
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String toString() {
        String s = "\nThis rectangle has these features: ";
        s += "\nWidth: " + getWidth();
        s += "\nHeight: " + getHeight();
        s += "\nArea: " + getArea(width, height);
        s += "\nPerimeter: " + getPerimeter(width, height);
        return s;
    }

    //Testing
    public static void main(String[] args) {
        Rectangle testRect = new Rectangle(4.0, 40.0);
        Rectangle rect2 = new Rectangle(3.5, 35.9);
        
        System.out.println(testRect);
        System.out.println(rect2);
        rect2.setWidth(35.9);
        System.out.println(rect2);
    }
}
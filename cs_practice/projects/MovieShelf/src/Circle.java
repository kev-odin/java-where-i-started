// Book practice - Chapter 9
public class Circle {
    private double radius = 1;

    //Main class
    public static void main(String[] args) {
        Circle a = new Circle();
        Circle b = new Circle(25);
        Circle c = new Circle(125);
        printCircle(a.radius, a.getArea());
        printCircle(b.radius, b.getArea());
        printCircle(c.radius, c.getArea());
    }

    // Constructors
    public Circle() {
    }

    public Circle(double newRadius) {
        this.radius = newRadius;
    }

    // Methods
    public static void printCircle(double radius, double area) { // I made this!
        System.out.println("The area of the circle of the radius " + radius + " is " + area);
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public void setRadius(double newRadius) {
        this.radius = newRadius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }

    public double getRadius() {
        return radius;
    }

}

import java.util.jar.Manifest;

public class Rectangle {
    public static void main(String[] args) {
        fillRect(1, 1);
        fillRect(2, 3);
        fillRect(3, 2);
    }

    public static void fillRect(int width, int height) {
        System.out.println("This rectangle has these parameters: width " + width + " and height " + height);
        for (int i = 0; i <= height - 1; i++) {
            for (int j = 0; j <= width - 1; j++) {
                System.out.println("(" + i + "," + j + ")");
            }
        }
    }
}

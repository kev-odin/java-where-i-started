public class IAListMain {
    public static void main(String[] args) {
        IAList a = new IAList();

        for (int i = 0; i <= 4; i++) {
            a.add(i);
        }

        a.addBefore(2);
    }
}

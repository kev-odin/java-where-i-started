public class IAListMain {
    public static void main(String[] args) {
        IAList a = new IAList();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.addBefore(5);
        a.addBefore(6);
        System.out.println(a.get(0));
        System.out.println(a.size());
    }
}

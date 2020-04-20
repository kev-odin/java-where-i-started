public class Date {
    public static void main(String[] args) {
        String dayOfWeek = "Sunday";
        String monthName = "April";
        int dayOfMonth = 19;
        int currentYear = 2020;

        System.out.println("Standard American format: ");
        System.out.println(dayOfWeek + ", " + monthName + " " + dayOfMonth + ", " + currentYear);
        System.out.println();
        System.out.println("European format: ");
        System.out.println(dayOfWeek + " " + dayOfMonth + " " + monthName + " " + currentYear);

    }
}
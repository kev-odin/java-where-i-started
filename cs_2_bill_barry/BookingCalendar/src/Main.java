public class Main {
    public static void main(String[] args) {
        // Create the array to hold the status, 2D array(kinda useful)
        Status[][] suiteStatus = new Status[12][31];

        // Set initial status
        for (int month = 0; month < 12; month++) {
            for (int day = 0; day < 31; day++) {
                suiteStatus[month][day] = Status.OPEN;
            }
        }
        setNaDays(suiteStatus, 2016);
        // Set a booking 
        setBooking(suiteStatus, 2, 14, Status.BOOKED);

        // Check status
        System.out.println("Status for 2/13: " + checkBooking(suiteStatus, 2, 13));
        System.out.println("Status for 2/14: " + checkBooking(suiteStatus, 2, 14));
        System.out.println("Status for 2/31: " + checkBooking(suiteStatus, 2, 31));

    }

    public static void setBooking(Status[][] statusArray, int month, int day, Status status) {
        if (month < 1 || month > 12 || day < 1 || day > 31 || statusArray[month - 1][day - 1] == Status.NA) {
            throw new IllegalArgumentException("Invalid month or day specified.");
        }
        statusArray[month - 1][day - 1] = status;
    }


    public static void setNaDays(Status[][] statusArray, int year) {
        // Set for all years
        setBooking(statusArray, 2, 30, Status.NA);
        setBooking(statusArray, 2, 31, Status.NA);
        setBooking(statusArray, 4, 31, Status.NA);
        setBooking(statusArray, 6, 31, Status.NA);
        setBooking(statusArray, 9, 31, Status.NA);
        setBooking(statusArray, 11, 31, Status.NA);

        // Handle leap year specifics, another one for mod 400
        if (year % 4 != 0) {
            setBooking(statusArray, 2, 29, Status.NA);
        }
    }

    public static Status checkBooking(Status[][] statusArray, int month, int day) {
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            throw new IllegalArgumentException("Invalid month or day specified.");
        }
        return statusArray[month - 1][day - 1];
    }
}

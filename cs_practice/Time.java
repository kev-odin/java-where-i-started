
public class Time {
    public static void main(String[] args) {
        int hour = 12;
        int minute = 56;
        int second = 30;
        //Excerise start time
        System.out.println("The time this project started was: " + hour + ":" + minute + ":" + second);

        //Time since midnight
        int hourTimeSeconds = convertMinuteToSecond(convertHourToMinute(hour));
        int minuteTimeSeconds = convertMinuteToSecond(minute);
        int secondSinceMidnight = hourTimeSeconds + minuteTimeSeconds + second;
        System.out.println("The number of seconds since midnight is: " + secondSinceMidnight);

        //Remaining seconds in the day
        int numberOfSecondsInDay = 24 * 60 * 60;
        int secondsRemaining = numberOfSecondsInDay - secondSinceMidnight;
        System.out.println("The number of seconds remaining is: " + secondsRemaining);

        //Percent of time left in a day
        float percentOfDayLeft = ((float) secondsRemaining / (float) numberOfSecondsInDay) * 100;
        System.out.println("The remaining percentage of the day is : " + percentOfDayLeft + "%");

        //Time elapsed for this excercise
        int newHour = 13;
        int newMinute = 19;
        int newSecond = 45;

        int timeHourElapsed = newHour - hour;
        int timeMinuteElaped = (60 - newMinute) - (60 - minute);
        int timeSecondsElapsed = newSecond - second;

        System.out.println("The amount of time that elapsed was :" + timeHourElapsed + " hours and " + timeMinuteElaped + " minutes and " + timeSecondsElapsed + " seconds.");
    }

    public static int convertHourToMinute (int hour) {
        int minute = hour * 60;
        return minute;
    }

    public static int convertMinuteToSecond (int minute) {
        int seconds = minute * 60;
        return seconds;
    }
}
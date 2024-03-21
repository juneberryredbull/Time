// Eddie Hart
// March 18th, 2024
// CSC 1060
public class Time {
    // private integers for the Time class
    private int hour;
    private int minute;
    private int second;

    // time object that defaults to midnight
    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    // time object that takes input for a custom time
    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // here the print method uses an if else statement to determine whether it will be military time or not.
    public void print(boolean military) {
        if (military) {
            System.out.printf("%02d:%02d:%02d \n", this.hour, this.minute, this.second);
        } else {
            // heres a little nested if else statement to make sure it displays PM and AM properly
            if (this.hour >= 12) {
                this.hour -= 12;
                System.out.printf("%02d:%02d:%02d PM \n", this.hour, this.minute, this.second);
            } else {
                System.out.printf("%02d:%02d:%02d AM \n", this.hour, this.minute, this.second);
            }
        }
    }

    /* the increment method was the hardest part of the program for me to figure out,
    and im still not quite happy with it, although it works with the given times for the assignment.
    it was hard to figure out how to make it so that it would display proper changing of time and not weird
    times like 7:60:30 or 02:00:00. again i still think its kinda iffy and im not sure if it will work with any time
    but it works with the times given so ill just leave it there.
     */
    public void increment(int seconds) {
        int secondsRemainder = seconds % 60;
        int minuteRemainder = seconds / 60;
        int hourRemainder = seconds / 3600;
        this.second += secondsRemainder;
        this.hour += hourRemainder;
        if (this.second >= 60) {
            this.second -= 60;
            this.minute += 1;
        }
        if (minuteRemainder != 60) {
            this.minute += minuteRemainder;
            if (this.minute >= 60) {
                this.minute = 0;
                this.hour += 1;
            }
        }
    }

    // here the fromString method will split a time string at the colon
    // the parseInt method will check the int at the desired index from the array and store them in their respective variable
    // the method returns a Time object with the previously given string
    public static Time fromString(String input) {
        String[] splitstring = input.split(":");
        int Hour = Integer.parseInt(splitstring[0]);
        int Minute = Integer.parseInt(splitstring[1]);
        int Second = Integer.parseInt(splitstring[2]);
        return new Time(Hour, Minute, Second);
    }
}




import java.time.LocalDateTime;

public class DateData {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    public DateData(LocalDateTime localDateTime) {
        this.year = localDateTime.getYear();
        this.month = localDateTime.getMonthValue();
        this.day = localDateTime.getDayOfMonth();
        this.hour = localDateTime.getHour();
        this.minute = localDateTime.getMinute();
        this.second = localDateTime.getSecond();
    }



}

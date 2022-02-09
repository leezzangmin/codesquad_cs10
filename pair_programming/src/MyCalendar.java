import java.time.LocalDateTime;

public class MyCalendar {
    // LocalDateTime now = LocalDateTime.now();

    public DateData getDateDataNow() {
        LocalDateTime now = LocalDateTime.now();
        return new DateData(now);
    }

    public LocalDateTime getLocalDateTime(String date) {
        String[] dateArray = date.split("-");

        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int day = Integer.parseInt(dateArray[2]);

        return LocalDateTime.of(year, month, day, 0, 0, 0);
    }

    public LocalDateTime getLocalDateTime(int year, int month, int day) {
        return LocalDateTime.of(year, month, day, 0, 0, 0);
    }

}

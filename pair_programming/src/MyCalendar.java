import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

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

    public String getKoreanDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
                //new DateTimeFormatterBuilder().toFormatter(Locale.KOREAN);
        return localDateTime.format(formatter);
    }

}

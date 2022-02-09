import java.time.LocalDateTime;

public class MAIN {
    public static void main(String[] args){
        // YYYY-MM-DD
        //now.format(DateTimeFormatter.ofPattern("MM월 dd일(E)").withLocale(Locale.forLanguageTag("fr"))) // 프랑스어

        MyCalendar myCalendar = new MyCalendar();

        System.out.println(myCalendar.getLocalDateTime("2020-01-01"));
        try {
            System.out.println(myCalendar.getLocalDateTime("2020-13-01"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(myCalendar.getLocalDateTime(2020, 1, 1));
        try {
            System.out.println(myCalendar.getLocalDateTime(2020, 13, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(myCalendar.getKoreanDateTime(LocalDateTime.now()));



    }
}
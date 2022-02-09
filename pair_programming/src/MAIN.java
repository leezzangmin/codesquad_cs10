public class MAIN {
    public static void main(String[] args){
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

    }
}
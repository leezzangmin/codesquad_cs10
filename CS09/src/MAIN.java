import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class MAIN {
    public static void main(String[] args){
        String Driver="";
        String userid="root";
        String userpw = "lcm12345";
        Connection conn = null;

        String url="jdbc:mysql://127.0.0.1:3306/mission2";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("로드 성공");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            conn=DriverManager.getConnection(url,userid,userpw);
            System.out.println("연결성공");
        }catch(Exception e){
            e.printStackTrace();
        }

        String query = "select * from PCseat where isUsing = FALSE";
        ArrayList<Integer> seat = new ArrayList<>();
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                seat.add(rs.getInt(1));
                //System.out.println(rs.getInt(1));
            }
            conn.close();
            System.out.println("빈 자리는 다음과 같습니다");
            System.out.println(seat);
        }catch(Exception e){
            e.printStackTrace();
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("> ");
        String input = scan.next();
        if(input.equals("new")){
            double dValue = Math.random();
            int seatNum = (int)(dValue * 10);
            System.out.printf("%d번 자리에 앉으세요 ",seatNum);
        }
    }
}

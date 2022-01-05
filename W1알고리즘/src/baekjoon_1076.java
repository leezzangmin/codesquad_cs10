import java.lang.reflect.Array;
import java.util.*;
public class baekjoon_1076 {
    public static void main(String[] args){

        HashMap<String, String> color = new HashMap<>();
        color.put("black","0_1");
        color.put("brown","1_10");
        color.put("red","2_100");
        color.put("orange","3_1000");
        color.put("yellow","4_10000");
        color.put("green","5_100000");
        color.put("blue","6_1000000");
        color.put("violet","7_10000000");
        color.put("grey","8_100000000");
        color.put("white","9_1000000000");

        Scanner input = new Scanner(System.in);
        String a=input.next();
        String b=input.next();
        String c=input.next();
        String answer="";
        String temp;
        if  (!(a.equals("black"))) {
            temp = color.get(a).split("_")[0];
            answer += temp;
        }
        if (a.equals("black") && b.equals("black")){
            System.out.println("0");
        }
        else {
            temp = color.get(b).split("_")[0];
            answer += temp;

            temp = color.get(c).split("_")[1];
            for (int i = 0; i < temp.length() - 1; i++) {
                answer += "0";
            }
            System.out.println(answer);
        }

    }
}

import java.util.Scanner;
import java.math.*;
public class baekjoon_10757 {
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);

        BigInteger A = new BigInteger(input.next());
        BigInteger B = new BigInteger(input.next());
        System.out.println(A.add(B));
    }
}

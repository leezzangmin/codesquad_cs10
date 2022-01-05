import java.util.Arrays;

public class MAIN {

    public static boolean and(boolean paramA, boolean paramB){
        return paramA && paramB;
    }

    public static boolean or(boolean paramA, boolean paramB){
        return paramA || paramB;
    }

    public static boolean nand(boolean paramA, boolean paramB){
        return ! (paramA && paramB);
    }

    public static boolean xor(boolean paramA, boolean paramB){
        if( (paramA==true && paramB==false) || (paramA==false && paramB==true) ){
            return true;
        }
        return false;
    }




    public static void main(String[] args){
        class Convertor {

            public boolean[] dec2bin(int decimal) {
                boolean[] answer = {false,false,false,false,false,false,false,false};
                int pointer=7;
                while (decimal>1) {
                    if (decimal % 2 == 1) {
                        answer[pointer]=true;
                    }
                    else{
                        answer[pointer]=false;
                    }
                    decimal/=2;
                    pointer-=1;
                }
                answer[pointer]=true;
                return answer;
            }

            public int bin2dec(boolean[] binary) {
                int digitValue = 1;
                int answer = 0;
                for(int i=0;i<binary.length;i++){
                    if (binary[i]){
                        answer+=digitValue;
                    }
                    digitValue*=2;
                }
                return answer;
            }
        }

        class Adder {
            public boolean[] byteadder(boolean[] byteA, boolean[] byteB){
                boolean[] answer = {false,false,false,false,false,false,false,false,false};
                boolean carry = false;
                for (int i=byteA.length-1; i>=0;i--){
                    boolean[] temp = fulladder(byteA[i], byteB[i], carry);
                    carry = temp[0];
                    answer[i+1]=temp[1];
                }
                answer[0]=carry;
                return answer;

            }

            public boolean sum(boolean paramA,boolean paramB){
                return xor(paramA, paramB);
            }
            public boolean carry(boolean paramA,boolean paramB){
                return and(paramA, paramB);
            }

            public boolean[] halfadder(boolean bitA, boolean bitB) {
                boolean[] answer = {  carry( bitA, bitB ), sum( bitA, bitB ) };

                return answer;
            }
            public boolean[] fulladder(boolean bitA, boolean bitB, boolean carry) {
                boolean[] a = halfadder(bitA,bitB);
                boolean[] b = halfadder(carry,a[1]);

                boolean[] answer = { or(a[0],b[0]),b[1] };
                return answer;
            }
        }

        Adder a = new Adder();

        boolean[] byteA  = { false,true,false,true,true,false,true,true };
        boolean[] byteB  = { true,true,false,false,true,true,false,true};
        boolean[] temp = a.byteadder(byteA,byteB);

//        for(int i=0;i<temp.length;i++){
//            System.out.println(temp[i]);
//
//        }
        Convertor c= new Convertor();
        System.out.println( Arrays.toString(c.dec2bin(10)) );
    }
}
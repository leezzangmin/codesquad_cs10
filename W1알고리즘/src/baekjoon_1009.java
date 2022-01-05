import java.util.*;
public class baekjoon_1009 { // Main으로 바꿔야함

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int a,b;

        for(int i=0;i<T;i++){
            a = input.nextInt()%10;
            b = input.nextInt();
            if (a==1){
                System.out.println(1);
            }
            else if(a==2){
                int answer[]={6,2,4,8};
                System.out.println(answer[b%4]);
            }
            else if(a==3){
                int answer[]={1,3,9,7};
                System.out.println(answer[b%4]);
            }
            else if(a==4){
                int answer[]={6,4};
                System.out.println(answer[b%2]);
            }
            else if(a==5){
                System.out.println(5);
            }
            else if (a==6){
                System.out.println(6);
            }
            else if (a==7){
                int answer[]={1,7,9,3};
                System.out.println(answer[b%4]);
            }
            else if (a==8){
                int answer[]={6,8,4,2};
                System.out.println(answer[b%4]);
            }
            else if(a==9){
                int answer[]={1,9};
                System.out.println(answer[b%2]);
            }
            else if(a%10==0){
                System.out.println(10);
            }
        }
    }
}
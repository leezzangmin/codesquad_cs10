import java.util.ArrayList;

public class outputView {
    private final static String systemDone = "모든 프로세스가 종료되었습니다.";
    public static void printProcessStatus(ArrayList<Process> printQueue){
        for(int i=0;i<3;i++){
            System.out.println(printQueue.get(i));
        }
        System.out.println(".");
    }
    public static void printProcessFinished(){
        System.out.println(systemDone);
    }
}

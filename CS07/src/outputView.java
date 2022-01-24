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

    public static void printProcessList(ArrayList<Process> printQueue){
        int TotalNumberOfThreads = 0;
        System.out.println("이 프로그램은");
        for(int i=0;i<printQueue.size();i++){
            Process temp = printQueue.get(i);
            int TempNumberOfThreads = temp.myThreads.length;
            TotalNumberOfThreads += TempNumberOfThreads;
            System.out.printf("프로세스%s (%d초) - 스레드 %d개\n", temp.processId, temp.duration, TempNumberOfThreads);
        }

        System.out.printf("총 스레드는 %d개입니다.\n\n", TotalNumberOfThreads);
    }
}

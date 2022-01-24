//마치 운영체제가 프로세스를 스케줄링하는 것처럼 프로세스를 일정한 시간동안 실행하는 프로그램을 구현한다.
//프로세스 종류를 5개 정하고, 프로세스 마다 최대 동작 시간을 겹치지 않도록 결정한다.
//예) 프로세스A : 3초, 프로세스B : 5초, 프로세스C : 7초, 프로세스D : 10초, 프로세스E : 15초
//우리가 목표로 하는 운영체제는 한 번에 프로세스 하나씩만 1초동안만 실행할 수 있다. 해당 프로세스 외 다른 프로세스는 실행하지 않는다.
//1초 이후에는 같은 프로세스가 아니라 다른 프로세스를 실행해야 한다. 만약 프로세스가 1개만 남은 경우 반복해서 같은 프로세스를 실행할 수 있다.
//프로세스 상태는 준비ready, 실행running, 대기waiting, 종료terminated 4 가지 상태 중에 하나다.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//이 프로그램을 시작하면, 랜덤으로 프로세스 3개를 생성하고 대기 큐에 추가한다.
//프로세스는 ready 또는 waiting 상태에서만 실행상태로 바뀔 수 있다.
//누적 동작 시간이 최대 동작 시간만큼 실행한 프로세스는 terminated 상태로 바뀐다.
//누적 동작 시간이 최대 동작 시간보다 작으면 다시 waiting 상태가 된다.
//프로세스마다 작업 정보를 포함하는 데이터 구조 또는 타입을 선언한다.
//단지 출력을 하기 위한 프로그램을 작성하는 게 아니라, 프로세스 타입을 선언하고 프로세스마다 1초씩 동작하는 구조를 구현해야 한다
//프로그램은 1초마다 전체 프로세스 상태와 누적 실행 시간을 표시한다.
//프로그램은 모든 프로세스가 멈추고 나면 종료한다.
import java.util.*;

public class OS {

    private Queue<Process> processQueue = new LinkedList<>();
    private ArrayList<Process> printQueue = new ArrayList<>();

    OS(){
        printQueue.add(new Process("A","ready",3));
        printQueue.add(new Process("B","ready",5));
        printQueue.add(new Process("C","ready",7));
        for(int i=0;i<3;i++){
            processQueue.add(printQueue.get(i));
        }
    }

    public void run_os(){
        outputView.printProcessList(printQueue);
        outputView.printProcessStatus(printQueue);

        while (!processQueue.isEmpty()){
            Process currentProcess = processQueue.poll();
            currentProcess.state = "running";


            Thread[] t = new Thread[currentProcess.myThreads.length];
            for(int i=0;i<currentProcess.myThreads.length;i++){
                // https://developer88.tistory.com/87
                t[i]=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if(currentProcess.elapsedTime<currentProcess.duration){
                        currentProcess.elapsedTime+=1;
                        }
                    }
                });
                t[i].start();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            if(currentProcess.elapsedTime == currentProcess.duration){
                currentProcess.state = "terminated";
            }
            else if(currentProcess.elapsedTime < currentProcess.duration){
                currentProcess.state = "waiting";
                processQueue.add(currentProcess);
            }

           outputView.printProcessStatus(printQueue);
        }

        outputView.printProcessStatus(printQueue);
    }
}

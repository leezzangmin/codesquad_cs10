package mission1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CafeManager {
    private static final int sleepTime = 1000;

    CafeManager(){}


    public void observeOrderQueue(){
        int second=0;
        while (true) {
            if (second==3){
                break;
            }
            sleepOneSecond();
            if (!OrderQueue.getOrderQueue().isEmpty()) {
                OutputView.showOrderQueue();
                System.out.println("주문감지");
                while(!OrderQueue.getOrderQueue().isEmpty()){
                    Barista.addBaristaQueue( OrderQueue.getOrderQueue().poll() );
                }
            }
            second+=1;
        }
    }

    public void mangerRun(){
        while(true){

        }
    }

    private void sleepOneSecond(){
        try {
            Thread.sleep( sleepTime );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

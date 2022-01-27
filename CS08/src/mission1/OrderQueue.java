package mission1;

import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {
    private static Queue<Menu> orderQueue = new LinkedList<Menu>();

    public static void insertOrdertoOrderQueue(Menu orderedMenu){
        orderQueue.add( orderedMenu );
    }
    public static Queue<Menu> getOrderQueue(){
        return orderQueue;
    }
}

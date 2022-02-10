package mission1;

import java.util.LinkedList;
import java.util.Queue;

public class Barista {
    private static Queue<Menu> workQueue = new LinkedList<Menu>();

    Barista(){}
    public static int availableNumberOfBarista(){
        return 2;
    }

    public static void addBaristaQueue(Menu orderedMenu){
        workQueue.add( orderedMenu );
    }
}
ㄴ
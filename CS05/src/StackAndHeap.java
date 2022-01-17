import java.util.ArrayList;

public class StackAndHeap {

    //public Array<String> stackAndHeapList ;
    public String[] stackAndHeapList ;

    private final String stackBaseAddressPointer;
    public int stackCurrentAddressPointer;

    private int heapBaseAddressPointer;
    public int heapCurrentAddressPointer;


    StackAndHeap(int stackSize, int heapSize) {
        stackAndHeapList  = new String[stackSize + heapSize];
        stackBaseAddressPointer = getAddress();
        stackCurrentAddressPointer = 0;
        heapBaseAddressPointer = stackSize;
        heapCurrentAddressPointer = 0;
        System.out.println("stack= "+stackBaseAddressPointer+"\nheap= "+heapBaseAddressPointer);
    }

    public String getAddress(){
        return stackAndHeapList.toString();
    }
//    @Override
//    public String toString(){
//        System.out.println(stackAndHeapList.toString()) ;
//
//        return ""+stackAndHeapList;
//    }
}

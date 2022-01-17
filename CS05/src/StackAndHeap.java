import java.util.ArrayList;

public class StackAndHeap {

    //public Array<String> stackAndHeapList ;
    private String[] stackAndHeapList ;

    private final String stackBaseAddressPointer;
    private String stackCurrentAddressPointer;

    private final String heapBaseAddressPointer;
    private String heapCurrentAddressPointer;

    
    StackAndHeap(int stackSize, int heapSize) {
        stackAndHeapList  = new String[stackSize + heapSize];
        stackBaseAddressPointer = getBaseAddress();
        stackCurrentAddressPointer = stackBaseAddressPointer;
        heapBaseAddressPointer = stackBaseAddressPointer + stackSize;
        heapCurrentAddressPointer = heapBaseAddressPointer;
        System.out.println("stack= "+stackBaseAddressPointer+"\nheap= "+heapBaseAddressPointer);
    }

    public String getBaseAddress(){
        return stackAndHeapList.toString();
    }
//    @Override
//    public String toString(){
//        System.out.println(stackAndHeapList.toString()) ;
//
//        return ""+stackAndHeapList;
//    }
}

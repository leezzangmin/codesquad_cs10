import java.util.HashMap;

public class Memory {

    private StackAndHeap stackAndHeap;
    private int stackSize;
    private int heapSize;
    private static HashMap<String,Integer> typeSize = new HashMap<String,Integer>();


    public String init(int stackSize, int heapSize){
        this.stackSize = stackSize;
        this.heapSize = heapSize;

        stackAndHeap = new StackAndHeap(stackSize,heapSize);

        return stackAndHeap.getBaseAddress();
    }

    public void setSize(String type, int length){

        if (typeSize.containsKey(type)){
            System.out.println("error setSize");
            return;
        }
        if  ( (length==1) || (length==2) || (length==4) || (length==8) || (length==16) || (length==32) ){
            typeSize.put(type,length);
        }
        else{
            System.out.println("error setSize 2");
        }
    }

    public String malloc(String type, int count){
        if (typeSize.get(type)<8){

        }

        return "asdf";
    }

    public void free(String pointer){

    }

    public void call(String name, int paramCount){

    }

    public void returnFrom(String name){

    }

    public String[] usage(){

        return new String[]{"asdf"};
    }

    public String callstack(){

        return "asdf";
    }


    public String[] heapdump(){
        return new String[]{"asdf"};
    }

    public void garbageCollect(){

    }

}

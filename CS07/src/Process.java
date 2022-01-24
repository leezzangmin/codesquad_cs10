public class Process {
    private String processId;
    private String state;
    private int duration;

    Process(String pid,String st, int d){
        this.processId=pid;
        this.state=st;
        this.duration=d;
    }

}

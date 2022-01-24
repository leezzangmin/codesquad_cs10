public class Process {
    public final String processId;
    public String state;
    public final int duration;
    public int elapsedTime;

    Process(String pid,String st, int d){
        this.processId=pid;
        this.state=st;
        this.duration=d;
        this.elapsedTime=0;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString(){
        return processId + "(" + state + "), " + String.valueOf(elapsedTime) +" / " + String.valueOf(duration) +"sec";
    }

}

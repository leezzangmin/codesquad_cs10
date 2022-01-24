public class Process{
    public String processId;
    public String state;
    public int duration;
    public int elapsedTime;
    public myThread[] myThreads;

    Process(String pid,String st, int d){
        this.processId=pid;
        this.state=st;
        this.duration=d;
        this.elapsedTime=0;

        this.myThreads = new myThread[this.duration / 2];
    }

    @Override
    public String toString(){
        return processId + "(" + state + "), " + String.valueOf(elapsedTime) +" / " + String.valueOf(duration) +"sec";
    }


}

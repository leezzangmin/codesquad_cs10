import java.util.*;
public class MAIN {
    public static void main(String[] args){

        System.out.println("---영상클립---");
        ArrayList<Object> collect = new ArrayList();
        for(int i=0;i<13;i++) {
            movie_data_class tmp = new movie_data_class(i+1);
            tmp.print_movie();
            collect.add(tmp);
        }

    }
}

import java.util.Random;
public class movie_data_class {
    private String id;
    private String subject;
    private int duration;
    private String connect;

    private static String[] unique_id = {"abcd","afbc","bdfa","afaf","abab","acdc","bdbd","baaa","cafe","ccef","afcd","fabd","dcba"};
    private static int unique_id_index=0;

    movie_data_class(int _subject){
        this.id = unique_id[unique_id_index++];
        this.subject="제목"+_subject;
        this.connect = null;
        this.duration = generate_random_duration();
    }

    private int generate_random_duration(){
        Random rand = new Random();
        int _duration = rand.nextInt(15)+1;
        return _duration;
    }

    public void print_movie(){
        String temp="";
        temp+=subject;
        temp+="("+id+")"+":";
        temp+=duration;
        System.out.println(temp);
    }

    public String get_id(){
        return id;
    }
    public int get_duration(){
        return duration;
    }
}
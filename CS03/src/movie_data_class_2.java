import java.util.Random;
public class movie_data_class_2 {
    String id;
    String subject;
    int duration;
    String connect;

    static String[] unique_id = {"abcd","afbc","bdfa","afaf",
                                 "abab","acdc","bdbd","baaa",
                                 "cafe","ccef","afcd","fabd","dcba"};
    static int unique_id_index=0;

    movie_data_class_2(int _subject){
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

}
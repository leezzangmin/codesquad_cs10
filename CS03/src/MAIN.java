import java.util.*;
public class MAIN {
    public static void main(String[] args){

        System.out.println("---영상클립---");
        ArrayList<movie_data_class> collect = new ArrayList();
        for(int i=0;i<13;i++) {
            movie_data_class tmp = new movie_data_class(i+1);
            tmp.print_movie();
            collect.add(tmp);
        }

        Scanner input = new Scanner(System.in);
        final int instrucion = 0;
        final int movie_id = 1;
        final int location = 2;
        String[] unique_id = {"abcd","afbc","bdfa","afaf","abab","acdc","bdbd","baaa","cafe","ccef","afcd","fabd","dcba"};
        while(true) {
            linked_list LL= new linked_list();
            String inputLine = input.nextLine();
            String[] userInput = inputLine.split("\\s+");

            if (userInput[instrucion].equals( "add" )){
                LL.insertNode(collect.get(Arrays.asList(unique_id).indexOf(userInput[movie_id])),LL.getSize());
            }
            else if(userInput[instrucion].equals("insert")){

            }
            else if(userInput[instrucion].equals("delete")){

            }
            else if(userInput[instrucion] .equals("render")){

            }
            else if(userInput[instrucion].equals("exit")){
                System.out.println("종료");
                break;
            }
            else{
                System.out.println(userInput[instrucion]+"잘못된 입력");
            }
            LL.print_timeline();
        }

    }
}

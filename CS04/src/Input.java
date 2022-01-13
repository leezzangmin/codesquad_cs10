import java.util.*;
public class Input {
    //private int numberOfArguments;
    //(10,10)-(14,15)
    public Coordinate[] userInput(){
        System.out.println("> 좌표를 입력하세요.");
        Scanner scan = new Scanner(System.in);
        String[] userInput = scan.nextLine()
                                 .replace("(","")
                                 .replace(")","")
                                 .split("-");
        Coordinate[] tmpCoordinate = new Coordinate[ userInput.length ];

        for(int i=0;i<userInput.length;i++){
            String[] tmp = userInput[ i ].split(",");
            int[] coordinates = {Integer.parseInt( tmp[0] ), Integer.parseInt( tmp[1] ) };
            tmpCoordinate[i] = new Coordinate( coordinates[0],coordinates[1] );
        }
        return tmpCoordinate;
    }

    public static boolean isCoordinateValid(Coordinate[] tmp) {
        for(int i=0;i<tmp.length;i++){
            if(tmp[i].getX()<0 || tmp[i].getY()<0) {
                return false;
            }
        }
        return true;
    }
}

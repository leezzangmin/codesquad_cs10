import java.util.*;
public class Input {
    private int numberOfArguments;
//(10,10)-(14,15)
    public Coordinate[] userInput(){
        System.out.println("> 좌표를 입력하세요.");
        Scanner scan = new Scanner(System.in);
        String[] userInput = scan.nextLine()
                                 .replace("(","")
                                 .replace(")","")
                                 .split("-");
        numberOfArguments = userInput.length;
        Coordinate[] tmpCoordinate = new Coordinate[ numberOfArguments ];

        for(int i=0;i<userInput.length;i++){
            String[] tmp = userInput[ i ].split(",");
            int[] coordinates = {Integer.parseInt( tmp[0] ), Integer.parseInt( tmp[1] ) };
            tmpCoordinate[i] = new Coordinate( coordinates[0],coordinates[1] );
        }
        return tmpCoordinate;
    }

    public static boolean isCoordinateValid(int X, int Y) {
        if(0<=X && X<=24 && 0<=Y && Y<=24){
            return true;
        }
        return false;
    }

    public int getNumberOfArguments(){
        return numberOfArguments;
    }
}

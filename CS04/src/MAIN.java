public class MAIN {
    public static void main(String[] args){
        System.out.println("> 좌표를 입력하세요.");
        Input terminal = new Input();
        Coordinate[] MainCoordinate = terminal.userInput();
        if ((terminal.getNumberOfArguments())==1){
            System.out.println("인자"+terminal.getNumberOfArguments());
        }
        else if((terminal.getNumberOfArguments())==2){
            System.out.println("인자"+terminal.getNumberOfArguments());
        }
        else if((terminal.getNumberOfArguments())==3){
            System.out.println("인자"+terminal.getNumberOfArguments());
        }
        else if((terminal.getNumberOfArguments())==4){
            System.out.println("인자"+terminal.getNumberOfArguments());
        }
        else if((terminal.getNumberOfArguments())==5){
            System.out.println("인자"+terminal.getNumberOfArguments());
        }


//        for(int i = 0; i < terminal.getNumberOfArguments(); i++){
//            if ( Input.isCoordinateValid(
//                    MainCoordinate[i].getX(), MainCoordinate[i].getY())){
//
//            }
//        }
    }
}

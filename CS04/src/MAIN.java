public class MAIN {
    public static void main(String[] args){

        Input terminal;
        Coordinate[] MainCoordinate;
        while (true) {
            terminal = new Input();
            MainCoordinate = terminal.userInput();
            if (terminal.getNumberOfArguments() <= 1 &&
                    terminal.getNumberOfArguments() > 6) {
                continue;
            }
            break;
        }

        if ((terminal.getNumberOfArguments()) == 2) {
            System.out.println(
                Calculator.distanceOfTwoCoordinates(MainCoordinate)
                );
        }
        else if ((terminal.getNumberOfArguments()) == 3) {
            System.out.println("인자" + terminal.getNumberOfArguments());
        }
        else if ((terminal.getNumberOfArguments()) == 4) {
            System.out.println("인자" + terminal.getNumberOfArguments());
        }
        else if ((terminal.getNumberOfArguments()) == 5) {
            System.out.println("인자" + terminal.getNumberOfArguments());
        }


//        for(int i = 0; i < terminal.getNumberOfArguments(); i++){
//            if ( Input.isCoordinateValid(
//                    MainCoordinate[i].getX(), MainCoordinate[i].getY())){
//
//            }
//        }

    }
}


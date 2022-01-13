public class MAIN {
    public static void main(String[] args){

        //모든 객체가 같은 인터페이스를 갖도록 계산과 관련된 메시지를 추상화한다. ?

        Input terminal;
        Coordinate[] MainCoordinate;

        while (true) {
            terminal = new Input();
            MainCoordinate = terminal.userInput();
            if (MainCoordinate.length <= 1 ||
                    6<=MainCoordinate.length  ||
                    !(Input.isCoordinateValid(MainCoordinate)) ) {
                continue;
            }
            break;
        }

        if ((MainCoordinate.length) == 2) {
            Line l1 = new Line(MainCoordinate);
            System.out.println(l1.getDistance(0,1));
        }
        else if ((MainCoordinate.length) == 3) {
            Line t1 = new Triangle(MainCoordinate);
            System.out.println(t1.getArea());
        }
        else if ((MainCoordinate.length) == 4) {
            Line s1 = new Square(MainCoordinate);
            System.out.println(s1.getArea());
        }
        else if ((MainCoordinate.length) == 5) {
            return;
        }
    }
}


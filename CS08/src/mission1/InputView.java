package mission1;

import java.util.Scanner;

public class InputView {
    static Scanner sc = new Scanner(System.in);

    public static String[] userInput(){
        return sc.next().split(":");
    }
}

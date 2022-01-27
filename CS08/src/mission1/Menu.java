package mission1;

import java.util.HashMap;
import java.util.*;

public class Menu {
    private static String[] menus = {"아메리카노","카페라떼","프라푸치노"};
    private static Map<String,Integer> menuBoard =
            new HashMap<String,Integer>(){{
                put("아메리카노", 3);
                put("카페라떼", 5);
                put("프라푸치노", 10);
            }};

    private String menuName;
    private int menuDuration;

    Menu(String menuName, int menuDuration){
        this.menuName = menuName;
        this.menuDuration = menuDuration;
        menuBoard.put(this.menuName,this.menuDuration);
    }




    public static int getMenuDuration(String menuName){
        return menuBoard.get(menuName);
    }

}
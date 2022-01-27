package mission1;

import java.util.HashMap;
import java.util.*;

public class Menu {
    private String menuName;
    private int duration;
    ArrayList<Integer> list = new ArrayList<Integer>();

    private static ArrayList<String> menuList
            = new ArrayList<>(Arrays.asList("아메리카노","카페라떼","프라푸치노"));

    private static Map<String,Integer> menuBoard =
            new HashMap<String,Integer>(){{
                put("아메리카노", 3);
                put("카페라떼", 5);
                put("프라푸치노", 10);
            }};

    public Menu(String name){
        this.menuName = name;
        this.duration = getMenuDuration(name);
    }

    public Menu getMenu(String menuName){
        return new Menu(menuName);
    }

    private static String indexToMenuName(int index){
        return menuList.get(index - 1);
    }

    public static int getMenuDuration(String idx){
        String menuName = indexToMenuName(Integer.parseInt(idx));
        return menuBoard.get(menuName);
    }

}
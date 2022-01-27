package mission1;

import java.util.Iterator;

public class OutputView {
    private static final String menuList =
            "> 메뉴  =  1. 아메리카노(3s)    2. 카페라떼(5s)    3. 프라프치노(10s)";
    private static final String orderAnnouncement =
            "> 주문할 음료를 입력하세요. 예) 아메리카노 2개 => 1:2";
    private static final String finishAnnouncement =
            "모든 메뉴가 완성되었습니다.";



    public static void showMenuList(){
        System.out.println(menuList);
    }

    public static void showOrderAnnouncement(){
        System.out.println(orderAnnouncement);
    }

    public static void showOrderQueue(){
        Iterator iter = OrderQueue.getOrderQueue().iterator();
        String message = "/";
        while(iter.hasNext()) {
            message+=iter.next()+",";
        }
        message+="/";
        System.out.println(message);
    }

    public static void printFinish(){
        System.out.println(finishAnnouncement);
    }

}

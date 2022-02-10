package mission1;

//import java.awt.Menu;

public class SonNim {
    private static final int menuIndex = 0;
    private static final int quantityIndex = 1;

    public static void Order(String[] menu){
        Cashier.receiveOrder(
                new Menu(menu[menuIndex]), Integer.parseInt( menu[quantityIndex] ));
    }
}

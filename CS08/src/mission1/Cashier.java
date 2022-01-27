package mission1;

public class Cashier {
    private static final int menuIndex = 0;
    private static final int quantityIndex = 1;

    public static void receiveOrder(Menu orderedMenu, int quantity){
        for(int i = 0; i < quantity; i++){
            OrderQueue.insertOrdertoOrderQueue( orderedMenu );
        }

    }
}

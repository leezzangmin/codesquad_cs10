public class Coordinate {
    private int X;
    private int Y;

    Coordinate(int toX, int toY){
        this.X=toX;
        this.Y=toY;
        System.out.printf("%d %d\n",toX,toY);
    }

    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }
}

public class Square extends Line{

    private double area;
    @Override
    protected double getArea() {
        int width;
        int height;
        return 0.0;
    }

    private boolean isValidSquare(Coordinate[] Coordinates){
        return true;
    }

    Square(Coordinate[] Coordinates){
        this.Coordinates = Coordinates;
        if (isValidSquare(this.Coordinates)){
            area = getArea();
        }
        else {
            area = - 999;
        }
    }

    Square(int height, int width){
        area = (double)height * width;
    }
}

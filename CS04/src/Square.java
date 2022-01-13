public class Square extends Line{

    @Override
    public double calcArea() {
        int width;
        int height;
        return 29.0;
    }

    @Override
    public double getArea(){
        return this.area;
    }

    private boolean isValidSquare(Coordinate[] Coordinates){
        return true;
    }

    Square(Coordinate[] Coordinates){
        this.Coordinates = Coordinates;
        if (isValidSquare(this.Coordinates)){
            this.area = calcArea();
        }
        else {
            this.area = - 999;
        }
    }

    Square(int height, int width){
        this.area = (double)height * width;
    }



}

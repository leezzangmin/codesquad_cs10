public class Line implements Dagakhyeong{
    protected double area;
    protected Coordinate[] Coordinates;

    @Override
    public double getDistance(int indexOfCoordinate_1,int indexOfCoordinate_2) {
        // 두 점 사이의 거리 : 루트( (x2-x1)^2 + (y2-y1)^2 )
        double distance = 0.0;
        distance =
                Math.sqrt(
                    Math.pow(Coordinates[indexOfCoordinate_1].getX() - Coordinates[indexOfCoordinate_2].getX(),2)
                    +
                    Math.pow(Coordinates[indexOfCoordinate_1].getY() - Coordinates[indexOfCoordinate_2].getY(),2)
                );
        return distance;
    }

    @Override
    public double calcArea(){
        return 0.0;
    }

    public double getArea(){
        return area;
    }



    Line(Coordinate[] Coordinates){
        this.Coordinates = Coordinates;
    }

    Line(){
        this.Coordinates = null;
    }
}

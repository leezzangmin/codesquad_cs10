public class Calculator{

    public static double distanceOfTwoCoordinates(Coordinate[] Coordinates){
        // 두 점 사이의 거리 : 루트( (x2-x1)^2 + (y2-y1)^2 )
        double distance=0.0;
        distance =Math.sqrt(
                Math.pow(Coordinates[0].getX() - Coordinates[1].getX(),2)
                +
                Math.pow(Coordinates[0].getY() - Coordinates[1].getY(),2)
        );

        return distance;
    }

    public static double getAreafromTriangle(Coordinate[] Coordinates){
        double area = 29.0;

        return area;
    }

}

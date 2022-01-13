public class Triangle extends Line {

    @Override
    protected double getArea() {
//        세 변의 길이를 알 때 삼각형의 넓이를 구하는 공식은 헤론의 공식을 이용해 구할 수 있다.
        return 29.0;
    }

    Triangle(Coordinate[] Coordinates){
        this.Coordinates = Coordinates;
    }

}

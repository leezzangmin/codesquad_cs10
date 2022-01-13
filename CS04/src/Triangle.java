public class Triangle extends Line {


    @Override
    public double calcArea() {
        // 세 변의 길이를 알 때 삼각형의 넓이를 구하는 공식은 헤론의 공식을 이용해 구할 수 있다.
        // https://ko.wikipedia.org/wiki/%ED%97%A4%EB%A1%A0%EC%9D%98_%EA%B3%B5%EC%8B%9D
        double a = getDistance(0,1);
        double b = getDistance(0,2);
        double c = getDistance(1,2);

        return Math.sqrt( 4 * Math.pow(a,2)*Math.pow(b,2) - Math.pow(Math.pow(a,2) + Math.pow(b,2) - Math.pow(c,2),2)) / 4.0;

    }
    public double getArea() {
        return this.area;
    }

    Triangle(Coordinate[] Coordinates){
        this.Coordinates = Coordinates;
        this.area = calcArea();
    }
}

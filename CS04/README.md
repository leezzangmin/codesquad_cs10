# 코드스쿼드 CS04


> ## 객체지향 설계 :
> * Dagakhyeong(다각형) 인터페이스를 Line 클래스가 implements 한다.
> * 삼각형 이상의 클래스는 Line 클래스를 상속받는다.
> * Main 에서 유저의 입력을 처리해서 if 문 안에 입력받은 좌표 갯수로 분기하여 Line asdf = new Triangle(); 이나 Line asdf = new Square(); 과 같이다형성을 구현했다.
> * 구현하고 나니 다각형 인터페이스를 차라리 추상 클래스로 설계하는 것이 나았겠다는 생각이 든다.
> * 객체별 좌표는 Coordinate 배열로 처리한다.
> * input, output, validate, test, factory 등은 아직 신경쓰지 않았다.

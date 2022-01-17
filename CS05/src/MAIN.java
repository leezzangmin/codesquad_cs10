//        프로그램에서 처리하는 모든 포인터 메모리 사이즈는 4바이트 단위(크기)로 처리한다.
//        프로그래밍 요구사항 에 나와있는 함수들을 구현한다.
//        각 함수 동작을 확인하기 위해 특정한 시나리오대로 동작하는 프로그램을 별도 파일로 작성한다.
//        다양한 경우에 대한 동작을 확인하기 위한 시나리오 흐름은 스스로 결정한다
//        함수 내부에서 출력하지말고, 함수에서 return 한 값을 호출한 프로그램에서 출력한다.
public class MAIN {

    public static void main(String[] args){

        Memory m = new Memory();
        String baseAddress = m.init(1024,1024);
        System.out.println("Base Address = " + baseAddress);
        m.setSize("int",4);

    }

}

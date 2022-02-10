

/*
HTTP Request 규격을 처리하는 라이브러리 모듈 또는 클래스를 구현한다.
기존에 제공하는 HTTP Request 모듈이나 클래스를 사용하면 안된다.
매개변수로 URL을 넘겨서 Request 객체를 생성한다.
요청 방식을 변경하기 위해서 method를 바꿀 수 있다. 기본값은 GET 메소드로 생성한다.
요청에 필요한 Header를 추가할 수 있다.
전송하기 위해 Request Message를 문자열로 return하는 메소드를 구현한다.
*/

/*
URL 정보를 바탕으로 HTTP Request 객체를 생성하고, Request 메시지를 TCP 세션에 전송(send)한다.
소켓을 생성해서 요청을 보내고 응답을 받아서 처리하는 동작을 구현한다.

서버가 HTTP Reqeust를 인식하기 위한 필수 헤더로 구성한다. (어떤 헤더가 필요한가 학습해서 추가한다.)
 */


//import org.omg.CORBA.Request;

import org.omg.CORBA.*;
import org.omg.CORBA.Object;

import java.io.IOException;
import java.net.URL;

public class HTTPRequest {

    String requestLine = "";
    String requestHeaders = "";
    String requestBody = "";

    String requestMethod = "GET";

    String requestMessage = "";

    HTTPRequest(URL url) throws IOException {
        System.out.println(url.getHost()+"asdf");
    }

    public void AddHeader(){

    }

    public String getRequestMessage(){
        return "requestMessage";
    }

}

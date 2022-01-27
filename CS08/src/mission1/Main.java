package mission1;//콘솔에서 동작하는 프로그램을 작성한다.
//
//지금까지 미션들에서 학습했던 다양한 패턴, 응용 방식을 활용해서 비동기로 동작하도록 작업한다.
//
//다음 요구사항에 나오는 구성 요소들을 객체나 모듈로 구분해서 구현한다.
//
//동기 함수들 보다 비동기 함수를 중심으로 구현한다.

import java.util.*;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args){
        CompletableFuture<String> future
                = new CompletableFuture<>();
        System.out.println('a');
    }
}

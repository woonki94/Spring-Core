package hello.core.singleton;

public class SingletonService {

     //1.static 영역에 객체 딱 1개만 생성
    private static final SingletonService instance = new SingletonService(); //자바 static영역 공부
    //public으로 열어서
    public static SingletonService getInstance(){
        return instance;
    }
    //생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 막음

    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}

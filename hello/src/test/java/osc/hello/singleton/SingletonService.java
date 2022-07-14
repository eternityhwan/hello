package osc.hello.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    // 자기 자신을 내부에 private로 선언하고 static을 선언하면 클래스레벨에 올라가니 딱 하나만 존재해
    // 이렇게 만들어 놓으면 자바 뜰 때 jvm이 만들어질 때 static 영역에 new SingletonService를 instance 참조로 넣어놓음
    // 자기 자신 인스턴스 만들어서 하나 가지고 있는거지
    // instance의 참조를 꺼낼 수 있는 방법은 new SingletonService() 뿐이다.
    public static SingletonService getInstance() {
        return instance;
        // 객체를 조회할 때 i
    }
    private SingletonService() {
        // ??? : 아무리 싱글톤 만들어도 아래처럼 객체 생성하면 끝나느거 아님? 이럴 수 있는데
        // private 로 막아놓으면 클래스 내부에서는 만들 수 있어도 클래스 외부에서는 객체 생성이 안돼.
    }
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
//    public static void main(String[] args) {
//        SingletonService singletonService1 = new SingletonService();
//        SingletonService singletonService2 = new SingletonService();
//
//    }
}

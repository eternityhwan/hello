package osc.hello.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //ThreadB: B사용자 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        // TreadA: 사용자A 주문 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice);

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
        // A가 주문을 10000원 주문했는데 20000원이 결제된거다. 이건 큰일인거야.
        // 하나의 객체를 사용하니 발생하는 일인거지.
        //-- price 필드는 공유 필드인데, 특정 클라이언트가 값을 변경한다.
        // 공유되지않는 파라미터, 지역변수로 갈음하면 된다.
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
package osc.hello.BeanDefinition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import osc.hello.AppConfig;

public class BeanDefinitionTest {

//    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    // 스프링 쓰려면 스프링 컨테이너를 먼저 가져온다.
    // BeanDefinition 정보를 직접 가져오는 경우는 거의 없다.
    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appconfig.xml");

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 겟빈데피니션네임스 메서드가 있음. 스프링컨테이너에게 겟빈데피니션네임 메서드를 써서 왼쪽 객체에 저장하라는 뜻이지.
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); // getBeanDefinition은 ApplicationContext 클래스를 못 받음

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefinitionName + " beanDefinition = " + beanDefinitionName);
            }
            // beanDefinitionName에 앱컨피그에 있는 애들을 다 출력한다.
        }
    }
}

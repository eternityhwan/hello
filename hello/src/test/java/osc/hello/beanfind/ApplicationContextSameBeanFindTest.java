package osc.hello.beanfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import osc.hello.AppConfig;
import osc.hello.discount.DiscountPolicy;
import osc.hello.member.MemberRepository;
import osc.hello.member.MemoryMemberRepository;

import java.util.Map;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);
    // 스프링 컨테이너 가져와야 빈 가져오지

    @Test
    @DisplayName("같은 타입으로 조회 시 같은 타입이 둘 이상 있으면 , 중복 오류가 발생한다.")
    void findBeanByTypeDuplicate() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(MemberRepository.class));
    } // 오른쪽 로직을 던졌을 때 터져야 제대로된 테스트.

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다")
    void findBeanByName() {
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
        // 유니크 타입 에러가 나지 않게하려면 Bean 객체 이름을 지정해주면 된다.
        org.assertj.core.api.Assertions.assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType() {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        org.assertj.core.api.Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    static class SameBeanConfig {

        // 빈의 이름이 다르고 객체가 똑같은 경우가 있을 수 있지지
        // NoUniqueBeanDefinitionException 뜬다,
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository(); // <-- 파라메터를 다르게 받을 수는 있지만 1,2는 같은 빈인거지.
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }

}

package osc.hello;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 컴포넌트스캔 필터 = 자동등록 중 뺄 것들 지정임, @Configuration 지정해놓은 그러니까 수동 주입된 빈들 스캔 안되게 필터 거는거야
// 컴포넌트 스캔 쓰고싶으면 먼저 @ComponentScan을 설정 정보에 붙여주면 된다. 컴포넌트스캔 어노테이션 들어가보면 @Configuration붙은 애들도 자동주입한다.
// 실무에서는 안그래도 돼.
@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

}

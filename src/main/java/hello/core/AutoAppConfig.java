package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(
        basePackages = "hello.core"  //탐색할 패키지의 시작 위치를 지정.  Component Scan이 모든 프로젝트를 검색할경우 오래걸림, 특정 패키지만 탐색가능
        ,excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //예제 코드를 살리기 위해 @Configuration 제외

)
public class AutoAppConfig {
/***
    @Bean(name ="memoryMemberRepository") //@Configuration이 자동 등록 하는 빈과 같은 이름의 빈 등록 -> 수동 빈이 우선권을 갖는다. 현재 default는 중복되면 오류나도록
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

*/

}

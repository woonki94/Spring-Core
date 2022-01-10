package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    /***생성자 주입
     * 어떤 구현 객체가 들어올지는 APPConfig에 의해서만 결정된다.
     * */

    //@Bean memberService-> new MemoryMemberRepository();
    //@Bean orderService-> new OrderServiceImpl(- > new MemoryMemberRepository()  두번 호출됨.... singleton이 깨지는것은 아닐까


    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());

    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());

    }
    @Bean
    public DiscountPolicy discountPolicy(){
       // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}

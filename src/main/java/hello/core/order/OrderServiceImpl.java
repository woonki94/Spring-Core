package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;

    /***
     할인 정책을 바꾸려면 orderServiceImpl의 코드 또한 변경해야 한다. ...OCP위반
     클래스 의존관계를 분석해보면 추상 뿐만아니라 구체에도 의존하고 있다...  DIP위반
     구체에는 의존하지 않고 인터페이스에만 의존하게 설계해야함
     */
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    /***인터페이스에만 의존할 수 있도록 설계 ----  구체가 없어 nullpointException error
    누군가 OrderServiceImpl 에 discountPolicy의 구현 객체를 대신 생성하고 주입해야함. --> springFrameWork
     */
     private final DiscountPolicy discountPolicy;

     //@RequiredArgsConstructor 이 자동 생성
/**
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
*/
    @Override
    public Order createOrder(long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}

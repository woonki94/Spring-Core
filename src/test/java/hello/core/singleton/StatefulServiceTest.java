package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    
    @Test
    void StatefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
        
        //ThreadA : A사용자 10000원 주문
        int price =  statefulService1.order("usrA ", 10000);
        //ThreadB : B사용자 20000원 주문
        statefulService2.order("usrB ", 20000);

        //int price = statefulService1.getPrice();
        //price = 20000 출력 됨
        //System.out.println("price = " + price);

        Assertions.assertThat(price).isEqualTo(10000);
    }
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
        
    }

}
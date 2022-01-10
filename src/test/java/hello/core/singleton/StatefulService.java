package hello.core.singleton;

public class StatefulService {
   // private int price; //상태를 유지하는 필드

    int order(String name, int price){
        System.out.println("name = " + name + "price = " +price);
       // this.price = price;
        return price;  //지역 변수므로 사용자 A 사용자B의 price가 달라짐
    }

    //public  int getPrice(){
    //    return price;
    //}

}

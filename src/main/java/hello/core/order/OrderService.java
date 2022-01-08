package hello.core.order;

public interface OrderService {
    Order createOrder(long memberId, String itemName, int Price);
}

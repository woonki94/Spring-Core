package hello.core.order;

public class Order {
    private long memberId;
    private String ItemName;
    private int itemPrice;
    private int discountPrice;

    public Order(long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        ItemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }



    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }
    public int CalculatePrice(){
        return itemPrice - discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", ItemName='" + ItemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}

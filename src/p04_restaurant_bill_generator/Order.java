package p04_restaurant_bill_generator;

public class Order {
    public static int count=999;//1000//1001
    public int orderCode;
    public int numberOfDish;
    public Dish dish;
    public double orderPrice;

    public Order(Dish dish,int numOfOrder) {
        count++;
        this.orderCode = count;
        this.numberOfDish = numOfOrder;
        this.dish = dish;

    }
    public void setPrice(){
        this.orderPrice=this.dish.getPrice()*this.numberOfDish;
    }
}

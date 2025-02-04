import java.util.*;

public class HotDogStandWilson {
    public static void main(String[] args) throws Exception {
        HotDogStand test = new HotDogStand(2155911, "Wilson", "123 Main St", 0, 2, 3);
        System.out.println(test.toString());
    }
}

class HotDogStand {
    private int id;
    private String owner;
    private String address;
    private int countSold;
    private int price;
    private int soldPrice;

    public HotDogStand(int id, String owner, String address, int countSold, int price, int soldPrice) {
        this.id = id;
        this.owner = owner;
        this.address = address;
        this.countSold = countSold;
        this.price = price;
        this.soldPrice = soldPrice;
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }
    public String getAddress() {
        return address;
    }

    public int getCountSold() {
        return countSold;
    }

    public int getPrice() {
        return price;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void order(int count) {
        this.countSold += count;
    }

    public double income() {
        return this.countSold * this.soldPrice;
    }

    public String toString() {
        return String.format(
                "Station Number: %1$8d\nOwner: %2$s\nAddress: %3$s\nAddress: %4$s\nHot Dogs Sold: %5$s\nIncome: %6$#.2f\n", this.id, this.owner, this.address, this.countSold, this.soldPrice, this.income());
    }
}

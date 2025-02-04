import java.util.*;

/**
 * Name class. Will be blank.
 */
public class HotDogStandWilson {
    public static void main(String[] args) throws Exception {
        HotDogStand test = new HotDogStand(2155911, "Wilson", "123 Main St");
        System.out.println(test.toString());
    }
    // Empty class
}

/**
 * HotDogStand class, main class in project. Tracks HotDogStand objects with
 * variables id, owner, address, countSold, price, and soldPrice. Has setters,
 * getters, and toString. More hot dogs can be ordered (adds to sales).
 */
class HotDogStand {

    public static int price = 10;
    public static int soldPrice = 12;
    /**
     * Instance variables.
     */
    private int id;
    private String owner;
    private String address;
    private int countSold;

    /**
     * Constructor for HotDogStand.
     * 
     * @param id
     * @param owner
     * @param address
     */

    public HotDogStand(int id, String owner, String address) {
        this.id = id;
        this.owner = owner;
        this.address = address;
        this.countSold = 0;
    }

    /**
     * Getters and setters.
     * 
     * @return id, owner, address, countSold, price
     */
    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public int getCountSold() {
        return countSold;
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

    /**
     * Special getter. Calculates income based on difference between aquisition and
     * sale, multiplied by count sold.
     * 
     * @return income
     */
    public double income() {
        return this.countSold * (soldPrice - price);
    }

    /**
     * toString method.
     * 
     * @return formatted string in human-readable format. Underscores included for
     *         your convenience. :)
     */
    public String toString() {
        return String.format(
                "Station Number: %08d\nOwner: %s\nAddress: %s\nHot Dogs Sold: %d\nIncome: %.2f\n%s\n",
                this.id, this.owner, this.address, this.countSold, this.income(), "_".repeat(47));
    }
}

/**
 * YourDriver class. Contains tests specified by assignment.
 */
class YourDriver {
    /**
     * Creates three HotDogStand objects with random unique IDs, orders a random
     * number of hot dogs between 200 and 500 for each stand, adds total sold, finds
     * income, and prints.
     * 
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Creates a Random object, generates three unique IDs for HotDogStand objects.
         */
        Random rand = new Random();

        int n1 = rand.nextInt(9999999) + 99999;
        int n2 = rand.nextInt(9999999) + 99999;
        int n3 = rand.nextInt(9999999) + 99999;
        while (n2 == n1) {
            n2 = rand.nextInt(9999999) + 99999;
        }
        while (n3 == n1 || n3 == n2) {
            n3 = rand.nextInt(9999999) + 99999;
        }

        /**
         * Creates HotDogStand objects with IDs.
         */
        HotDogStand stand1 = new HotDogStand(n1, "Wilson", "Sonoma");
        HotDogStand stand2 = new HotDogStand(n2, "Wilson", "Napa");
        HotDogStand stand3 = new HotDogStand(n3, "Wilson", "Tracy");

        /**
         * Orders a random number of hot dogs between 200 and 500 for each stand.
         */
        stand1.order(rand.nextInt(301) + 200);
        stand2.order(rand.nextInt(301) + 200);
        stand3.order(rand.nextInt(301) + 200);

        /**
         * Calculates total sold and income.
         */
        int totalSold = stand1.getCountSold() + stand2.getCountSold() + stand3.getCountSold();
        double totalIncome = stand1.income() + stand2.income() + stand3.income();

        /**
         * Prints each stand's toString, total sold, and total income.
         */
        System.out.println(stand1.toString());
        System.out.println(stand2.toString());
        System.out.println(stand3.toString());
        System.out.println(String.format("Total hotdogs sold: %d\n%s", totalSold, "_".repeat(47)));
        System.out.println(String.format("Total income: %.2f\n%s", totalIncome, "_".repeat(47)));
    }
}

/**
 * MyDriver class. Contains test scripts pre-written by instructor.
 */
class MyDriver {
    public static void main(String[] args) {
        Random rand = new Random();
        // creating three objects
        HotDogStand stand1 = new HotDogStand(rand.nextInt(9999999) + 99999, "Jose", "Folsom");
        HotDogStand stand2 = new HotDogStand(rand.nextInt(99999999) + 99999, "Jose", "Rocklin");
        HotDogStand stand3 = new HotDogStand(rand.nextInt(99999999) + 99999, "Jose", "Folsom");

        // ordering hot dogs at different stand
        stand1.order(100);
        stand2.order(150);
        stand3.order(175);

        // claculating the income form the stations
        double stand1Income = stand1.income();
        double stand2Income = stand2.income();
        double stand3Income = stand3.income();

        // getting the total number of the hotdogs orderd at all the stations
        int total = stand1.getCountSold() + stand2.getCountSold() + stand3.getCountSold();
        double totalIncome = stand1.income() + stand2.income() + stand3.income();

        // displaying the info
        System.out.println(stand1);
        System.out.println("_______________________________________________");
        System.out.println(stand2);
        System.out.println("_______________________________________________");
        System.out.println(stand3);
        System.out.println("________________________________________________");
        System.out.println("Total hotdogs sold at all the stations: " + total);
        System.out.println("________________________________________________");
        System.out.println("Total income: " + totalIncome);

    }
}
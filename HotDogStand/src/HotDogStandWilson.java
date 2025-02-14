
/**
 * Name: Kali Wilson
 * Description: This program lets you manage hot dog stands and view their owners, addresses, hot dogs sold, and total profit. You can also change the owner of a stand, and find out how much you make as the manager (30% of the total profit).
 * Date: 2025/02/04
 * Self-Grade: 100 points. All names follow convention, code is indented, formatted, and human-readable, comments and JavaDoc included. Program compiles, runs both main methods (MyDriver and YourDriver). with expected output. All requirements in assignment are met. Self grade is included.
 * Testimony: All the code is written by myself and I have not copied the code from any resources. Kali Wilson
 */

import java.util.*;

/**
 * Name class.
 */
public class HotDogStandWilson {
    /**
     * Empty class.
     */
}

/**
 * HotDogStand class, main class in project. Static variables include TreeMaps
 * to hold objects and owners to IDs, the price and soldPrice. Tracks
 * HotDogStand objects with variables id, owner, address, and countSold. Has
 * setters, getters, and toString. More hot dogs can be ordered (adds to sales).
 */
class HotDogStand {

    /**
     * Static variables. TreeMap used to store all stands.
     */
    public static TreeMap<Integer, HotDogStand> allStands = new TreeMap<Integer, HotDogStand>();
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
     * Refuses object creation of given ID is a duplicate.
     * 
     * @param id
     * @param owner
     * @param address
     */

    public HotDogStand(int id, String owner, String address) {
        if (allStands.containsKey(id)) {
            System.out.println(
                    "Sorry, I couldn't create that. A HotDogStand object with the same ID already exists. Modify that one or dismantle it first.\n");
            return;
        }
        {
            this.id = id;
            this.owner = owner;
            this.address = address;
            this.countSold = 0;
            allStands.put(id, this);
        }
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
     * Special getter. Calculates getIncome based on difference between aquisition and
     * sale, multiplied by count sold.
     * 
     * @return getIncome
     */
    public double getIncome() {
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
                this.id, this.owner, this.address, this.countSold, this.getIncome(), "_".repeat(47));
    }

    /**
     * search method. Returns all stands owned by a given owner.
     * 
     * @param owner
     * @return formatted string of all stands owned by given owner.
     */
    public static String search(String owner) {
        String result = String.format("Hot dog stands owned by %1$s:\n", owner);
        for (Map.Entry<Integer, HotDogStand> entry : allStands.entrySet()) {
            if (entry.getValue().getOwner().equals(owner)) {
                result += String.format("ID: %1$d\n", entry.getKey());
            }
        }
        return result + String.format("%s\n", "_".repeat(47));
    }

    /**
     * yourProfit method. Any good entrepreneur needs to mke a profit. Returns 30%
     * of the total profit between all of the stands, and gives it to you!
     * 
     * @return
     */
    public static double yourProfit() {
        double totalProfit = 0.0;
        for (Map.Entry<Integer, HotDogStand> entry : allStands.entrySet()) {
            totalProfit += entry.getValue().getIncome() * 0.3;
        }
        return totalProfit;
    }

    /**
     * query function. Similar to toString, but returns based on ID passed as
     * Integer, even without an object reference. Will return an apology (I'll make
     * it more profuse next time) if the ID does not exist.
     * 
     * @param id
     * @return toString of HotDogStand object with given ID.
     */
    public static String query(int id) {
        if (allStands.containsKey(id)) {
            return allStands.get(id).toString();
        }
        return "Sorry, I couldn't find that. A HotDogStand object with the given ID does not exist. I'm very sorry.\n";
    }

    /**
     * dismantle function. Discards HotDogStand object with given ID, removes it
     * from the TreeMap.
     * 
     * @param id
     */
    public static void dismantle(int id) {
        allStands.remove(id);
    }

    /**
     * dismantle function overloaded. Discards HotDogStand object passed as
     * reference, removes it from the TreeMap. Fuctionally checks the HotDogStand's
     * id variable, calls dismantle with that.
     * 
     * @param stand
     */
    public static void dismantle(HotDogStand stand) {
        dismantle(stand.getId());
    }
}

/**
 * YourDriver class. Contains tests specified by assignment.
 */
class YourDriver {
    /**
     * Creates three HotDogStand objects with random unique IDs, orders a random
     * number of hot dogs between 200 and 500 for each stand, adds total sold, finds
     * getIncome, and prints.
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
         * Creates HotDogStand objects with IDs. I've opted to forgo any object
         * declarations outside of the TreeMap, simplifying my calls to referencing key
         * elements from the TreeMap. In fact, you can run this program without ever
         * declaring a HotDogStand object with a symbol, using just .put and .get.
         */
        HotDogStand.allStands.put(n1, new HotDogStand(n1, "Wilson", "Sacramento"));
        HotDogStand.allStands.put(n2, new HotDogStand(n2, "Wilson", "Napa"));
        HotDogStand.allStands.put(n3, new HotDogStand(n3, "Wilson", "Tracy"));

        /**
         * Orders a random number of hot dogs between 200 and 500 for each stand.
         */
        HotDogStand.allStands.get(n1).order(rand.nextInt(301) + 200);
        HotDogStand.allStands.get(n2).order(rand.nextInt(301) + 200);
        HotDogStand.allStands.get(n3).order(rand.nextInt(301) + 200);

        /**
         * Calculates total sold and getIncome.
         */
        int totalSold = 0;
        for (Map.Entry<Integer, HotDogStand> entry : HotDogStand.allStands.entrySet()) {
            totalSold += entry.getValue().getCountSold();
        }
        double totalgetIncome = 0;
        for (Map.Entry<Integer, HotDogStand> entry : HotDogStand.allStands.entrySet()) {
            totalgetIncome += entry.getValue().getIncome();
        }

        /**
         * Prints each stand's toString, total sold, and total getIncome.
         */
        for (Map.Entry<Integer, HotDogStand> entry : HotDogStand.allStands.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
        System.out.println(String.format("Total hotdogs sold: %d\n%s", totalSold, "_".repeat(47)));
        System.out.println(String.format("Total Income: %.2f\n%s", totalgetIncome, "_".repeat(47)));

        /**
         * Searches for all stands owned by Wilson, prints. Finds your profit sa the
         * manager, prints.
         */
        System.out.println(HotDogStand.search("Wilson"));
        System.out.println(String.format("Your profit: %.2f\n%s", HotDogStand.yourProfit(), "_".repeat(47)));

        /**
         * Creates three more HotDogStand objects with random unique IDs, uses query and
         * dismantle.
         */

        int n4 = rand.nextInt(9999999) + 99999;
        int n5 = rand.nextInt(9999999) + 99999;
        int n6 = rand.nextInt(9999999) + 99999;
        HotDogStand.allStands.put(n4, new HotDogStand(n4, "Shane", "SF"));
        HotDogStand.allStands.put(n5, new HotDogStand(n5, "Ross", "LA"));
        HotDogStand.allStands.put(n6, new HotDogStand(n6, "Lowe", "SD"));
        System.out.println(HotDogStand.query(n4));
        HotDogStand.dismantle(n5);
        System.out.println(HotDogStand.query(n5));

        System.out.println("Format strings and maps are awesome, why didn't I learn this sooner?");
    }
}

/**
 * MyDriver class. Contains test scripts pre-written by instructor.
 */
@SuppressWarnings("all")
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

        // claculating the getIncome form the stations
        double stand1Income = stand1.getIncome();
        double stand2Income = stand2.getIncome();
        double stand3Income = stand3.getIncome();

        // getting the total number of the hotdogs orderd at all the stations
        int total = stand1.getCountSold() + stand2.getCountSold() + stand3.getCountSold();
        double totalIncome = stand1.getIncome() + stand2.getIncome() + stand3.getIncome();

        // displaying the info
        System.out.println(stand1);
        System.out.println("_______________________________________________");
        System.out.println(stand2);
        System.out.println("_______________________________________________");
        System.out.println(stand3);
        System.out.println("________________________________________________");
        System.out.println("Total hotdogs sold at all the stations: " + total);
        System.out.println("________________________________________________");
        System.out.println("Total Income: " + totalIncome);

    }
}
/**
 * Name: Kali Wilson
 * Description: A demonstration of polymorphism with the Package class and subclasses. Consists of Package and its subclasses, TwoDayPackage and OvernightPackage, which all calculate prices differently. 
 */

/**
 * Empty name class.
 */
public class PackageWilson {
    /**
     * Empty.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
    }
}

/**
 * Parent class. Holds instance variables and a static cost variable, plus constructor, getters, setters, and toStrings.
 */
class Package {
    /**
     * Instance variables. Senders default to "Nobody".
     */
    private String sendName = "Nobody";
    private String destName;
    private String sendAddress = "Nowhere";
    private String destAddress;
    private String sendCity = "Nowhere";
    private String destCity;
    private String sendState = "NW";
    private String destState;
    private int sendZIP = 0;
    private int destZIP;
    private double weight_ounces;

    /**
     * Static variable for cost.
     */
    public static double cost_ounce = 0.67;

    /**
     * Constructor that takes and stores package information.
     * @param destName
     * @param destAddress
     * @param destCity
     * @param destState
     * @param destZIP
     * @param weight_ounces
     */
    public Package(String destName, String destAddress, String destCity, String destState, int destZIP,
            double weight_ounces) {
        this.destName = destName;
        this.destAddress = destAddress;
        this.destCity = destCity;
        this.destState = destState;
        this.destZIP = destZIP;
        this.weight_ounces = weight_ounces;
    }

    /**
     * Constructor that does same as above, but includes sendar data.
     * @param sendName
     * @param destName
     * @param sendAddress
     * @param destAddress
     * @param sendCity
     * @param destCity
     * @param sendState
     * @param destState
     * @param sendZIP
     * @param destZIP
     * @param weight_ounces
     */
    public Package(String sendName, String destName, String sendAddress, String destAddress, String sendCity,
            String destCity, String sendState, String destState, int sendZIP, int destZIP, double weight_ounces) {
        this.sendName = sendName;
        this.destName = destName;
        this.sendAddress = sendAddress;
        this.destAddress = destAddress;
        this.sendCity = sendCity;
        this.destCity = destCity;
        this.sendState = sendState;
        this.destState = destState;
        this.sendZIP = sendZIP;
        this.destZIP = destZIP;
        this.weight_ounces = weight_ounces;
    }

    /**
     * getSendName
     * @return instance sendName
     */
    public String getSendName() {
        return sendName;
    }

    public String getDestName() {
        return destName;
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public String getDestAddress() {
        return destAddress;
    }

    public String getSendCity() {
        return sendCity;
    }

    public String getDestCity() {
        return destCity;
    }

    public String getSendState() {
        return sendState;
    }

    public String getDestState() {
        return destState;
    }

    public int getSendZIP() {
        return sendZIP;
    }

    public int getDestZIP() {
        return destZIP;
    }

    public double getWeight() {
        return weight_ounces;
    }

    public double calculateCost() {
        return this.weight_ounces * cost_ounce;
    }

    public String getSenderData() {
        if ((sendName != null && sendAddress != null && sendCity != null && sendState != null && sendZIP != 0) && (sendAddress != "Nobody" || sendAddress != "Nowhere" || sendCity != "Nowhere" || sendState != "NW" || sendZIP != 0)) {
            return String.format("From: %1$s\nSent From: %2$s, %3$s, %4$s, %5$05d\n", sendName, sendAddress, sendCity, sendState, sendZIP);
        }
        return "";
    }

    @Override
    public String toString() {
        return String.format("%1$sTo: %2$s\nDestination: %3$s, %4$s, %5$s %6$05d\nWeight (oz): %7$.2f\nCost to ship (per oz): $%8$.2f\nBasic price to ship: $%8$.2f", this.getSenderData(), destName,
                destAddress, destCity, destState, destZIP, weight_ounces, cost_ounce, this.calculateCost());
    }
}

class TwoDayPackage extends Package {
    public static double flatfee = 3.5;

    public TwoDayPackage(String destname, String destAddress, String destCity, String destState, int destZIP,
            double weight_ounces) {
        super(destname, destAddress, destCity, destState, destZIP, weight_ounces);
    }

    public TwoDayPackage(String sendName, String destName, String sendAddress, String destAddress, String sendCity,
            String destCity, String sendState, String destState, int sendZIP, int destZIP, double weight_ounces) {
        super(sendName, destName, sendAddress, destAddress, sendCity, destCity, sendState, destState, sendZIP, destZIP,
                weight_ounces);
    }

    public double calculateCost() {
        return flatfee + (super.calculateCost());
    }

    public String toString() {
        return String.format("%1$sBasic price to ship: $%2$.2f\nFlat fee to ship in two days: $%3$.2f\nTotal cost to ship: $%4$.2f", super.toString().substring(0, super.toString().indexOf("Basic price to ship")), super.calculateCost(), flatfee, this.calculateCost());
    }
}

class OvernightPackage extends Package {
    public static double overnightFee = 0.45;

    public OvernightPackage(String destname, String destAddress, String destCity, String destState, int destZIP,
            double weight_ounces) {
        super(destname, destAddress, destCity, destState, destZIP, weight_ounces);
    }

    public OvernightPackage(String sendName, String destName, String sendAddress, String destAddress, String sendCity,
            String destCity, String sendState, String destState, int sendZIP, int destZIP, double weight_ounces) {
        super(sendName, destName, sendAddress, destAddress, sendCity, destCity, sendState, destState, sendZIP, destZIP,
                weight_ounces);
    }

    public double calculateCost() {
        return (overnightFee * super.getWeight()) + (super.calculateCost());
    }

    public String toString() {
        return String.format("%1$sBasic price to ship: $%2$.2f\nOvernight fee (per oz): $%3$.2f\nTotal cost to ship: $%4$.2f", super.toString().substring(0, super.toString().indexOf("Basic price to ship")), super.calculateCost(), overnightFee, this.calculateCost());
    }
}

class Driver {
    public static void main(String[] args) throws Exception {
        Package smith = new Package("John Smith", "1020 Orange St", "Lakeland", "FL", 92317, 3.75);
        TwoDayPackage george = new TwoDayPackage("Bob George", "21 Pine Rd", "Cambridge", "MA", 429024, 3.75);
        OvernightPackage kelly = new OvernightPackage("Don Kelly", "9 Main St", "Denver", "CO", 66456, 3.75);
        TwoDayPackage wilson = new TwoDayPackage("Kali Wilson", "Someone", "6000 J Street", "400 Parnassus Avenue", "Sacramento", "San Francisco", "CA", "CA", 95819, 94143, 8.6);
        System.out.println(smith.toString() + "\n");
        System.out.println(george.toString() + "\n");
        System.out.println(kelly.toString() + "\n");
        System.out.println(wilson.toString());
    }
}
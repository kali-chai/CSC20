public class PackageWilson {
    public static void main(String[] args) throws Exception {
        Package smith = new Package("John Smith", "1020 Orange St", "Lakeland", "FL", 92317, 3.75);
        TwoDayPackage george = new TwoDayPackage("Bob George", "21 Pine Rd", "Cambridge", "MA", 429024, 3.75);
        OvernightPackage kelly = new OvernightPackage("Don Kelly", "9 Main St", "Denver", "CO", 66456, 3.75);
        System.out.println(smith.toString() + "\n");
        System.out.println(george.toString() + "\n");
        System.out.println(kelly.toString() + "\n");
    }
}

class Package {
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

    public static double cost_ounce = 0.67;

    public Package(String destName, String destAddress, String destCity, String destState, int destZIP,
            double weight_ounces) {
        this.destName = destName;
        this.destAddress = destAddress;
        this.destCity = destCity;
        this.destState = destState;
        this.destZIP = destZIP;
        this.weight_ounces = weight_ounces;
    }

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

    @Override
    public String toString() {
        return String.format("To: %1$s\nDestination: %2$s, %3$s, %4$s %5$05d\nWeight (oz): %6$.2f\nCost to ship (per oz): $%7$.2f\nBasic price to ship: $%8$.2f", destName,
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

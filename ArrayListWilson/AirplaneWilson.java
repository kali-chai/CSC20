import java.util.*;
public class AirplaneWilson {
}
class Person {
    private String name;
    private String last;
    private String phone;
    public Person(String name, String last, String phone) {
        this.name = name;
        this.last = last;
        this.phone = phone;
    }
    public void setFirst(String name) {
        this.name = name;
    }
    public void setLast(String last) {
        this.last = last;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getFirst() {
        return name;
    }
    public String getLast() {
        return last;
    }
    public String getPhone() {
        return phone;
    }
    public String toString() {
        return String.format("Name: %1$s\nLast Name: %2$s\nPhone: %3$s\n", this.getFirst(), this.getLast(), this.getPhone());
    }   
    public boolean equals(Person other) {
        return this.name.equalsIgnoreCase(other.name) && this.last.equalsIgnoreCase(other.last);
    }
}
class Passenger extends Person {
    private int seatNumber;
    private String classType;
    private String ticketId;
    public Passenger(String name, String last, String phone, int seatNumber, String classType, String ticketId) {
        super(name, last, phone);
        this.seatNumber = seatNumber;
        this.classType = classType;
        this.ticketId = ticketId;
    }
    public void changeSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    public void setClass(String classType) {
        this.classType = classType;
    }
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
    public int getSeat() {
        return seatNumber;
    }
    public String getClassType() {
        return classType;
    }
    public String getTicketId() {
        return ticketId;
    }
    public String toString() {
        return String.format("%1$s%2$s\nSeat Number: %3$d\nClass Type: %4$s\nTicket ID: %5$s\n", super.toString(), this.getFirst(), this.getSeat(), this.getClassType(), this.getTicketId());
    }
}
interface List {
    public boolean add(Object o);
    public Object search(Object o);
    public boolean delete(Object o);
    public void printLast();
    public void takeOff();
}
class Airplane implements List {
    public static int count = 0;
    private Passenger[] plane;
    private boolean takenOff;
    private int planeNum;
    public Airplane(int PlaneNum) {
        this.planeNum = PlaneNum;
        this.plane = new Passenger[10];
        this.takenOff = false;
    }
    public int getPlaneNum() {
        return planeNum;
    }
    public String toString() {
        String ret = "";
        for(int i = 0; i < plane.length; i++) {
            if (plane[i] != null) {
                ret += plane[i].toString() + "\n";
            }
        }
        return ret;
    }
    public static int getCount() {
        return count;
    }
    public boolean add(Object o) {
        if (o instanceof Passenger) {
            Passenger p = (Passenger) o;
            for (int i = 0; i < plane.length; i++) {
                if (plane[i] == null) {
                    plane[i] = p;
                    count++;
                    return true;
                }
            }
        }
        return false;
    }
    public Object search(Object o) {
        if (o instanceof Passenger) {
            Passenger p = (Passenger) o;
            for (int i = 0; i < plane.length; i++) {
                if (plane[i] != null && plane[i].equals(p)) {
                    return plane[i];
                }
            }
        }
        return null;
    }
    public boolean delete(Object o) {
        if (o instanceof Passenger) {
            Passenger p = (Passenger) o;
            for (int i = 0; i < plane.length; i++) {
                if (plane[i] != null && plane[i].equals(p)) {
                    plane[i] = null;
                    count--;
                    return true;
                }
            }
        }
        return false;
    }
    public void printLast() {
        for (int i = 0; i < plane.length; i++) {
            if (plane[i] != null) {
                System.out.println(plane[i].toString());
            }
        }
    }
    public void takeOff() {
        if (takenOff) {
            System.out.println("The plane has already taken off.");
        } else {
            System.out.println("The plane is taking off.");
            takenOff = true;
        }
    }

}
class YourDriver {
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        Scanner kb = new Scanner(System.in);
        Airplane plane = new Airplane(817345);
        Passenger p1 = new Passenger("Alice", "Johnson", "555-1234", 1, "First Class", "TID001");
        Passenger p2 = new Passenger("Bob", "Smith", "555-5678", 2, "Business Class", "TID002");
        Passenger p3 = new Passenger("Charlie", "Brown", "555-8765", 3, "Economy Class", "TID003");
        Passenger p4 = new Passenger("Diana", "Prince", "555-4321", 4, "Premium Economy", "TID004");
        Passenger p5 = new Passenger("Eve", "Adams", "555-6789", 5, "Economy Plus", "TID005");
        plane.add(p1);
        plane.add(p2);
        plane.add(p3);
        plane.add(p4);
        System.out.println("The plane is about to take off");
        plane.takeOff();
        System.out.println("Attempting to add a passenger after take off");
        plane.add(p5);
        System.out.println(plane.toString());
    }
}
class Driver {
    public static void main(String[]args) {
       Scanner in = new Scanner(System.in);
        
       Scanner kb = new Scanner(System.in);
       Airplane plane = new Airplane(817345);
       Passenger p1 = new Passenger("Bobbys", "Smith", "123456789", 1, "First class", "916-222-3333");
       Passenger p2 = new Passenger("Johnny", "Apples", "987654321", 8, "Business class", "818-000-1234");
       Passenger p3 = new Passenger("Tommy", "Jerrys", "567123489", 32, "Economy class","202-222-3333");
       Passenger p4 = new Passenger("Candy", "Cruze", "982134567", 15, "Premium Economy class","707-444-5555");
       
       //this passenger will be added after take off
       Passenger p5 = new Passenger("Kalotiii", "Aaronn", "762134589", 5, "Economy plus","817-222-6666");
       
       plane.add(p1);
       plane.add(p2);
       plane.add(p3);
       plane.add(p4);
       System.out.println("The palne is about to take off");
       plane.takeOff();
       System.out.println("adding a passenger after take off");
       plane.add(p5);
       String repeat = "";
       while(plane.getCount() > 0) 
       {
       
          System.out.println("Here is the list of the passengers in this plane");
          System.out.println("There are " + plane.getCount() + " Passengers on this plane"); 
          System.out.println(plane + "\n");
       
          System.out.println("Testing the printLast method to display the last names");
          plane.printLast();  
          System.out.println();
          
          System.out.println("Testing the static method getCount");
          System.out.println("This train has " + plane.getCount() + " Passengers\n");
          
          System.out.print("Enter the last name of the passenger to search for: ");
          String lastName = in.nextLine();
          System.out.println(plane.search(lastName));
          System.out.println();
          
          System.out.println("Testing the delete method");
          System.out.print("Enter the last name of the passenger to be deleted: ");
          String last = in.nextLine();
          plane.delete(last);
          System.out.println("Passenger " + last + " has been removed from the list\n");
          
          System.out.println("Here is the updated list");
          System.out.println(plane);
          System.out.println("*********************");
          System.out.print("Press any key to continue : ");
          repeat = kb.nextLine();
       }
       System.out.println("No passenger left on this airplane");
        
    }
 }
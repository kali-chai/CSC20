/*
Name: kali Wilson
Description: Simple ListNode demonstration using a class House and which manipulates a self-implemented LinkedList.
Date: 2025/03/23 
Self grade: 4/5. Program functions as expected and produces output consistent with assingment sample. Program has no compile errors. All necessary classes and methods are implemented. Comments and documentation were NOT completed as expected.
testimony: I have written the code by myself and did not use unauthorized resourse. 
I am aware that If the instructor finds that the submitted code is from previos semester, I will get zero points for it. Name: Kali Wilson
*/

import java.util.*;

public class ZillowWilson {

}

class House implements Comparable<House> {
    private int rooms;
    private int baths;
    private double area;
    private String address;
    private double price;
    private String zipcode;

    public House(int rooms, int baths, double area, String address, double price, String zipcode) {
        this.rooms = rooms;
        this.baths = baths;
        this.area = area;
        this.address = address;
        this.price = price;
        this.zipcode = zipcode;
    }

    public int getRooms() {
        return this.rooms;
    }

    public int getBaths() {
        return this.baths;
    }

    public double getArea() {
        return this.area;
    }

    public String getAddress() {
        return this.address;
    }

    public double getPrice() {
        return this.price;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean equals(Object obj) {
        if (obj instanceof House) {
            if (((House) obj).getAddress().equals(this.address)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(House other) {
        return (int) (this.price - other.price);
    }

    @Override
    public String toString() {
        return String.format("Rooms: %d\nBaths: %d\nSquare Footage: %.2f\nPrice: %.2f\nZipcode: %s\nAddress: %s\n", rooms,
                baths, area, price, zipcode, address);
    }
}

class ListNode<House> {
    private House data;
    private ListNode<House> next;

    public ListNode(House data) {
        this.data = data;
        this.next = null;
    }

    public ListNode(House data, ListNode<House> next) {
        this.data = data;
        this.next = next;
    }

    public ListNode() {
        assert true;
    }

    public House getData() {
        return this.data;
    }

    public ListNode<House> getNext() {
        return this.next;
    }

    public void setData(House data) {
        this.data = data;
    }

    public void setNext(ListNode<House> next) {
        this.next = next;
    }
}

interface List {
    public void add(int rooms, int baths, double price, double area, String address, String zipcode);

    public void add(int rooms, int baths, double area, String address, double price, String zipcode, int index);

    public void remove(String address);

    public int size();

    public String toString();

    public String search(int room);

    public String search(int room, int bath);

    public String search(String zipcode);
}

class Zillow implements List {
    private ListNode<House> head;
    private int size;

    public Zillow() {
        this.head = null;
        this.size = 0;
    }

    public void add(int rooms, int baths, double price, double area, String address, String zipcode) {
        House newHouse = new House(rooms, baths, area, address, price, zipcode);
        ListNode<House> newNode = new ListNode<House>(newHouse);

        if (head == null) {
            head = newNode;
        } else {
            ListNode<House> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        this.UpdateSize();
    }

    public void add(int rooms, int baths, double price,String address,  double area, String zipcode, int index)
            throws IndexOutOfBoundsException {
        House newHouse = new House(rooms, baths, area, address, price, zipcode);
        ListNode<House> newNode = new ListNode<House>(newHouse);
        if (index < 0 || index > size + 1) {
            throw new IndexOutOfBoundsException("The given index is too large or too small.");
        }
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            ListNode<House> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        this.UpdateSize();
    }

    public void remove(String address) {
        if (head == null) {
            return;
        }
        if (head.getData().getAddress().equals(address)) {
            head = head.getNext();
            this.UpdateSize();
            return;
        }
        ListNode<House> current = head;
        while (current.getNext() != null && !current.getNext().getData().getAddress().equals(address)) {
            current = current.getNext();
        }
        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
            this.UpdateSize();
        }
    }

    private void UpdateSize() {
        if (head == null) {
            this.size = 0;
            return;
        }
        ListNode<House> currentNode = head;
        int calcsize = 0;
        while (currentNode.getNext() != null) {
            calcsize++;
            currentNode = currentNode.getNext();
        }
        this.size = calcsize;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        ListNode<House> current = head;
        while (current != null) {
            result.append(current.getData().toString()).append("\n\n");
            current = current.getNext();
        }
        return result.toString();
    }

    public String search(int rooms) {
        StringBuilder result = new StringBuilder();
        ListNode<House> current = head;
        while (current != null) {
            if (current.getData().getRooms() == rooms) {
                result.append(current.getData().toString()).append("\n\n");
            }
            current = current.getNext();
        }
        return result.toString();
    }

    public String search(int rooms, int baths) {
        StringBuilder result = new StringBuilder();
        ListNode<House> current = head;
        while (current != null) {
            if (current.getData().getRooms() == rooms && current.getData().getBaths() == baths) {
                result.append(current.getData().toString()).append("\n\n");
            }
            current = current.getNext();
        }
        return result.toString();
    }

    public String search(String zipcode) {
        StringBuilder result = new StringBuilder();
        ListNode<House> current = head;
        while (current != null) {
            if (current.getData().getZipcode().equals(zipcode)) {
                result.append(current.getData().toString()).append("\n\n");
            }
            current = current.getNext();
        }
        return result.toString();
    }

    public House mostExpensiveHouse() {
        if (head == null) {
            return null;
        }
        ListNode<House> current = head;
        House mostExpensive = current.getData();
        while (current != null) {
            if (current.getData().getPrice() > mostExpensive.getPrice()) {
                mostExpensive = current.getData();
            }
            current = current.getNext();
        }
        return mostExpensive;
    }

    public House leastExpensiveHouse() {
        if (head == null) {
            return null;
        }
        ListNode<House> current = head;
        House leastExpensive = current.getData();
        while (current != null) {
            if (current.getData().getPrice() < leastExpensive.getPrice()) {
                leastExpensive = current.getData();
            }
            current = current.getNext();
        }
        return leastExpensive;
    }
}

class Driver {
    public static void main(String[] args) {
        Zillow list = new Zillow();
        // public House(int rooms, int baths,double area,String address,double price,
        // String zipcode){
        // add(int rooms, int baths, double price, double area, String address,String
        // zipcode) {
        list.add(2, 3, 710000, 1200, "Sahnnan Bay Drive", "95677");
        list.add(4, 3, 1700000, 3000, "Miners Cir", "95677");
        list.add(2, 2, 650000, 1400, "Albatroos Way", "95677");
        list.add(2, 3, 600000, 1200, "Halidon Drive", "95630");
        list.add(2, 3, 750000, 12500, "Taylor St", "95630");
        list.add(2, 3, 700000, 1100, "Canyon Drive", "95762");
        list.add(5, 4, 1650000, 2300, "Ridge View Drive", "95762");
        list.add(3, 2, 722000, 2300, "Vila Flor", "95630");

        // System.out.println(list);
        Scanner kb = new Scanner(System.in);
        while (true) {
            choice();
            System.out.print("Select an option: ");
            int option = kb.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter the zipcode: ");
                    String zip = kb.next();
                    String s = list.search(zip);
                    if (s.length() != 0)
                        System.out.println(s);
                    else
                        System.out.println("No house wasfound");
                    break;
                case 2:
                    System.out.print("Enter the number of the rooms: ");
                    int rooms = kb.nextInt();
                    s = list.search(rooms);
                    if (s.length() != 0)
                        System.out.println(s);
                    else
                        System.out.println("No house wasfound");
                    break;
                case 3:
                    System.out.print("Enter the number of the rooms and the number of the baths: ");
                    rooms = kb.nextInt();
                    int baths = kb.nextInt();
                    s = list.search(rooms, baths);
                    if (s.length() != 0)
                        System.out.println(s);
                    else
                        System.out.println("No house wasfound");
                    break;
                case 4:
                    System.out.print("Enter the adress of the house: ");
                    kb.nextLine();
                    String address = kb.nextLine();
                    list.remove(address);
                    // if (s.length() != 0)
                    // System.out.println(s);
                    // else
                    // System.out.println("No house wasfound");
                    break;
                case 5:
                    System.out.print("Enter the number of the rooms: ");
                    rooms = kb.nextInt();
                    System.out.print("Enter the number of the baths: ");
                    baths = kb.nextInt();
                    System.out.print("Enter the price of the house: ");
                    double price = kb.nextDouble();
                    System.out.print("Enter the sqaure feet of the house: ");
                    double area = kb.nextDouble();
                    System.out.print("Enter the zip code: ");
                    zip = kb.next();
                    kb.nextLine();
                    System.out.print("Enter the address: ");
                    address = kb.nextLine();
                    // int rooms, int baths, double price, double area, String address,String
                    // zipcode)
                    list.add(rooms, baths, price, area, address, zip);
                    break;

                case 6:
                    System.out.println(list);
                    break;

                case 7:
                    System.out.println(list.mostExpensiveHouse());
                    break;

                case 8:
                    System.out.println(list.leastExpensiveHouse());
                    break;

            }
        }

    }

    public static void choice() {
        System.out.println("\n*********************************************************\n");
        System.out.println("Enter 1 to list the houses based on the zipcode");
        System.out.println("Enter 2 to list the houses based on the number of the rooms");
        System.out.println("Enter 3 to list the houses with the number of rooms and baths");
        System.out.println("Enter 4 to remove a house from the list");
        System.out.println("Enter 5 to add a house to the list");
        System.out.println("Enter 6 to list all the houses");
        System.out.println("Enter 7 to list the most expensive house");
        System.out.println("Enter 8 to list the least expensive house");
        System.out.println("***************************************************\n");
    }

}

class YourDriver {
    public static void main(String[] args) {
        Zillow list = new Zillow();
        list.add(3, 2, 250000.0, 1800.5, "123 Oak St, Springfield", "62701");
        list.add(4, 3, 350000.0, 2200.0, "456 Elm St, Rivertown", "90210");
        list.add(2, 1, 150000.0, 950.75, "789 Pine Ave, Hilltop", "12345");
        list.add(5, 4, 450000.0, 3000.0, "101 Maple Rd, Lakeside", "98765");
        list.add(3, 2, 275000.0, 1600.0, "202 Cedar Blvd, Midtown", "54321");
        list.add(2, 1, 125000.0, 900.5, "303 Birch Ln, Eastview", "45678");
        list.add(4, 3, 325000.0, 2100.25, "404 Redwood Dr, Westside", "67890");
        list.add(6, 4, 500000.0, 3500.0, "505 Willow Way, Greenfield", "23456");
        list.add(3, 2, 225000.0, 1700.0, "606 Cherry St, Downtown", "11223");
        list.add(4, 2, 300000.0, 2000.5, "707 Ash Ave, Sunridge", "33445");
        list.add(2, 1, 180000.0, 1100.0, "808 Spruce Ln, Hillside", "55667");
        list.add(5, 3, 400000.0, 2500.0, "909 Maple Dr, Riverdale", "77889");
        list.add(3, 2, 260000.0, 1900.75, "121 Oak St, Springfield", "62701");
        list.add(4, 3, 370000.0, 2300.0, "131 Elm St, Rivertown", "90210");
        list.search("90210");
        list.search(3);
        list.search(4, 3);
        list.remove("123 Oak St, Springfield");
        list.add(3, 2, 280000.0, 1750.0, "123 Oak St, Springfield", "62701");
        System.out.println(list);
        System.out.println("Most expensive house: " + list.mostExpensiveHouse());
        System.out.println("Least expensive house: " + list.leastExpensiveHouse());
        list.add(2, 2, 284200.0, "204 West Street, Rockland", 1850.0, "43352", 3);
        System.out.println(list);
    }
}
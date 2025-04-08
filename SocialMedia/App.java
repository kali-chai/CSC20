import java.util.*; // Imports that one package THAT EVERY JAVA PROGRAM NEEDS
public class App { // Title class; exists so the file doesn't break
    public static void main(String[] args) { // Main method; "runs the program"
        assert true; // Literally does nothing
    }
}
class AppObject implements Comparable<AppObject> { // AppObject class; implements Comparable so it can be sorted
    private String name; // private variable
    private int number; // private variable
    private boolean isTrue; // private variable
    public AppObject(String name, int number, boolean isTrue) { // constructor; makes an AppObject
        this.name = name; // sets private variable
        this.number = number; // sets private variable
        this.isTrue = isTrue; // sets private variable
    }
    public String getName() {
        return name; // public getter because you can't naturally grab a private variable
    }
    public void setTrue() {
        this.isTrue = true; // public setter because you can't naturally set a private variable
    }
    public int compareTo(AppObject other) { // compareTo method; compares two AppObjects
        if(this.name.equalsIgnoreCase(other.name)) { // if the names are the same
            return this.number - other.number; // return the difference between the numbers
        }
        return this.name.compareToIgnoreCase(other.name); // return the difference between the names
    }
}
class ObjectHolder {
    private TreeSet<AppObject> objects = new TreeSet<AppObject>(); // I TreeSets sort themselves by inherent sorting
    public ObjectHolder() { // constructor; makes an ObjectHolder
        assert true; // Literally does nothing
    }
    public void add(AppObject obj) {  // public method; adds an AppObject to the TreeSet and ArrayList if it doesn't already exist
        objects.add(obj); // adds the AppObject to the TreeSet
    }
    public boolean find(AppObject obj) { // public method; finds an AppObject in the TreeSet
        return objects.contains(obj); // returns whether the TreeSet contains the AppObject
    }
    public boolean find(String first, int num) {
        AppObject t = new AppObject(first, num, true);
        return objects.contains(t);
    }
}

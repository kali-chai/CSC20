/**
 * Stores methods in labs; Contains, findMedian.
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Date date = new Date(2, 28);
        System.out.println(date.toString());
    }

    /**
     * This method returns true if a1 contains a2, and false otherwise. Lab Name: contains.
     * 
     * @param a1
     * @param a2
     * @return boolean that checks if a1 contains a2.
     */
    public boolean contains(int[] a1, int[] a2) {
        /**
         * Iterates through a1. Last start point is a1.length - a2.length because of
         * final bound where a2 is possible in a1.
         */
        for (int i = 0; i <= a1.length - a2.length; i++) {
            /**
             * Iterates through values in a2, will break if the a2 pattern is not found. If
             * the values in a2 are successfully iterated through, a2 has been found, return
             * true.
             */
            for (int j = 0; j < a2.length; j++) {
                /**
                 * Breaks to next start point if a2 pattern not completed.
                 */
                if (a1[i + j] != a2[j]) {
                    break;
                }
                /**
                 * Returns true if a2 pattern is completed.
                 */
                if (j == a2.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * This method finds the median of a given int[]. Assumes all int[] arrays passed to the method are odd length. Does not assume int[] arrays are sorted. Sorts the array, then returns the median. Lab Name: findMedian.
     * @param array int[] array to find median of.
     * @return med median of the array.
     */
    public int findMedian(int[] array) {
        /**
         * Sorts the array and returns median (middle of array).
         */
        int[] sortedArray = array;
        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[i] > sortedArray[j]) {
                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = temp;
                }
            }
        }
        return sortedArray[sortedArray.length / 2];
    }
}
/**
 * Class for Lab 1. Remembers information about a month and day. Ignores leap years, doesn't store years. 
 * Lab name: Date.
 */
class Date {
    private int month;
    private int day;
    public Date(int m, int d) {
        month = m;
        day = d;
    }
    public int daysInMonth() {
        if(month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if(month == 2) {
            return 28;
        } else {
            return 31;
        }
    }
    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public void nextDay() {
        day++;
        if (day > daysInMonth()) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
            }
        }
    }
    public String toString() {
        return String.format("%02d/%02d", month, day);
    }
}
class Student {
    private String name;
    private int id;
    private int units = 0;
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public void incrementUnits(int units) {
        this.units += units;
    }
    public int getUnits() {
        return units;
    }
    public boolean hasEnoughUnits() {
        return units >= 180;
    }
    public String toString() {
        return String.format("%1 (%2)", name, id);
    } 
}

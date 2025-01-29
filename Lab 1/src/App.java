public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.out.println(new App().contains(new int[] {1, 6, 2, 1, 4, 1, 2, 1, 8}, new int[] {1, 2, 1}));
    }

    /**
     * This method returns true if a1 contains a2, and false otherwise.
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
     * This method finds the median of a given int[]. Assumes all int[] arrays passed to the method are odd length. Does not assume int[] arrays are sorted.
     * @param array int[] array to find median of.
     * @return med median of the array.
     */
    public int median(int[] array) {
        int med;
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
        
        
}

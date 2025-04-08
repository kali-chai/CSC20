import java.util.*;
public class AppLab7 {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        LinkedList<Integer> data = new LinkedList<>();
        data.add(3);
        data.add(4);
        LinkedList<Integer> last = insert(list, data, 1);
        System.out.println(last);
    }
    public static LinkedList<Integer> insert (LinkedList<Integer> list, LinkedList<Integer> data, int point) {
        LinkedList<Integer> result = new LinkedList<>();
        for(int i = 0; i < point; i++) {
            result.add(list.removeFirst());
        }
        while(!data.isEmpty()) {
            result.add(data.removeFirst());
        }
        while(!list.isEmpty()) {
            result.add(list.removeFirst());
        }
        return result;
    }
}

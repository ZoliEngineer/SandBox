import java.util.Arrays;
import java.util.LinkedList;


public class RecursiveLinkedList {
    public static void main(String... args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("a", "b", "c", "d", "e"));
        walkThrough(list);
    }

    private static void walkThrough(LinkedList<String> list) {
        if (list.isEmpty()) {
            return;
        }
        String current = list.poll();
        System.out.println(current);
        
        walkThrough(list);
    }
}

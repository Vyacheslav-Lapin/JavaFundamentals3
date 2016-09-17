import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class AppResources {

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> stringIntegerLinkedHashMap = new LinkedHashMap<>(16, 0.75f, true);

        List<String> list4 = Arrays.asList("blue", "green", "red");
        System.out.println("(3) Index: " + Collections.binarySearch(list4, "red"));
        System.out.println("(4) Index: " + Collections.binarySearch(list4, "cyan"));

    }
}

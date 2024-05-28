package Activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("A");
        hs.add("B");
        hs.add("C");
        hs.add("D");
        hs.add("E");
        hs.add("F");

        System.out.println("Original Set :"+hs);
        System.out.println("Size :"+hs.size());
        System.out.println("Removing :"+hs.remove("E"));
        System.out.println("Removing :"+hs.remove("G"));
        System.out.println("Contains :"+hs.contains("C"));
        System.out.println("Size :"+hs.size());
        System.out.println("Original Set :"+hs);
    }
}

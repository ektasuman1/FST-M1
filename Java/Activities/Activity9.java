package Activities;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<String>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add(3,"Five");

        for (String x:list){
            System.out.println(x);
        }

        System.out.println("Third index data :"+list.get(3));
        System.out.println("List contains data :"+list.contains("Two"));
        System.out.println("Length is :"+list.size());
        System.out.println("Removing :"+list.remove(2));
        System.out.println("Length is :"+list.size());
    }
}

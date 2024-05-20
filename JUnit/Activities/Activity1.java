import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1 {
    // Initialize a new ArrayList

    static  ArrayList<String> list;

    @BeforeEach
    void setUp() throws  Exception{
         list = new ArrayList<String>();

// Add values to the list
        list.add("alpha"); // at index 0
        list.add("beta"); // at index 1
    }

@Test
void insertTest(){
    // Assert size of list
    assertEquals(2, list.size(), "Wrong size");

list.add("charlie");
// Assert individual elements
    assertEquals(3, list.size(), "Wrong element");

    assertEquals("alpha", list.get(0), "Wrong element");
    assertEquals("beta", list.get(1), "Wrong element");
    assertEquals("charlie", list.get(2), "Wrong element");

    // Replace element in ArrayList

}

@Test
    void replaceTest(){

        list.set(1,"charlie");

    assertEquals(2, list.size(), "Wrong size");
    assertEquals("alpha", list.get(0), "Wrong element");
    assertEquals("charlie", list.get(1), "Wrong element");


}
}


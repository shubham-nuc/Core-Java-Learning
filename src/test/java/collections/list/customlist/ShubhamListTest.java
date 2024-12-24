package collections.list.customlist;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShubhamListTest {
    ShubhamList list;

    @BeforeEach
    void setUp() {
        list=new ShubhamList();
        list.add(5);
        list.add("shubham");
    }

    @Test
    void testAdd() {
        list.add("Kunal");
        System.out.println(list);
    }

    @Test
    void testAddAtIndex() {
        System.out.println("before = "+list);
        list.add(1,"Kunal");
        System.out.println("after = "+list);
    }

    @Test
    void testGet() {
        var element=list.get(0);
        System.out.println(element);
    }

    @Test
    void testRemove() {
        list.remove(1);
        System.out.println(list);
    }

    @Test
    void testUpdate() {
        list.update(0,"Kunal");
        System.out.println(list);
    }
}
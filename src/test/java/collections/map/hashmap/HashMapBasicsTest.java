package collections.map.hashmap;

import collections.list.customlist.ShubhamList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapBasicsTest {
    HashMapBasics hm = new HashMapBasics();


    @BeforeEach
    void setUp() {
    }

    @Test
    void checkAssignedBucket() {
        hm.checkAssignedBucket();
    }
}
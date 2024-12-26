package collections.map.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasics {

    public static void main(String[] args) {
        HashMapBasics hm=new HashMapBasics();
        hm.checkAssignedBucket();
    }

    public void checkAssignedBucket(){
        Map<Integer,String> hm=new HashMap<>();
        hm.put(1,"Shubham");
        printAllocatedBucketIndex(1);

        hm.put(2,"Kunal");
        printAllocatedBucketIndex(2);

        hm.put(3,"Kunal");
        printAllocatedBucketIndex(3);

        hm.put(400,"Kunal");
        printAllocatedBucketIndex(400);

        hm.put(500,"Kunal");
        printAllocatedBucketIndex(500);

        hm.put(600,"Kunal");
        printAllocatedBucketIndex(600);

        hm.put(700,"Kunal");
        printAllocatedBucketIndex(700);

        hm.put(800,"Kunal");
        printAllocatedBucketIndex(800);

        hm.put(900,"Kunal");
        printAllocatedBucketIndex(900);

        hm.put(1000,"Kunal");
        printAllocatedBucketIndex(1000);

        hm.put(100,"Kunal");
        printAllocatedBucketIndex(100);

        hm.put(200,"Kunal");
        printAllocatedBucketIndex(200);

    }

    private static void printAllocatedBucketIndex(Integer key) {
        int hash= key.hashCode();
        int defaultCapacity=16;
        int bucketIndex=hash & (defaultCapacity-1);
        System.out.println("----------------------------");
        System.out.println("Key = "+ key);
        System.out.println("Hash = "+hash);
        System.out.println("Index = "+bucketIndex);
    }
}

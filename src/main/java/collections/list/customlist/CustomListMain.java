package collections.list.customlist;

import java.util.ArrayList;
import java.util.List;

public class CustomListMain {

    public static void main(String[] args) {
        ShubhamList list=new ShubhamList();
        list.add(5);
        list.add("shubham");
        //System.out.println(list);

        CustomListMain test = new CustomListMain();
        //test.getMethodTest();
        test.remove();
    }

    private void getMethodTest(){
        ShubhamList list=new ShubhamList();
        list.add(5);
        list.add("shubham");
        System.out.println(list.get(2));
    }

    private void remove(){
        ShubhamList list=new ShubhamList();
        list.add(5);
        list.add("shubham");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }

    @Override
    public String toString() {
        return "CustomListMain{}";
    }
}

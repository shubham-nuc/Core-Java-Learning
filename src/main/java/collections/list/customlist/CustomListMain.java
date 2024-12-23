package collections.list.customlist;

public class CustomListMain {

    public static void main(String[] args) {
        ShubhamList list=new ShubhamList();
        list.add(5);
        list.add("shubham");
        System.out.println(list);

        CustomListMain test = new CustomListMain();
        test.getMethodTest();
    }

    private void getMethodTest(){
        ShubhamList list=new ShubhamList();
        list.add(5);
        list.add("shubham");
        System.out.println(list.get(0));
    }
}

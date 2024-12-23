package collections.list.customlist;

public class ShubhamList {
    private Object[] objArr;
    private int elementCount=0;

    public ShubhamList() {
        this.objArr = new Object[10];
    }

    public ShubhamList(int index) {
        this.objArr = new Object[index];
    }

    public void add(Object obj){
        if(elementCount == objArr.length){
            increaseCapacity();
        }
        objArr[elementCount]=obj;
        elementCount++;
    }

    private void increaseCapacity() {
        int newCapacity= objArr.length*2;
        Object[] newArr=new Object[newCapacity];
        for (int i = 0; i < objArr.length; i++) {
            newArr[i]=objArr[i];
        }
        //Another Way
        //System.arraycopy(objArr, 0, newArr, 0, objArr.length);
        objArr=newArr;
    }

    public Object get(int index) throws ArrayIndexOutOfBoundsException {
        if(index==0){
            throw new ArrayIndexOutOfBoundsException("Oops wrong search....Index 0 out of bounds for length "+elementCount);
        }
        if(index>size()){
            throw new ArrayIndexOutOfBoundsException("oops wrong search....total list size is "+elementCount+ " where as you are trying to get record with index "+index );
        }
        return objArr[index-1];
    }

    public int capacity(){
        return objArr.length;
    }

    public int size(){
        return elementCount;
    }
}

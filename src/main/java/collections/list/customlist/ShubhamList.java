package collections.list.customlist;

import java.util.Arrays;

public class ShubhamList {
    private Object[] elementData;
    private int size =0;


    public ShubhamList() {
        this.elementData = new Object[10];
    }

    public ShubhamList(int index) {
        this.elementData = new Object[index];
    }


    public void add(Object obj){
        if(size == elementData.length){
            increaseCapacity();
        }
        elementData[size]=obj;
        size++;
    }

    public void add(int index,Object obj){
        validateIndex(index);
        for (int i = size; i > index; i--) { //0,1
            elementData[i]=elementData[i-1];
        }
        elementData[index]=obj;
        size++;
    }

    private void increaseCapacity() {
        int oldCapacity=elementData.length;
        int newCapacity= oldCapacity*2;
        Object[] newArr=new Object[newCapacity];
        for (int i = 0; i <size; i++) {
            newArr[i]= elementData[i];
        }
        elementData=newArr;
        //Another Way
        //System.arraycopy(elementData, 0, newArr, 0, elementData.length);
        //return elementData=Arrays.copyOf(elementData, newCapacity);
    }

    public Object get(int index) throws ArrayIndexOutOfBoundsException {
        validateIndex(index);
        return elementData[index];
    }

    public void remove(int index){
        validateIndex(index);
        for (int i = index; i < size; i++) {
            elementData[i] = elementData[i+1];
        }
        size--;
    }

    public void update(int index,Object obj){
        validateIndex(index);
        elementData[index]=obj;
    }

    private void validateIndex(int index) {
        if(index >=size){
            throw new ArrayIndexOutOfBoundsException("oops wrong search....total list size is "+ size + " where as you are trying to get record with index "+ index);
        }
    }

    public int capacity(){
        return elementData.length;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        ;
        return "ShubhamList = {" +
                "size=" + size +
                " ,data=" + Arrays.toString(Arrays.stream(elementData).filter(it->it!=null).toArray()) +
                '}';
    }

}

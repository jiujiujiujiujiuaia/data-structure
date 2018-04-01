package algorithm;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.jar.Pack200;


public class LIFO_Stack<Item>
        implements Iterable
{
    private Item[] a =(Item[]) new Object[1];
    private int pointer = 0;

    public boolean IsEmpty(){return pointer == 0;}
    public int size(){   return pointer;}
    public void push(Item key){
        if(pointer == a.length) resize(2*a.length);
        a[pointer++] = key;
    }
    public Item pop(){
        Item item = a[--pointer];
        a[pointer] = null;
        return item;
    }

    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i =0;i<pointer;i++) temp[i] = a[i];
        a = temp;
    }

//只有实现了Iterable的接口 才可以进行for()的迭代

    public Iterator<Item> iterator(){
        return new ReverseArray();
    }
    private class ReverseArray implements Iterator<Item>{
        public boolean hasNext(){   return pointer>0;}
        public Item next() { return a[--pointer];   }
        public void remove(){

        }
    }
    public static void main(String[] args){
        //test case
//        LIFO_Stack<String> stack = new LIFO_Stack();
//        stack.push("h");
//        stack.push("e");
//        stack.push("l");
//        stack.push("l");
//        for(Object  a: stack){
//            StdOut.println(a);
//        }

    }



}

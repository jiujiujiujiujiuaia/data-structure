package algorithm;

import edu.princeton.cs.algs4.StdOut;

import java.util.Objects;
import java.util.Scanner;

/**
 * Created by 87057 on 2018/3/27.
 */
public class LIFO_Stack_Node<Item>
//        implements Iterable
{
     private Node head;
    private Node pointer = head;
    private class Node{
        Item item ;
        Node next;
    }

    private void push(Item item){

       Node node = new Node();
        node.item = item;
        node.next = pointer;
        pointer = node;
    }
    private Item pop(){
        Item item = pointer.item;
        pointer = pointer.next;
        return item;
    }









    public static void main(String[] args){

        LIFO_Stack_Node a = new LIFO_Stack_Node();
        a.push(1);
        a.push(2);
        a.push(3);
        Object b = a.pop();
        StdOut.println(a.pointer.item);
        a.pointer = a.pointer.next;
        StdOut.println(a.pointer.item);
        a.pointer = a.pointer.next;


    }

}

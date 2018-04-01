package algorithm;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class SequentialSearchST<Key,Value> {
    private Node first;
    private class Node{
        Key key;
        Value value;
        Node next;
        private Node(Key key,Value value,Node first){
            this.key = key;
            this.value = value;
            this.next = first;
        }

    }
    public Value get(Key key){
        for(Node a = first;a!=null;a = a.next){
            if(key.equals(a.key)) return a.value;
        }
        return null;

    }

    public void put(Key key ,Value value){
        for(Node a =first;a!=null;a = a.next){
            if(key.equals(a.key)) {
                a.value = value ; return ;
            }
        }

        first =  new Node(key,value,first);

    }


    public static void main(String[] args){


//        test case
        SequentialSearchST a = new SequentialSearchST();
        a.put(1,2);
        a.put(1,"hello");

    }
}

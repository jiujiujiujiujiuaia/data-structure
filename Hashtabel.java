package algorithm;


import edu.princeton.cs.algs4.StdOut;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Hashtable;

public class Hashtabel<K,V> {
    private SequentialSearchST<K,V>[] st;
    private int M;
    private int N;
    public Hashtabel(){
        this(2);
    }
    public Hashtabel(int  m ){
        this.M = m;
        st =  (SequentialSearchST<K,V>[])new SequentialSearchST[M];
        for(int i =0;i<st.length;i++)
        {
            st[i] = new SequentialSearchST<K,V>();
        }
    }

    public int hash(K key){
        return (key.hashCode() & 0x7fffffff)%M;
    }
    public void put(K key,V val){
        if(N == M) {; resize(M*2);}
        st[hash(key)].put(key,val);
        N++;
    }
    public V get(K key){
        return st[hash(key)].get(key);
    }

    public void resize(int cap){
        Hashtabel<K,V> temp = new Hashtabel<>(cap);
        for(int i =0 ;i<M;i++){
            if(st[i]!=null){
                temp.st[i] = st[i];
            }
        }
        st = temp.st;
        this.M = temp.M;
    }
    public int size(){
        return M;
    }






    public  static void main(String[] args)
    {
//--------------test case-----------
        Hashtabel a = new Hashtabel();
        a.put(1,2);
        StdOut.println(a.size());
        a.put(1,2);
        a.put("as",55);
        StdOut.println(a.size());
    }



}


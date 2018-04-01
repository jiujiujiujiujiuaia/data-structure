package algorithm;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;

/**
 * Created by 87057 on 2018/3/21.
 */
public class Sort {

    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }
    public static void exchange(Comparable[] array,int i,int j){
        Comparable temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void show(Comparable[] a){
        for(int i = 0;i<a.length;i++){
            StdOut.print(a[i] + " ");
        }
    }
    public static boolean isSort(Comparable[] a){
        for(int i = 1;i<a.length;i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }
    //-----------------------------------------------------------------
    public static void merge(Comparable[] a,int l,int mid , int h) { //mid = h/2 h= a.length -1
        int i = l;
        int j = mid+1;
        Comparable[] temp = new Comparable[a.length];
        for (int k = i; k < a.length; k++) {
            temp[k] = a[k];
        }
        for(int k = i;k<a.length;k++){
            if(i>mid) a[k] = temp[j++];
            else if (j>h) a[k] = temp[i++];
            else if(less(temp[i],temp[j])) a[k] = temp[i++];
            else a[k] = temp[j++];
        }
    }
    public static void SortMerge(Comparable[] a ){
        SortMerge(a,0,a.length-1);
    }
    public static void SortMerge(Comparable[] a ,int l,int h){
        if(l>=h) return ;
        int mid = l+(h-l)/2;
        SortMerge(a,l,mid);
        SortMerge(a,mid+1,h);
        merge(a,l,mid,h);
    }
    public static void SotrMergeBU(Comparable[] array){

        for(int sz = 1;sz<array.length;sz = 2*sz)
            for(int i = 0;i<array.length-sz;i = i+2*sz){
                merge(array,i,i+sz-1,Math.min(i+sz+sz-1,array.length-1));
            }

    }
    public static void QuickSort(Comparable[] a){
        StdRandom.shuffle(a);
        QuickSort(a,0,a.length-1);

    }
    public static void QuickSort(Comparable[] a,int l,int h){


        if(l>=h) return;
        int j = paticition(a,l,h);
        QuickSort(a,l,j-1);

        QuickSort(a,j+1,h);

    }
    public static int paticition(Comparable[] a,int l,int h){
        int i = l;int j = h+1;
        Comparable v = a[l];
        while(true) {
            while (less(v, a[++i])) if (i == h) break;
            while (less(a[--j], v)) if (j == l) break;//无所谓呀 虽然我这里是做的一个降序的数组；
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a,l,j);
        return j;

    }













    public static void main(String[] args){
        Integer[] array = {3,25,4,67,86,12,3};
        QuickSort(array);
        show(array);
        ;
    }
}

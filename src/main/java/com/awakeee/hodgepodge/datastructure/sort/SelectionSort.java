package com.awakeee.hodgepodge.datastructure.sort;

public class SelectionSort extends SortUtil{

    //选择排序（Selection sort）是一种简单直观的排序算法。
    // 它的工作原理是每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。
    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i=0;i<N;i++){
            int min = i;
            for(int j=i+1;j<N;j++){
                if(less(a[j],a[min])){//如果a[j]<a[min]，将下标替换
                    min = j;
                }
            }
            //System.out.println(isSorted(a));
            exch(a,i,min);
        }
    }

    public static void main(String[] args) {

        Comparable[]a = new Comparable[]{3,8,9,6,5,4,2,0,1,7};
        sort(a);
        show(a);

    }
}

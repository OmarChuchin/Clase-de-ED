/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pila;
import java.util.Arrays;
/**
 *
 * @author omar
 */
public class play {
    
    public static void main(String[] args) {
        //int[] test={5,4,10,250,-12,-1,8};
        int[] test={5,4,10,250,-12,-1,8,12};
        int[] copy=new int[test.length];
        System.out.println(Arrays.toString(test));
        mergeSort(test,copy,0,test.length-1);
        System.out.println(Arrays.toString(test));
    }
    
    public static void quickSort(int[] data,int start, int end){
        if (start>=end)
            return ;
        Stack<Integer> mayor=new Stack();
        Stack<Integer> menor=new Stack();
        int divisor=data[start];
        for(int i=start+1;i<=end;i++){
            if (data[i]<divisor)
                menor.push(data[i]);
            else
                mayor.push(data[i]);            
        }
        int place=start;
        while(!menor.empty()){
            data[place]=menor.pop();
            place++;
        }
        int middle=place;
        data[place]=divisor;
        place++;
        while(!mayor.empty()){
            data[place]=mayor.pop();
            place++;
        }
        quickSort(data,middle+1,end);
        quickSort(data,start,middle-1);
    }
    
    
    //tiene un bug con los dos arreglos test de arriba
    public static void mergeSort(int[] data,int[] copy,int start,int end){
        if(start>=end)
            return;
        int mid=(start+end)/2;
        mergeSort(data,copy,start,mid);
        mergeSort(data,copy,mid+1,end);
        int li=start,c=li;
        int ri=mid+1;
        while (li<=mid && ri<=end){
            if(data[li]<=data[ri]){
                copy[c]=data[li];
                li++;
            }
            else{
                copy[c]=data[ri];
                ri++;
            }
            c++;
        }
        for(int i=li;i<=mid;i++){
            copy[c]=data[i];
            c++;
        }
        for(int i=ri;ri<=end;ri++){
            copy[c]=data[i];
            c++;
        }
        for(int i=start;i<=end;i++)
            data[i]=copy[i];
    }
    
}

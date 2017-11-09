/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;
import Practica_3.LinkedList;

/**
 *
 * @author omar
 */
public class Examen {
    
    public static void main(String[] args) {
        //System.out.println(allStar("parangaricutirimicuaro"));
        //System.out.println(endX("xhixhix"));
        /*
        LinkedList<Integer> A=new LinkedList(),B=new LinkedList();
        for(int i=0;i<10;i++)
            A.addLast(i);
        for(int i=5;i<16;i++)
            B.addLast(i);
        System.out.println(A);
        System.out.println(B);
        System.out.println(intersect(A,B));*/
        /*for(int i=0;i<6;i++)
            System.out.println(shapeArea(i));*/
              
        
        
    }

    //listo 20 puntos 
    public static String allStar(String str) {
        if (str.length()<=1)
            return str;
        else
            return str.substring(0, 1).concat("*").concat(allStar(str.substring(1, str.length())));
    }
    
    //listo 20 puntos
    public static String endX(String str) {
        if (str.length()==0)
            return "";
        else if (str.charAt(0)=='x')
            return endX(str.substring(1, str.length())).concat("x");
        else
            return str.substring(0,1).concat(endX(str.substring(1, str.length())));
    }
    
    //listo 20 puntos
    public static LinkedList<Integer> intersect(LinkedList<Integer> A,LinkedList<Integer> B){
        LinkedList<Integer> res=new LinkedList();
        for(int i=0;i<A.size();i++){
            int a=A.get(i);
            for(int j=0;j<B.size();j++){
                int b=B.get(j);
                if(a==b)
                    res.addLast(a);
            }
        }
        return res;
    }
    
    //listo 30 puntos
    public static int shapeArea(int n){
        if(n<1)
            return 0;
        else if(n==1)
            return n;
        else{
            return shapeArea(n-1)+4*(n-1);
        }
    }
    
    
    /*public static LinkedList<Integer> difference(LinkedList<Integer> A,LinkedList<Integer> B){
        for(int i=0;i<A.size();i++){
            System.out.println(A.get(i));
            for(int j=0;j<B.size();j++){
                System.out.print(B.get(j)+" ");
                A.remove(B.get(j));
            }
        }
        return A;
    }*/
}

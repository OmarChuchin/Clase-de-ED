/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;

import Practica_3.LinkedList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author omar
 */
public class ExamenFinal {
    //45 total
    
    //listo = 5 puntos
    public static String cleanString (String str){
        char[] alfa={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                     'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] ns=str.toCharArray();
        String ret="";
        boolean test;
        for (int i=0;i<ns.length;i++){
            test=false;
            char a=ns[i];
            for(int j=0;j<alfa.length;j++){
                char b=alfa[j];
                if (b==a){
                    test=true;
                    break;
                }
            }
            if(test)
                ret+=a;
        }
        return ret.toUpperCase();
    }
    
    //listo= 5 puntos
    public static int mystery(int m,int n){
        if (m==0)
            return n+1;
        else if (m>0 && n==0)
           return mystery(m-1,1);
        else if (m>0 && n>0)
            return mystery(m-1,mystery(m,n-1));
        else 
            return -1;
    }
    
    //listo=5 puntos
    public static LinkedList<Integer> union(LinkedList<Integer> list1,LinkedList<Integer> list2){
        LinkedList<Integer> ret=new LinkedList();
        Integer i;
        for(i=0;i<list1.size();i++)
            ret.addLast(list1.get(i));
        for(i=0;i<list2.size();i++)
            ret.addLast(list2.get(i));
        return ret;
    }
    
    //listo=5 puntos
    public static void insertionInOrder (LinkedList<Integer> lista,int e){
        int a=0;
        for(int i=0;i<lista.size();i++){
            int b=lista.get(i);
            if (e>b)
                a=i+1;
        }
        lista.add(a, e);
    }
    
    //pendiente
    public static void superSort(String[] arr){
        
    }
    
    //listo 15 puntos 
    public static Object[] greedy(Item[] stock){
        LinkedList<Item> mochila=new LinkedList();
        float peso=0;
        int left=100;
        boolean[] check=new boolean[100];
        for (int i=0;i<100;i++)
            check[i]=false;
        float valor=0,valorg=0;
        int index=-1;
        float test;
        boolean still=true;
        while(still){
            for(int i=0;i<stock.length;i++){
                if(check[i]==false){
                    if(stock[i].valor>valor){
                        valor=stock[i].valor;
                        index=i;
                    }
                }
            }
            check[index]=true;
            left--;
            test=peso+stock[index].peso;
            if(test<=100){
                peso+=stock[index].peso;
                mochila.addLast(stock[index]);
                valorg+=stock[index].valor;
            }
        still=(left>0 && peso<100);
        }
        System.out.println(left);
        System.out.println(valorg);
        System.out.println(peso);
        return mochila.toArray();
    }
    
    //listo 15 puntos
    public static Object[] lucky(Item[] stock){
        LinkedList<Item> mochila=new LinkedList();
        Random r=new Random();
        float valtest=0,pesotest=0;
        for(int a=0;a<100;a++){
            LinkedList<Item> essay=new LinkedList();
            LinkedList<Item> copy=new LinkedList();
            for (int i=0;i<100;i++)
                copy.addLast(stock[i]);
            float peso=0;
            int left=100;
            float valor=0;
            while (left>0 && peso<100){
                int index=r.nextInt(left);
                if((copy.get(index).peso+peso)<=100){
                    valor+=copy.get(index).valor;
                    peso+=copy.get(index).peso;
                    essay.addLast(copy.remove(index));
                }
                left--;
            }
            if(valor>valtest){
                mochila=essay;
                valtest=valor;
                pesotest=peso;
            }
        }
        System.out.println(valtest);
        System.out.println(pesotest);
        return mochila.toArray();
    }
    
    public static void main(String[] args) {
        //5 puntos
        Item[] stock=new Item[100];
        for(int i=0;i<stock.length;i++)
            stock[i]=new Item();
        Object[] g,l;
        g=greedy(stock);l=lucky(stock);
        
        float valorg=0,pesog=0;
        float valorl=0,pesol=0;
        
        for(int i=0;i<g.length;i++){
            Item item=(Item)g[i];
            valorg+=item.valor;
            pesog+=item.peso;
        }
        for(int i=0;i<l.length;i++){
            Item item=(Item)l[i];
            valorl+=item.valor;
            pesol+=item.peso;
        }
        System.out.println("Peso de greed es "+pesog+" Valor de greed es "+valorg);
        System.out.println("Peso de luck es "+pesol+" Valor de luck es "+valorl);
    }
}

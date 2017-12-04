/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;

import java.util.Random;

/**
 *
 * @author omar
 */
public class Item {
    
    public float peso,valor;
    
    //5 puntos
    public Item(float p,float v){
        this.peso=p;
        this.valor=v;
    }
    
    public Item(){
        Random r=new Random();
        float a=r.nextFloat();
        int b=r.nextInt(25);
        float num=a*b;
        this.peso=num;
        a=r.nextFloat();
        b=r.nextInt(26);
        num=a*b;
        this.valor=num;
    }
    
    @Override
    public String toString(){
        return "Peso= "+this.peso+" Valor= "+this.valor;
    }
    
}

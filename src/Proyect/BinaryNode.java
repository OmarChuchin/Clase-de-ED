/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyect;
import java.util.Scanner;

/**
 *
 * @author omar
 */
public class BinaryNode {
    public BinaryNode LC,RC;
    public String value;
    
    public BinaryNode(String val){
        this.value=val;
        this.LC=null;
        this.RC=null;
    }
    
    public void preorderTraversal(){
        System.out.print(" "+this.value);
        if(this.LC==null)
            System.out.print("");
        else
            this.LC.preorderTraversal();
        if(this.RC==null)
            System.out.print("");
        else
            this.RC.preorderTraversal();
    }
    
    public void inorderTraversal(){
        if(this.LC!=null)
            this.LC.inorderTraversal();
        else
            System.out.print("");
        System.out.print(" "+this.value);
        if(this.RC!=null)
            this.RC.inorderTraversal();
        else
            System.out.print("");
    }
    
    public void postorderTraversal(){
        if(this.LC!=null)
            this.LC.postorderTraversal();
        else
            System.out.print("");
        if(this.RC!=null)
            this.RC.postorderTraversal();
        else
            System.out.print("");
        System.out.print(" "+this.value);
    }
    
    //funcion para que crezca el arbol y aprenda
    public void learn(){
        String respuesta=this.value;
        Scanner in=new Scanner(System.in);
        String r,p,s;
        System.out.println("En que animal estabas pensando?");
        r=in.nextLine();
        System.out.println("Cual seria la pregunta para diferenciar a"
            +"\n"+"un/una "+respuesta+" de un/una "+r+"?");
        p=in.nextLine();
        System.out.println("La respuesta para "+r+" seria si?");
        s=in.nextLine();
        if(s.equalsIgnoreCase("s")||s.equalsIgnoreCase("si")){
            this.LC=new BinaryNode(r);
            this.RC=new BinaryNode(respuesta);
        }
        else{
            this.LC=new BinaryNode(respuesta);
            this.RC=new BinaryNode(r);
        }
        System.out.println(p);
        this.value=p;
    }
    
    public void think(){
        if(this==null)
            System.out.println("done");
        Scanner in=new Scanner(System.in);
        boolean respuesta=false;
        BinaryNode actual=this;
        String r;
        while(!respuesta){
            if(actual.LC==null && actual.RC==null)
                respuesta=true;
            else{
                System.out.println(actual.value);
                r=in.nextLine();
                if(r.equalsIgnoreCase("s") || r.equalsIgnoreCase("si"))
                    actual=actual.LC;
                else if (r.equalsIgnoreCase("n") || r.equalsIgnoreCase("no"))
                    actual=actual.RC;
                else
                    System.out.println("Disculpa pero no entendi +"
                            + "\n"+"Me lo podras repetir?");
            }
        }
        while(respuesta){
        System.out.println("Estas pensando en un/una "+actual.value+"?");
        r=in.nextLine();
        if(r.equalsIgnoreCase("s") || r.equalsIgnoreCase("si")){
            System.out.println("excelente");
            respuesta=false;
        }
        else if (r.equalsIgnoreCase("n") || r.equalsIgnoreCase("no")){
            respuesta=false;
            //en un momento hago learn
            actual.learn();
        }
        else
            System.out.println("Disculpa pero no entendi +"
                    + "\n"+"Me lo podras repetir?");
        }
    }
    
    
}

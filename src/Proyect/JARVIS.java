/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyect;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import Practica_6.Queue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;



/**
 *
 * @author omar
 */
public class JARVIS{
    public static void main(String[] args) {
        //inicializacion del programa
        System.out.println("Buenos dias operador ^n^");
        //leer arbol actual
        boolean existe=true;
        BinaryNode root=null;
        BinaryNode[] arbol;
        try{
            arbol=load("memory.txt");
            root=arbol[0];
            
        }
        catch(FileNotFoundException ex){
            existe=false;
        }
        if(!existe){
            System.out.println("Veo que he perdido mi memoria T.T"+
              "\n"+"hare una nueva ahora");
            root=new BinaryNode("respira aire?");
            root.LC=new BinaryNode("perro");root.RC=new BinaryNode("pez");
        }
        Scanner in=new Scanner(System.in);
        boolean cont=true;
        while(cont){
            root.think();
            System.out.println("otra vez?");
            String r=in.nextLine();
            if(r.equalsIgnoreCase("n")||r.equalsIgnoreCase("no"))
                cont=false;
        }
        //save the tree
        try{
            save(root);
        }
        catch(IOException E){
            System.out.println("ha ocurrido un error");
        }
        System.out.println("done");
            
        }

    
    
    public static BinaryNode[] load(String str) throws FileNotFoundException{
        File archivo=null;
        FileReader lector=null;
        BufferedReader br=null;
        Queue<String> fila=new Queue();
        try{
            archivo=new File(str);
            lector=new FileReader(archivo);
            br=new BufferedReader(lector);
            String linea;
            while((linea=br.readLine())!=null){
                if(linea.equalsIgnoreCase("\n"))
                    fila.offer("null");
                else
                    fila.offer(linea.substring(0, linea.length()-2));
            }
        }
        catch(FileNotFoundException ex){
            throw new FileNotFoundException();
        } catch (IOException ex) {
            System.out.println("hubo un error");
        }
        finally{
            try {
                lector.close();
            } catch (IOException ex) {
                System.out.println("hubo un error");
            }
        }
        BinaryNode[] resultado=new BinaryNode[fila.size()];
        int contador=0;
        while(fila.isEmpty()){
            if(!fila.element().equalsIgnoreCase("null"))
                resultado[contador]=new BinaryNode(fila.remove());
            contador++;
        }
        int hijos;
        for(int i=0;i<resultado.length;i++){
            hijos=2*i+1;
            if(hijos>=resultado.length)
                resultado[i].LC=null;
            else{
                if(resultado[hijos]==null)
                    resultado[i].LC=null;
                else
                    resultado[i].LC=resultado[hijos];
            }
            hijos++;
            if(hijos>=resultado.length)
                resultado[i].RC=null;
            else{
                if(resultado[hijos]==null)
                    resultado[i].RC=null;
                else
                    resultado[i].RC=resultado[hijos];
            }
            
        }
        return resultado;
    }
    
    public static void save(BinaryNode root) throws IOException{
        BufferedWriter s=null;
        try {
        File arbol=new File("memory.txt");
        if(!arbol.exists())
            arbol.createNewFile();
        FileWriter w=new FileWriter(arbol);
        s=new BufferedWriter(w);
        //s.write(str);
        } 
        catch (IOException E) {
            throw new IOException(E);
        }
        finally{
            s.close();
        }
    }
    
    
}

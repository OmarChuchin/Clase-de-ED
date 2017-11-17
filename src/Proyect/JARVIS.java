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
        BinaryNode root;
        try{
            root=load("memory.txt");
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
        System.out.println("done");
            
        }

    
    
    public static BinaryNode load(String str) throws FileNotFoundException{
        File archivo=null;
        FileReader lector=null;
        BufferedReader br=null;
        Queue<String> fila=new Queue();
        try{
            archivo=new File(str);
            lector=new FileReader(archivo);
            br=new BufferedReader(lector);
            String linea;
            while((linea=br.readLine())!=null)
                System.out.println(linea);
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
        
    }
    
    public static void save(String str) throws IOException{
        BufferedWriter s=null;
        try {
        File arbol=new File("memory.txt");
        if(!arbol.exists())
            arbol.createNewFile();
        FileWriter w=new FileWriter(arbol);
        s=new BufferedWriter(w);
        s.write(str);
        s.close();
        } 
        catch (IOException ex) {
            throw new IOException(ex);
        }
        finally{
            s.close();
        }
    }
    
    
}

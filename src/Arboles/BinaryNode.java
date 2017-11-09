/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

/**
 *
 * @author omar
 */
public class BinaryNode {
    public BinaryNode LC,RC;
    public int value;
    
    public BinaryNode(int val){
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
}

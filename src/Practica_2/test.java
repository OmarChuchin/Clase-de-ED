
package Practica_2;

/**
 *
 * @author omar
 */
public class test {
    public static void main(String[] args) {
        SLinkedList<Integer> i = new SLinkedList<Integer>();
        System.out.println(i.isEmpty());
        System.out.println(i);
        for(int x=0;x<10;x++){
            i.addLast(x);
        System.out.println(i);}
        while(!i.isEmpty()){
            System.out.println(i);
            i.removeLast();
        }
    }
    
}

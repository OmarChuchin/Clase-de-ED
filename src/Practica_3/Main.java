package Practica_3;

import java.util.NoSuchElementException;


public class Main {
	
	public static void main(String[] args) {
            /*
		ArrayList<Integer> iList = new ArrayList<Integer>();

		System.out.println("Testing toString");
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing addFirst(i | 0 <= i < 10) + toString");
		for(int i=0; i<10; i++) {
			iList.addFirst(i);
			System.out.println(iList);
		}
		System.out.println();
		
		System.out.println("Testing add(0, 10) + toString");
		iList.add(0, 10);
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing add(size(), -1) + toString");
		iList.add(iList.size(), -1);
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing add(3, 20) + toString");
		iList.add(3, 20);
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing add(5, 15) + toString");
		iList.add(5, 15);
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing add(7, 13) + toString");
		iList.add(7, 13);
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing add(9, 11) + toString");
		iList.add(9, 11);
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing getFirst");
		System.out.println("First element: " + iList.getFirst());
		System.out.println();
		
		System.out.println("Testing getLast + toString");
		System.out.println("Last element: " + iList.getLast());
		System.out.println();
		
		System.out.println("Testing get(5) + toString");
		System.out.println("Element at index 5: " + iList.get(5));
		System.out.println();
		
		System.out.println("Testing set(8, 33) + toString");
		System.out.println("Element at index 8 before inserting 33: " + iList.set(8, 33));
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing clear + toString");
		iList.clear();
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing addLast(i | 0 <= i < 10) + toString");
		for(int i=0; i<10; i++) {
			iList.addLast(i);
			System.out.println(iList);
		}
		System.out.println();
                */
            int[] prueba = {20,2,12,8,15,92,64,200,0,-15};
            for(int i=0;i<prueba.length;i++){
                System.out.print(prueba[i]);
                System.out.print(" ");}
            System.out.println("");
            selectionSort(prueba);
            for(int i=0;i<prueba.length;i++){
                System.out.print(prueba[i]);
                System.out.print(" ");}
        }
        
        public static void shiftRight(int[] val,int start,int end){
            if (val.length==0)
                throw new NoSuchElementException("the list is empty");
            else if(start<0 || end>=val.length)
                throw new IndexOutOfBoundsException("the list is empty");
            else if(end==val.length-1 || start==end)
                System.out.println("DONE");
            else{
                for(int current=end;current>start;current--)
                    val[current]=val[current-1];
                }
        }/*
        public static int linearSearch(int[] arreglo, int objetivo){
            for(int i=0;i<arreglo.length;i++){
                if(arreglo[i]==objetivo)
                    return i;
                else if(arreglo[i]>objetivo)
                    return -1;
            }
            return -1;
        }
        public static int binarySearch(int[] arreglo,int objetivo){
            int min=0,max=arreglo.length-1,val,check=-2;
            if(objetivo<arreglo[min] || objetivo>arreglo[max])
                return -1;
            while (min<max){
                val=min+(max-min)/2;
                System.out.println(val);
                if(objetivo<arreglo[val])
                    max=val;
                else if (objetivo>arreglo[val])
                    min=val;
                else
                    return val;
                if(check==val)
                    break;
                check=val;
            }
            return -1;
        }*/
        public static void insertionSort(int[] arreglo){
            if(arreglo.length==0)
                throw new NoSuchElementException("la lista esta vacia");
            else{
                int tamanio=1,valor;
                for(int i=1;i<arreglo.length;i++){
                    valor=arreglo[i];
                    for(int j=0;j<tamanio;j++){
                        if(valor<arreglo[j]){
                            shiftRight(arreglo,j,tamanio);
                            arreglo[j]=valor;
                            break;
                        }
                    }
                    tamanio++;
                }
                System.out.println("DONE");
            }
        }
        public static void selectionSort(int[] arreglo){
            if(arreglo.length==0)
                throw new NoSuchElementException("la lista esta vacia");
            else{
                int peque,cambio;
                for(int i=0;i<arreglo.length;i++){
                    peque=arreglo[i];
                    for(int j=i;j<arreglo.length;j++){
                        if(peque>arreglo[j]){
                            cambio=peque;
                            peque=arreglo[j];
                            arreglo[j]=cambio;
                        }
                    arreglo[i]=peque;
                    }
                }
            }
        }
}

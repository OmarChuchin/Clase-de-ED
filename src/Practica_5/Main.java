package Practica_5;
import java.util.Arrays;
import java.lang.String;

public class Main {
	public static void main(String[] args) {
		
		/*System.out.println("Testing array reversing");
		int[] inputArray = {1, 2, 3, 4, 5};
		
		// TODO: push every item in inputArray into a Stack
                Stack<Integer> st=new Stack();
                for(int i=0;i<inputArray.length;i++)
                    st.push(inputArray[i]);
		
		int[] outputArray = new int[inputArray.length];
		
		// TODO: pop every item in inputArray and save them in outputArray
                for (int i=0;i<outputArray.length;i++)
                    outputArray[i]=st.pop();
		
		System.out.println("Input: " + Arrays.toString(inputArray));
		System.out.println("Output: " + Arrays.toString(outputArray));
		System.out.println();
		
		System.out.println("Testing train ordering");
		Stack<Integer> train = new Stack();
		train.push(3);
		train.push(2);
		train.push(1);
		train.push(3);
		train.push(2);
                
		Stack<Integer> st2=new Stack();
                Stack<Integer> st3=new Stack();
		System.out.println("Train as it arrived to the station: " + Arrays.toString(train.toArray()));
		
		// TODO: sort the wagons in priority order
                while(!train.empty()){
                    int peek=train.peek();
                    switch (peek) {
                        case 1:
                            st.push(train.pop());
                            break;
                        case 2:
                            st2.push(train.pop());
                            break;
                        default:
                            st3.push(train.pop());
                            break;
                    }
                }
                while(!st.empty())
                    train.push(st.pop());
                while(!st2.empty())
                    train.push(st2.pop());
                while(!st3.empty())
                    train.push(st3.pop());
		
		System.out.println("Train ordered by priority: " + Arrays.toString(train.toArray()));
		System.out.println();
		
		Stack<Integer> towerOne = new Stack<Integer>();
		Stack<Integer> towerTwo = new Stack<Integer>();
		Stack<Integer> towerThree = new Stack<Integer>();
		
		towerOne.push(3);
		towerOne.push(2);
		towerOne.push(1);
		
		System.out.println("At the beginning");
		System.out.println("Hanoi tower #1: " + Arrays.toString(towerOne.toArray()));
		System.out.println("Hanoi tower #2: " + Arrays.toString(towerTwo.toArray()));
		System.out.println("Hanoi tower #3: " + Arrays.toString(towerThree.toArray()));
		
		// TODO: run a simulation so that towerTwo ends with all discs in correct order.
                towerTwo.push(towerOne.pop());
                towerThree.push(towerOne.pop());
                towerOne.push(towerTwo.pop());
                towerTwo.push(towerThree.pop());
                towerTwo.push(towerOne.pop());
                towerThree.push(towerOne.pop());
                towerOne.push(towerTwo.pop());
                towerThree.push(towerTwo.pop());
                towerThree.push(towerOne.pop());
                
		
		System.out.println("At the end");
		System.out.println("Hanoi tower #1: " + Arrays.toString(towerOne.toArray()));
		System.out.println("Hanoi tower #2: " + Arrays.toString(towerTwo.toArray()));
		System.out.println("Hanoi tower #3: " + Arrays.toString(towerThree.toArray()));
		System.out.println();
	}*/
          
}
            public static boolean checkforbalance(String str){
                char[] arreglo=str.toCharArray();
                Stack dep=new Stack();
                for(int i=0;i<arreglo.length;i++){
                    if(arreglo[i]=='{'||arreglo[i]=='('||arreglo[i]=='[')
                        dep.push(arreglo[i]);
                    else if (arreglo[i]=='}'){
                        char val=(char) dep.pop();
                        if(val!='{')
                            return false;
                        else
                            dep.p;
                    }
                }
            return true;
        }  
}

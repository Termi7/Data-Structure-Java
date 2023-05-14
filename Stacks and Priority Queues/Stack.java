/** This class name is stack and contains all informations of the stack : the parameter, the size, the push method, the pop method, the isEmpty and the isFull method
  *
  *
  * @author <Aboubacar Abdoulaye Soumana>
  * * @version <10/23/2021>
  */
package source;

public class Stack {
	 
	
	private State[] states;
	private int top ;
	private int maxSize = 0;
	/**
     * The stack constructor
     * @param size Initial size of the array
     * @return no return value
     */
	public Stack(int size){

        maxSize = 50;
        states = new State[size];
        top = -1;
    }

    
	/**
     * Inserts new item at the end  of the stack
     * @param state
     * @return top 
     */
    public int push(State state){
        if(isFull()){
            System.out.println("Stack is full");
        }else{
            states[++top] = state;
       }
       return top;
       
    }

    
    /**
     * Removes top most item from the stack
     * @param  no parameter
     * @return states[top--]
     * 
     */
    public State pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }else{
            return states[top--];
        }
    }
    
    /**
     * Displays all items in the stack
     * @param  no parameter
     * @return  no parameter
     */
    public void printStack(){
    	System.out.println("\nStack Contents:");
        System.out.println("Name                   MHI     VCR    CFR     Case Rate   Deaths Rate");
        System.out.println("---------------------------------------------------------------------"); 
    	
        for(int i = top; i >=0; i--){
             System.out.println(states[i].toString());
             
    
    	}
       
    }    
    /**
     * this method returns false if stack is not full, true otherwise
     * @return true or false
     * @param no parameter
     */
    public boolean isFull(){

        if(top ==  maxSize-1 ){
            return true;
        }else {
            return false;
        }
    }
   /**
    * this method returns false if stack is not empty, true otherwise
    * @return true or false
    * @param no parameter
    */
    public boolean isEmpty(){
        if(top == -1){
            return true;
        }else {
            return false;
        }
    }
    
    
}
    







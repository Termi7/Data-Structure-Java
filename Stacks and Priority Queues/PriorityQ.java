/** This class name is priorityQ and contains all informations of the priority queue : the parmater, the size, the insert method, the remove method, the isEmpty and the isFull method
  *
  *
  * @author <Aboubacar Abdoulaye Soumana>
  * * @version <10/08/2021>
  */
package source;

public class PriorityQ {


		
		private State[] states;
		private int maxSize = 0;
		private int nItems;
		
		
		/**
	     * Priority Constructor
	     * @param size the size of the queue
	     *@return no return value
	     */
	    public PriorityQ(int size){

	  
	        this.maxSize = size;
	        states = new State[size];
	        nItems=0;
	    }
	    
	    
	    /**
	     * It inserts new state at the end of the queue
	     * @param state
	     * @return nItems
	     */
	    public int insert(State state){
	        int j;
	    	if(nItems==0){
	    		states[nItems++] = state;
	    	}else {
	    		for(j=nItems-1; j>=0; j--) {
	    			if(((double)state.getCovid19Deaths()*100000/state.getPopulation()) > ((double)states[j].getCovid19Deaths()*100000/states[j].getPopulation())) {
	    				states[j+1] = states[j];
	    				
	    				
	    			}
	    			else
	    				break;
	    		}
	    		states[j+1] = state;
	    		nItems++;
	    		
	        
	        		
	        	}
	    	    return nItems;
	    	
	        
	    }	
	    
	    /**
	     * It removes the the highest priority value in the queue
	     * @param no parameter
	     * @return states[--nItems], or null in case the state is empty 
	     */
	    public State remove() {
	    	if(!(isEmpty())) {
	    		return states[--nItems];
	    		
	    		
	    	}
			return null;
	    }
	   
	    
	    
	    
	    /**
	     * It displays all states in the queue
	     * @param no parameter
	     * @return no return
	     */
	    
	    public void printQueue(){
	    	System.out.println("Priority Queue Contents:");
	    	System.out.println("Name                   MHI     VCR    CFR     Case Rate   Deaths Rate");
	        System.out.println("----------------------------------------------------------------------");
	    	
	        for(  int j=nItems-1; j>=0; j--){
	             System.out.println(states[j].toString());
	             
	    }
	              
	    }  
	    
	    
	    /**
	     * this method returns false if queue is not full, true otherwise
	     * @param no parameter
	     * @return true or false 
	     */
	    public boolean isFull(){
	        if( nItems == maxSize){
	            return true;
	        }else{
	            return false;
	        }
	    }
        
	    /**
	     * this method returns false if queue is not empty, true otherwise
	     * @param no parameter
	     * @return true or false 
	     */
	    public boolean isEmpty(){
	        if(nItems==0){
	            return true;
	        }else {
	            return false;
	        }
	    }




}

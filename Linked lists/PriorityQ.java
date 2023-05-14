/**
* this program contain the information of the priority q the insert ,  the remove method  and the interval delete method
*
* @author <Aboubacar Abdoulaye>
* @version <10/23/2021>
*/
package source;

import source.Stack.Link;

public class PriorityQ {
	class Link {

        private State states;

        private Link next;
        private  Link prev;
        
       
        
        /**
         * this method actualize the state object in the link
         * @return no return
         * @param State state
         */
        public Link(State state) {

           states = state;
            }
        /**
         * this method displayLink display the information a single link
         * @return no return
         * @param no parameter
         */
        public void displayLink() // display this link
        { System.out.println(states.toString()); }
        
        public State getState() {

            return states;
        }
        
       

      
  }

	   private Link  first;
       private int count;    
       private Link last;
       
        
       /**
        * this method Queue  contain the parameter and variable as a well the first and last element of the priority
        * @return no return
        * @param no parameter
        */

        public void Queue() {

              first = null;

              last = null;

        }
        /**
         * this method returns false if stack is not empty, true otherwise
         * @return true or false
         * @param no parameter
         */
        public boolean isEmpty() {

            return (first == null);
        }
        /**
         *this method is name  insert  and insert  a state object to the priority q and aslo take care of the sorting
         *
         * @param State states
         * @return  no return
         */
        public void insert(State states) {
        	
        	
        	// Create new node
        	Link newLink = new Link(states);
            Link prev = null;
            Link current = first;

            double deaths = (double)states.getCovid19Deaths()*100000/states.getPopulation();
            double currentDeath = 0;
            if (current!=null)
                currentDeath= (double)current.getState().getCovid19Deaths()*100000/current.getState().getPopulation();
           // System.out.println("deaths = "+deaths + " currentDeath ="+currentDeath);
            while (current != null && deaths > currentDeath) {
            	prev = current;
                current = current.next;
                if (current!=null)
                    currentDeath = (double)current.getState().getCovid19Deaths()*100000/current.getState().getPopulation();
            }

            if (prev == null) {
                first = newLink;
                newLink.prev = null;
            } else {
                prev.next = newLink;
                newLink.prev = prev;
            }
            newLink.next = current;
            if (current != null) {
                current.prev = newLink;
            }
        }
            
            
            	
            
            

      
        
        /**
        *this method is name is recursion :It contain a recursion that display the value of list through recursion
        *
        * @param the Link name
        * @return  no return
        */
        public void recursion (Link name)
        {
             if (name!=null)
             {
          	   name.displayLink();
          	   recursion(name.next);
          	   
             }
        }
        
        
        /**
         *this method is name is name is printPriority and print the contain of priority 
         *
         * @param no parameter
         * @return  no return
         */
        public void printPriority() {
      	  System.out.println("\nPriority Queue Contents:");
            System.out.println("Name                   MHI     VCR    CFR     Case Rate   Deaths Rate");
            System.out.println("---------------------------------------------------------------------"); 
         // Get the top most element
      	  
      	  Link name = first;
      	  recursion(name);
      	  
      	  
      	  
        }
        
        
        /**
         *this method is name is name remove and remove a link  object temp  from the priority q
         *
         * @param Link temp
         * @return  no return
         */
        public Link remove(Link temp)
        { 
        	temp = first; 
        	first = first.next; 
        	
        	return temp; 
        	}
        
        /**
         * this method delete from the priority q states object with Covid DR belonging to the user input.
         * @return no return
         * @param State state
         */
        public boolean  intervalDelete(double x, double y) 
       
        
        {
        	
        	Link current = first;
        	double currentDeath = 0;
            if (current!=null)
                currentDeath= (double)current.getState().getCovid19Deaths()*100000/current.getState().getPopulation();
            //System.out.println( " currentDeath ="+currentDeath);
            if(current != null  ) {
        	  while (current != null && currentDeath>= x && currentDeath <=y) {
        			
        		remove(current);
        		current = current.next;
                if (current!=null)
                    currentDeath = (double)current.getState().getCovid19Deaths()*100000/current.getState().getPopulation();
        		
        		}  
        		return true ;
        	
        }
			return false;
			
        
        }

}       


        
        
        
        
     
	



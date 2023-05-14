/**
* This class stack implemt a stack of state objects using a double ended singled singly linked list. It contain the constructor  push method, a pop method
* , a printstack, and is Empty method, that print the information in the stack 
*
* @author <Aboubacar Abdoulaye>
* @version <10/23/2021>
*/
package source;


public class Stack {

	// Inner class

    class Link {

          private State states;

          private Link next;
          
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
          
          
          
          
         

         
    }
          
          // instantces variables
          private Link  first;
          private int count;    
          private Link last;
	
          /**
           * this method Stack  contain the parameter as a well the first  last element of the priority, and a count variable
           * @return no return
           * @param no parameter
           */
          public Stack() {

              first = null;
             last = null;

              count = 0;

        }
          /**
           * this method returns false if stack is not empty, true otherwise
           * @return true or false
           * @param no parameter
           */
          public boolean isEmpty() {

              return  (first==null)  ;
              
              
              }
          
         

          /**
           * Inserts new item at the end  of the stack
           * @param state
           * @return count 
           */
          
          public int push(State state) {

              // Create new node

            Link newLink = new Link(state);

              // Check if stack is empty

              if (isEmpty()) {
            	  last = newLink;
                    first = newLink;
                    
                   
              } else {
            	  newLink.next = first; 
            	  first = newLink; 

                    
              }

              // Increment count

              count += 1;
              return count;

        }
          
              
          /**
           * Removes top most item from the stack
           * @param  no parameter
           * @return temp
           * 
           */
          
          public State pop() // delete first link
          { // (assumes non-empty list)
        	 State temp = first.states;
        	  if(first.states== null)
        		 last = null; // null <-- last
        	  first = first.next; // first --> old next
        	  return temp;
        	  
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
           *this method is name is name is printStack() and print the contain of priority 
           *
           * @param no parameter
           * @return  no return
           */
          void printStack() {
        	  System.out.println("\nStack Contents:");
              System.out.println("Name                   MHI     VCR    CFR     Case Rate   Deaths Rate");
              System.out.println("---------------------------------------------------------------------"); 
           // Get the top most element
        	  
        	  Link name = first;
        	  recursion(name);
        	  
        	  
        	  
          }
              
              
              
          
    }         

	 
	
	
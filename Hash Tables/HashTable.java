/** 
 *This is class is name HashTable and contain all the information of the hash table including the node class , the linklist class , the method for insert , find . delete display and printEmptyAndCollidedCells.  
* 
 * @author <Aboubacar Abdoulaye> 
 * @version <12/10/2021> 
 */ 
package sources;



public class HashTable {

	
	
	
	private class Node { 
		String name; 
		long population; 
		long deaths; 
		Node nextNode; 
		 
		/**
		* information of node class and its components 
		* 
		* @param name, population and deaths
		* @return no return
		*/
		public Node(String name, long population, long deaths) { 
		this.name = name; 
		this.population = population; 
		this.deaths = deaths; 
		   } 
		/**
		*  print a node
		* 
		* @param no parameter
		* @return no return 
		*/
		   public void printNode() { 
			   System.out.printf("%-30s%-20.2f\n",name,(double)deaths/population*100000);
		   } 
		} 
	
	class linklist
	{
		private Node first; 
		private Node last;
		public  linklist() 
		{
			first = null; 
			last = null;
		}
		
		/**
		*  check to see if  the link is empty 
		* 
		* @param  no parameter
		* @return first
		*/
		public boolean isEmpty() 
			{ return first==null; }
		
		/**
		* insert in a linklist 
		*  
		* @param state, population and deaths
		* @return no return
		*/
		public void insertlink(String state, long population, long deaths)  
		{
			Node newNode = new Node(state, population, deaths);
			
			if( isEmpty() ) {
				first = newNode;
				//freeSpaces++;
			}else
				last.nextNode = newNode;
			last = newNode;
		}
		
		 
		/**
		* display a  link list
		* 
		* @param no parameter
		* @return no return
		*/
		public void displayList()
			{
			
			Node current = first; // start at beginning of list
			
			if(current == null) {
				System.out.print("Empty\n");
				//System.out.println("");
				
				
			}
			
			else {
				
			
				
				while(current != null) // until end of list,
				{
					
					current.printNode(); // print data
					//System.out.println("");
					
					System.out.printf("%5s"," ");
					
					
					current = current.nextNode; // move to next link
					
			
			}
			
				
			
			}
			
			}
		 	
	 
	}
	int freeSpaces;
	private linklist[] hashArray;
	private int arraySize;
	public HashTable(int size)
	{
		arraySize = size= 101;
		hashArray = new linklist[arraySize]; // create array
		for(int j=0; j<arraySize; j++) // fill array
			hashArray[j] = new linklist(); // with lists
		
	}
	/**
	*  display the hash  table 
	* 
	* @param no parameter
	* @return no return
	*/
	public void displayTable()
	{
		for(int j=0; j<arraySize; j++) 
		{// for each cell,
			System.out.print(j + ".  " ); // display cell number
			hashArray[j].displayList(); // display list
			
			System.out.println("");
		}
			
	}
	
	/**
	*  insert in the hash table
	* 
	* @param state, population and deaths
	* @return no return
	*/
	public void insert(String state, long population, long deaths)   // insert a link
	{
		 int hash = toUnicodeModulus(state);
		
		hashArray[hash].insertlink(state, population, deaths); // insert at hashVal
		} // end insert()
	
	
	
	
	
	 
	/**
	*  hash function, find the hash value by combining the different character
	* 
	* @param state
	* @return hash % 101 
	*/
	
	private int toUnicodeModulus(String state) {
	        int hash = 0;

	        for (char c : state.toCharArray()) {
	            hash += c;
	        }

	        return hash % 101;
	    }
	
	
	/**
	*  print the numbers of empty spaces and collision in the hash table 
	* 
	* @param no parameter
	* @return no return
	*/
	
	 public void printFreeAndCollisions() {

	        int freeSpaces = 0, collisions = 0;

	        Node current;
	        for(int i = 0; i < this.hashArray.length; i++) {
	            current = hashArray[i].first;

	            if(current == null) {
	            	freeSpaces++;
	            }
	            else {
	                if(hashArray[i].first != hashArray[i].last) {
	                    collisions++;
	                }
	            }
	        }
        System.out.println("There are " + freeSpaces + " empty and  " + collisions + " collided cells in the hash table.");
    }

	
	/**   
	*  delete a state in the hash table 
	* 
	* @param state
	* @return no return
	*/
	public void delete(String state) {
		
		int hash = toUnicodeModulus(state);
		 if(hashArray[hash].first == null) {
	            System.out.printf("%s is not a state\n", state);
		        return;}
	     if(hashArray[hash].first.name.compareToIgnoreCase(state) == 0) {
	    	 System.out.printf("%s was found and is deleted from the table!\n", state);
	    	 hashArray[hash].first = hashArray[hash].first.nextNode;
	    	 return;
	     }
	            
	        
			
		
	     	Node current = hashArray[hash].first;
	     	while(true) {
	     		if(current.nextNode == null) {
	     			System.out.printf("%s is not a state\n", state);
	     			return;
        
	}
	     		else if(current.nextNode.name.compareToIgnoreCase(state) == 0) {
	     			System.out.printf("%s is deleted from hash table\n", state);
	     			current.nextNode = current.nextNode.nextNode;
	     			//freeSpaces++;
	     			
	     			return;
	     		} 
	     		else {
	     			current = current.nextNode;
	     		}
	     	}
	
	}
	
	/**
	*  find a state in the hash table by using the state name
	* 
	* @param  state
	* @return -1, index
	*/
	public int find(String state) {
		double output;
		int index=0;
		 int hash = toUnicodeModulus(state);
		 Node current =hashArray[hash].first;
		 while(true) {
	            if(current == null) {
	            	 System.out.println(state + " is not found");
	            	output = -1;
	            	return -1;
	            } 
	            else if(current.name.compareToIgnoreCase(state) == 0){
	            	
	            	 output = (double)current.deaths/current.population*100000;
	            	 index =indexValue( state);
	            	System.out.printf("%s is found at index %d  with  DR of %.2f", state , index, output);
	            	
	            	break;
	            }
	            else {
	            	current = current.nextNode;
	            }
		 }
		 return index;
	}
	
	
	
	/**
	*  find the index value of the concerning state and return his value
	* 
	* @param state
	* @return 0,i
	*/
	public int indexValue(String state)
			{
		int hash = toUnicodeModulus(state);
		 Node current;
		//int index=0;
		for(int i = 0; i < this.hashArray.length; i++)// fill array
		{
			 
			current = hashArray[i].first;
			
			 if (current==hashArray[hash].first) {
				 return i;
			 }
		}
		return 0;
				
		
			}
	
	
	
}	
	
	
	
	



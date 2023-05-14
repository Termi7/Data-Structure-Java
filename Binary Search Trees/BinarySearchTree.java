
/**
* This class is named and contain all the informations of the binary search tree including the method for traversal finding , deleting
*  and printing top or bottom states.
*
* @author <Aboubacar Abdoulaye>
* @version <11/19/2021>
*/

package sources;
import java.util.Scanner;
import java.util.*;
public class BinarySearchTree {

	
	private Node root;
	
	/**
	* information of binary tree and setting the root is equal zero
	* 
	* @param no parameter
	* @return no return
	*/
	public BinarySearchTree() // constructor
	{ root = null; }
	
	/**
	* insert the data in binary tree
	* 
	* @param string id and double dd
	* @return no return
	*/
	public void insert(String id, double dd) {
		Node newNode = new Node(id, dd); // make new node
		newNode.stateName = id; // insert data
		newNode. DR = dd;
		
		if(root==null) // no node in root
			root = newNode;
		else
		{
			Node current = root; // start at root
			Node parent;
			//System.out.println("names = "+id);
			while(true)
			{
				parent = current;
				if(id.compareTo(current.stateName) < 0)
				{
					current = current.leftChild;
					if(current == null) // if end of the line,
					{ // insert on left
						parent.leftChild = newNode;
						return;	
					}
						
					
				}
				else  {
					current = current.rightChild;
					if(current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}   
		}
	}
	
	
	/**
	* find a specific state and display it's path
	* 
	* @param name
	* @return -1 and current.DR 
	*/
	public double find(String name) {
		Node current = root;
		boolean notFound = false;
		//System.out.printf("Washington is found with death rate of\n", current.DR);
		//System.out.print("Path to Washington is");
		//System.out.print(current.stateName);
		//System.out.print("->");
		
		while( name.compareToIgnoreCase(current.stateName)!=0)	{
			if (!(notFound)) {
			System.out.printf("",name +"is found with death rate of\n", current.DR );
			System.out.print(current.stateName);
			System.out.print("->");
			}
			if(name.compareToIgnoreCase(current.stateName) < 0) 
				current = current.leftChild;
			else 
				
				current = current.rightChild;
			
			
			if(current == null) { 
				System.out.println( "\n "+ name+" is not found.");
				notFound=false;
				
				return -1;
				
				
			}
			
			/*if (!(notFound)) {
			System.out.printf("",name +"is found with death rate of\n", current.DR );
			//System.out.printf("Path to "f" is");
			System.out.print(current.stateName);
			System.out.print("->");  
			}	*/
			
	   
		}System.out.print(current.stateName);
			return  current.DR;	
		
}	
	
	/**
	* delete a state from the tree
	* 
	* @param name
	* @return boolean 
	*/
	public boolean delete(String name) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while( name.compareToIgnoreCase(current.stateName)!=0) {
			parent = current;
			if(name.compareTo(current.stateName) < 0){
				isLeftChild = true;
				current = current.leftChild;
			}
		   else {
			   isLeftChild = false;
			   current = current.rightChild;
		}
		   if(current == null)
			   return false;
		   
	   }// end while 
		// found node to delete
		
	
		// if no children, simply delete it
		
		if(current.leftChild==null && current.rightChild==null) {
			if(current == root) // if root,
				root = null;
			else if(isLeftChild)
				parent.leftChild = null; // disconnect
			else // from parent
				parent.rightChild = null;
		}
	
		// if no right child, replace with left subtree
		else if(current.rightChild==null)
			if(current == root)
				root = current.leftChild;
			else if(isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		
		// if no left child, replace with right subtree
		else if(current.leftChild==null)
			if(current == root)
				root = current.rightChild;
			else if(isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
	
		else // two children, so replace with inorder successor
		{
			// get successor of node to delete (current)
			Node successor = getSuccessor(current);
		   // connect parent of current to successor instead
			if(current == root)
				root = successor;
			else if(isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			
			// connect successor to current’s left child
			successor.leftChild = current.leftChild;
			} // end else two children
			// (successor cannot have a left child)
	
		return true; // success
	} // end delete()
	
	
	// returns node with next-highest value after delNode
	// goes to right child, then right child’s left descendents
	/**
	* find the succerser of the parent state
	* 
	* @param delNode
	* @return node successor
	*/
	private Node getSuccessor(Node delNode)
	{
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild; // go to right child
		while(current != null)
		{ // left children,
			successorParent = successor;
			successor = current;
			current = current.leftChild; // go to left child
			}	
		if(successor != delNode.rightChild) // right child,
		{ // make connections
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
		}
	
	/**
	* print inorder 
	* 
	* @param no parameter
	* @return no return
	*/
	public void printInorder() {
	        if (root == null) {
	            return;
	        }

	        inOrder(root);
	    }
	
	/**
	* print inorder
	* 
	* @param no parameter
	* @return no return
	*/
	private void inOrder(Node localRoot)
	{
		if(localRoot != null)
			{
			inOrder(localRoot.leftChild);   
			localRoot.printNode();
			inOrder(localRoot.rightChild);
			}
	}
	
	/**
	* print preorder
	* 
	* @param no parameter
	* @return no return 
	*/
	public void printPreorder() {
        if (root == null) {
            return;
        }

        preOrder(root);
    }
	
	
	/**
	* print preorder
	* 
	* @param no parameter
	* @return no return 
	*/
	private void preOrder(Node localRoot)
	{
		if(localRoot != null)
			{
			localRoot.printNode();
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
			}
	}
	
	/**
	* print postorder
	* 
	* @param no parameter
	* @return no return
	*/
	public void printPostorder() {
	        if (root == null) {
	            return;
	        }

	        postOrder(root);
	    }
	
	  
	/**
	* print postorder
	* 
	* @param no parameter
	* @return no return
	*/
	private void postOrder(Node localRoot)
	{
		if(localRoot != null)
			{
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			localRoot.printNode();
			}
	}


	/**
	* print bottom states 
	* 
	* @param no parameter
	* @return int c
	*/
	public void printBottomStates(int c) {
		 
		 
		  
		 if (root == null) {
	            return;
	        }

		 findMax(root,c);
	    
	  
	  
	 }	  
      
	/**
	* find the states with highest DR
	* 
	* @param no parameter
	* @return int c
	*/
	public void findMax(Node localRoot, int c) {
    	double Maxdr=50;
    	//double[] drvalues;
    	double[] drvalues = new double[c];
    	int i = 0;
    	
    	if(localRoot == null)
		return;
    		
    	   
    	
    	 findMax(localRoot.leftChild, c);
    	while (i<c) {
    		//localRoot.printNode();
    		if (localRoot.DR>=Maxdr ) {
    			//System.out.print(localRoot.DR);
    			Maxdr=localRoot.DR;
    			drvalues[i]=Maxdr;
    			
    		i++;
    			
    		};
    			
    		
    	}
    	 findMax(localRoot.rightChild, c);
		
		
    		
    	for(int j=0; j<c; j++) // for each element,
    		System.out.printf("%.2f\n", drvalues[j]);
    

    }
		
	/**
	* print top states
	* 
	* @param no parameter
	* @return  int c
	*/
    
	public void printTopStates(int c) {
			  
		  
		if (root == null) {
		          return;
		       }

			findMax(root,c);
		    
			
		}
		
		
		
		
    /**find the states with lowest DR
	* 
	* @param no parameter
	* @return  int c
	*/
	public void findMin(Node localRoot, int c) {
	    double Maxdr=50;
	    //double[] drvalues;
	    double[] drvalues = new double[c];
	    int i = 0;
	    	
	    if(localRoot == null)
	    	return;
			
	    		
	    	   
	    	
	    	findMin(localRoot.leftChild, c);
	    	//localRoot.printNode();
	    	 if (localRoot.DR>Maxdr ) {
	      		//System.out.print(localRoot.DR);
	      		Maxdr=localRoot.DR;
	      		drvalues[i]=Maxdr;
	  			 i++;}
	    	 findMin(localRoot.rightChild, c);
			
			}
		}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


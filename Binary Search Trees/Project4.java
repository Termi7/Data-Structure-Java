
/**
* COP 3530: Project 4 – Binary Search Trees
* <p>
* This class read from a file and copy the informations in a binary search search tree. it also display a menu option 
* containing the print the tree inorder, preorder an postorder, It also allow to delete a state from a binary tree and
* , search and find a path of state in the tree. also it allow to print the top and bottom states . The users input are the choice
* for the menu and states entry for the deletion . The program also request the file name at the begining. 
* 
* @author <Aboubacar Abdoulaye>
* @version <11/19/2021>
*/
package sources;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;



public class Project4 {
	static Scanner kb = new Scanner(System.in) ;
	
	public static void main(String[] args) {
		
		
		boolean inputError = false;
		String userInput1 = null;
		int userInput = 0;
    	//boolean inputError = false;
		//String userInput1 = null;
		//int userInput = 0;
		System.out.println("COP3530 Project 4\n");
		System.out.println("Instructor: Xudong Liu\n");
		
		System.out.println("Binary Search Trees\n"); 
		
		System.out.print("Please enter the file name:\n ");
		
		String fileName= kb.next();
		//System.out.println(fileName);
		
		while (!fileName.equals("States4.csv")) {
			System.out.print("Please enter the correct file name:\n ");
			 fileName= kb.next();
		}
	
		
		Scanner inFile = null;
		try 
		{
			inFile = new Scanner ( new File(fileName));
			
			
		}
		
	    catch (FileNotFoundException e)
		{
	    	System.out.println("\n Could not open the file!");
	    	System.exit(1);
	    	
		}
		//inFile.useDelimiter(",|\n");
		inFile.useDelimiter(",|\r\n|\n");
		
		BinarySearchTree bst = new BinarySearchTree();
		
	
		inFile.nextLine();
		int lines=0;
		
		
		while (inFile.hasNext()) {
			
			State states = new State();
			states.setStateName(inFile.next());
			states.setCapitol(inFile.next());
			states.setRegion(inFile.next());
			states.setUsHouse(inFile.nextInt());
			states.setPopulation(inFile.nextInt());
			states.setCovid19Cases(inFile.nextInt());
			states.setCovid19Deaths(inFile.nextInt());
			states.setMedHouseholdIncome(inFile.nextInt());
			states.setViolentCrimeRate(inFile.nextFloat());
			
			double deaths = (double)states.getCovid19Deaths()*100000/states.getPopulation();
			bst.insert(states.getStateName(),deaths);
			
			lines++;
		}
		System.out.println("\nThere were " +( lines ) + "  records read to build a binary search tree.\n");
		
		do {
			   
			 try {   
			
				System.out.println("\n1. Print tree inorder\n");
				System.out.println("2. Print tree preorder\n");
				System.out.println("3. Print tree postorder\n");
				System.out.println("4. Delete a state for a given name\n");
				System.out.println("5. Search and print a state and its path for a given name.\n");
				System.out.println("6. Print bottom states regarding DR\n");
				System.out.println("7. Print top states regarding DR\n");
				System.out.println("8. Exit\n");
				System.out.print("Enter your choice: \n");
				
				userInput1= kb.next();
			    NumberFormat.getInstance().parse(userInput1);
			    userInput = Integer.parseInt(userInput1);
			    
			 }
			   catch(ParseException e) {
				   inputError = true;
				   
			   }
			 
			 if ( userInput<=0 || userInput>=9) {
			    	inputError= true;
			    }	
			// Repeatedly ask for user input 
		    	while(inputError) {
		    		System.out.print("Incorect choice.\nPlease choose one correct choice 1-8:");
		    		userInput = kb.nextInt();
		    		kb.nextLine();
		    		if (userInput >= 1 || userInput <= 8)
		            {
		                inputError = false;
		            }
		    	
			    	
			    	
			    }
			    
			    
			    
			    	
			    
			   
			    switch (userInput) {
				case 1:
					System.out.print("Inorder traversal:\n");
					System.out.println();
					printStateHeader();
					bst.printInorder();	   	
					break;
				case 2:
					System.out.print("Preorder traversal:\n");
					System.out.println();
					printStateHeader();
					bst.printPreorder();
					break;
				
				case 3:
					System.out.print("Postorder traversal:\n");
					System.out.println();
					printStateHeader(); 
					bst.printPostorder();
					break;
					
				case 4:
					String name1;
					System.out.print("Enter state name: ");
					name1= kb.nextLine();
					name1= kb.nextLine();
					boolean isTrue =bst.delete(name1);
					if (isTrue){
						System.out.printf("\n%s is deleted from binary search tree.",name1 );
					}else
						System.out.printf("\n%s is not found and can't be deleted in the binary search tree.",name1 );
					
					//System.out.print(name1);
					break;
				
				
				case 5:
					String name2;
					System.out.print("Enter state name: \n ");
					name2= kb.nextLine();
					name2= kb.nextLine();
					//double result =bst.find(name2);
					
					//System.out.print(result); 	
					 bst.find(name2);
					//System.out.print(result);
					break;
					
					
					
				case 6:	
					int cvalue;
					System.out.print("Enter the value of c ");
					
					cvalue=kb.nextInt();
					bst.printBottomStates(cvalue);
					
					
					break;
					
					
					
				case 7:	
					int cvalue2;
					System.out.print("Enter the value of c ");
					
					cvalue2=kb.nextInt();
					bst.printTopStates(cvalue2);
					
					break;
					
				
				case 8:
			
					System.out.println("\nHave a good day!\n");
					kb.close();
					System.exit(0);
					break;
			
				
				}
			    
		
		
		
		}while( userInput>0 || userInput<=8 );
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	/**
	* display the header of State print
	* 
	* @param no parameter
	* @return no return
	*/    
	private static void printStateHeader() {
        System.out.printf("%-20s %s\n", "Name", "Death Rate");
        System.out.println("-----------------------------------");
    }

}

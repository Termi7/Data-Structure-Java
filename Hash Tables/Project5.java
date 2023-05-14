/** 
 * COP 3530: Project 5 – Hash Tables 
 * <p> 
 * This class read from the file and copy informations in a hash table . It also display menu option containing the hash table , delete a state, insert a state , search and print a state and 
 * print numbers of empty and collided cells. The user input are the choice for the menu and states entry regarding the deletion the find and the insertion . The program request the file name at begining.
 * 
 * 
 * @author <Aboubacar Abdoulaye>
 * @version <12/10/2021>
 */ 

package sources;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;

public class Project5 {

	
		static Scanner kb = new Scanner(System.in) ;
		
		public static void main(String[] args) {
			
			
			boolean inputError = false;
			String userInput1 = null;
			int userInput = 0;
	    	//boolean inputError = false;
			//String userInput1 = null;
			//int userInput = 0;
			System.out.println("COP3530 Project 5\n");
			System.out.println("Instructor: Xudong Liu\n");
			
			System.out.println("Hash Tables\n"); 
			
			System.out.print("Please enter the file name:\n ");
			
			String fileName= kb.next();
			//System.out.println(fileName);
			
			while (!fileName.equals("States5.csv")) {
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
			
			// here type
			inFile.nextLine();
			int lines=0;
			
			HashTable theHashTable = new HashTable(101);
			
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
				theHashTable.insert(states.getStateName(), states.getPopulation(), states.getCovid19Deaths());
			
				lines++;
			
			}
			
			System.out.println("\nThere were " +( lines ) + "  records read into the hash table.\n");

			
			
			do {
				   
				 try {   
				
					System.out.println("\n1. Print hash table \n");
					System.out.println("2. Delete a state of a given name \n");
					System.out.println("3. Insert a state of a given name\n");
					System.out.println("4. Search and print a state and its DR for a given name.\n");
					System.out.println("5. Print numbers of empty and collided cells \n");
					System.out.println("6. Exit \n");
					System.out.print("Enter your choice: \n");
					
					userInput1= kb.next();
				    NumberFormat.getInstance().parse(userInput1);
				    userInput = Integer.parseInt(userInput1);
				    
				 }
				   catch(ParseException e) {
					   inputError = true;
					   
				   }
				 
				 if ( userInput<=0 || userInput>=7) {
				    	inputError= true;
				    }	
				// Repeatedly ask for user input 
			    	while(inputError) {
			    		System.out.print("Incorect choice.\nPlease choose one correct choice 1-6:");
			    		userInput = kb.nextInt();
			    		kb.nextLine();
			    		if (userInput >= 1 || userInput <= 6)
			            {
			                inputError = false;
			            }
			    	
				    	
				    	
				    }
				    
				    
				    
				    	
				    
				   
				    switch (userInput) {
					case 1:
						theHashTable.displayTable();
						
						break;
					case 2:
						String name1;
						System.out.print("Enter state name: ");
						name1= kb.nextLine();
						name1= kb.nextLine();
						theHashTable.delete(name1);
						break;
					
					case 3:
						String name2;
						long population2, death2;
						System.out.print("Enter state name: ");
						name2= kb.nextLine();
						name2= kb.nextLine();
						System.out.print("Enter the poplation: ");
						population2= kb.nextLong();
						System.out.print("Enter the death: ");
						death2= kb.nextLong();
						theHashTable.insert(name2, population2, death2);
						System.out.print(name2+ " is inserted to hash table");
						
						
						break;
						
					case 4:
						String name3;
						System.out.print("Enter state name: ");
						name3= kb.nextLine();
						name3= kb.nextLine();
						theHashTable.find(name3);
						
						break;
					
					
					case 5:
						
						theHashTable.printFreeAndCollisions();
						
						break;
						
						
					case 6:	
						
						System.out.println("\nHave a good day!\n");
						kb.close();
						System.exit(0);
						
						break;
						
					}
				    
			
			
			
			}while( userInput>0 || userInput<=6 );

}
		
}


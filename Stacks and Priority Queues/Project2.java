/** COP 3530: Project 2 –Stacks and PriorityQQueues
  *<p>
  *This class, first read the information of file and insert State objects, in the order shown in the input file,into the stack and into the priority queue.
  *as for the input it ask the user for the file name , the choice selection for the menu of option. Also it ask the user to to type the information of the state he want to insert on either the stack or priority queue.
  *
  *for the output it display the welcome message , the menu choice , the stack and priority queue containing the states objects after all the operation push, insert , remove pop . In the end it allows us to insert a new state in the priority queue and the stack queue
  * @author <Aboubacar Abdoulaye Soumana>
  * * @version <10/08/2021>
  */
package source;

import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
import java.io.*;
//import java.util.InputMismatchException;
import java.util.Scanner;


public class Project2 {


		
		// TODO Auto-generated constructor stub
		static Scanner kb = new Scanner(System.in) ;
		
	    public static void main(String[] args) {
	    	int maxSize= 50;
	    	boolean inputError = false;
			String userInput1 = null;
			int userInput = 0;
			System.out.println("COP3530 Project 2");
			System.out.println("Instructor: Xudong Liu\n");
			
			System.out.println("Stacks and Priority Queues"); 
			
			
			
			
			System.out.print("Please enter the file name:\n ");
			
			String fileName= kb.next();
			System.out.println(fileName);
			
			while (!fileName.equals("States2.csv")) {
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

			
			
			//State states[] =  new State[50];
			Stack stack = new Stack(55);
			PriorityQ priority = new PriorityQ(55);
			
			//int i =0;
			inFile.nextLine();
			int top=0;
			int nItems=0;
			
			
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
				top =stack.push(states);
				nItems= priority.insert(states);
				
			}
			
			
			
				
			System.out.println("Stack created of " +( top + 1) + " states.") ; 	
			System.out.println("Priority queue created of " + nItems + " states.") ;    
			
			
			
			
			
			
			do {
				   
				 try {   
				
					 System.out.println("\n1. Print stack\n");
					System.out.println("2. Pop a state object from stack\n");
					System.out.println("3. Push a state object onto stack\n");
					System.out.println("4.Print priority queue\n");
					System.out.println("5. Remove a state object from priority queue\n");
					System.out.println("6.Insert a state object into priority queue\n");
					System.out.println("7.Exit\n"); 
					
					System.out.print("Enter your choice: \n");
					
					userInput1= kb.next();
				    NumberFormat.getInstance().parse(userInput1);
				    userInput = Integer.parseInt(userInput1);
				    
				 }
				   catch(ParseException e) {
					   inputError = true;
					   
				   }
				 
				 if ( userInput<=0 || userInput>=8) {
				    	inputError= true;
				    }	
				// Repeatedly ask for user input 
			    	while(inputError) {
			    		System.out.print("Incorect choice.\nPlease choose one correct choice 1-7:");
			    		userInput = kb.nextInt();
			    		kb.nextLine();
			    		if (userInput >= 1 || userInput <= 7)
			            {
			                inputError = false;
			            }
			    	
				    	
				    	
				    }
				    
				    
				    
				    	
				    
				   
				    switch (userInput) {
					case 1:
						stack.printStack();
						break;
					case 2:
						stack.pop();
						//stack.printStack();
						System.out.println("\nOne state is popped from stack.");
						break;
					case 3:
						
						State item = new State();
						System.out.println("Enter name:\n");
						item.setStateName(kb.next());
						
						System.out.println("Enter capitol:\n");
						item.setCapitol(kb.next());
						
						System.out.println("Enter region:\n");
						item.setRegion(kb.next());
						
						System.out.println("Enter usHouse:\n");
						item.setUsHouse(kb.nextInt());
						
						System.out.println("Enter population:\n");
						item.setPopulation(kb.nextInt());
						
						System.out.println("Enter covid19Cases:\n");
						item.setCovid19Cases(kb.nextInt());
						
						System.out.println("Enter covid19Deaths:\n");
						item.setCovid19Deaths(kb.nextInt());
						
						System.out.println("Enter medHouseholdIncome:\n");
						item.setMedHouseholdIncome(kb.nextInt());
						
						System.out.println("Enter VCR:\n");
						item.setViolentCrimeRate(kb.nextFloat());
						
						stack.push(item);
						System.out.println("But don't worry we will remove one item from the stack to make space and insert the new state");
							
						if((top ==  maxSize-1 )) {
							// lets remove the first element in the stack to make some place for our new item state
							stack.pop();
							stack.push(item);
							
							
							
						}
						
						
						
						System.out.println("One state is pushed onto stack.\n");
			
						break;
					case 4:
						priority.printQueue();
						break;
					case 5:
						 priority.remove();
						System.out.println("One state is removed from priority queue.");
						break;
					case 6:
						
						State item2 = new State();
						System.out.println("Enter name:\n");
						item2.setStateName(kb.next());
						
						System.out.println("Enter capitol:\n");
						item2.setCapitol(kb.next());
						
						System.out.println("Enter region:\n");
						item2.setRegion(kb.next());
						
						System.out.println("Enter usHouse:\n");
						item2.setUsHouse(kb.nextInt());
						
						System.out.println("Enter population:\n");
						item2.setPopulation(kb.nextInt());
						
						System.out.println("Enter covid19Cases:\n");
						item2.setCovid19Cases(kb.nextInt());
						
						System.out.println("Enter covid19Deaths:\n");
						item2.setCovid19Deaths(kb.nextInt());
						
						System.out.println("Enter medHouseholdIncome:\n");
						item2.setMedHouseholdIncome(kb.nextInt());
						
						System.out.println("Enter VCR:\n");
						item2.setViolentCrimeRate(kb.nextFloat());
						
						priority.insert(item2);
						
						/*System.out.println("But don't worry we will remove one item from the priority queue to make space and insert the new state");
						if ( nItems == maxSize){
							priority.remove();
							priority.insert(item2);
							
						
						}
						
						*/
						
						System.out.println("One state is inserted onto priority queue.");
						
						
						break;
					case 7:
						System.out.println("\nHave a good day!");
						kb.close();
						System.exit(0);
						break;
					}
				    
			
			
			
			}while( userInput>0 || userInput<=7 );
			    
			
	    
		
	    
	}

}

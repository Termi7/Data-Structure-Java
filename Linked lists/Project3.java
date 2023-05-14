/**
* COP 3530: Project 3 – Linked lists
* <p>
* this class read from the file and copy the information in the stack using a linked list and then pop the stack and add the states in priority 
* q while sorting it . It also display a menu to user to enter an interval of deletion , print the priority q and exit.
* the input are file name and the interval of deletions . It display the differents list.
*
* @author <your name>
* @version <10/23/2021>
*/
package source;
import java.text.NumberFormat;
import java.text.ParseException;
import java.io.*;
//import java.util.InputMismatchException;
import java.util.Scanner;

import source.PriorityQ.Link;

import java.io.FileNotFoundException;



public class Project3 {

	// TODO Auto-generated constructor stub
			static Scanner kb = new Scanner(System.in) ;
			
		    public static void main(String[] args) {
		    
		    	boolean inputError = false;
				String userInput1 = null;
				int userInput = 0;
		    	//boolean inputError = false;
				//String userInput1 = null;
				//int userInput = 0;
				System.out.println("COP3530 Project 3");
				System.out.println("Instructor: Xudong Liu\n");
				
				System.out.println("Linked lists"); 
				
				System.out.print("Please enter the file name:\n ");
				
				String fileName= kb.next();
				//System.out.println(fileName);
				
				while (!fileName.equals("States3.csv")) {
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
				Stack stack = new Stack();
				
				
				//int i =0;
				inFile.nextLine();
				int top=0;
				
				
				
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
				
					if ( (150 < deaths && deaths >= 250) || (deaths >= 100 && deaths < 150) || ( deaths>=70 && deaths < 100) ){
					    top=stack.push(states);
				
					    
					}
					
					

					//top =stack.push(states);
					//nItems= priority.insert(states);
					
					 
				}
		    
				//System.out.println("Stack created of " +( top + 1) + " states.") ;
				
				stack.printStack();
				
				PriorityQ priority = new PriorityQ();
				while (!stack.isEmpty()) {
				    priority.insert( stack.pop());
					
					
				}
		    priority.printPriority();
		    
		    do {
				   
				 try {   
				
					System.out.println("\n1. Enter a DR interval for deletions\n");
					System.out.println("2. Print priority queue\n");
					System.out.println("3. Exit\n");
					System.out.print("Enter your choice: \n");
					
					userInput1= kb.next();
				    NumberFormat.getInstance().parse(userInput1);
				    userInput = Integer.parseInt(userInput1);
				    
				 }
				   catch(ParseException e) {
					   inputError = true;
					   
				   }
				 
				 if ( userInput<=0 || userInput>=4) {
				    	inputError= true;
				    }	
				// Repeatedly ask for user input 
			    	while(inputError) {
			    		System.out.print("Incorect choice.\nPlease choose one correct choice 1-3:");
			    		userInput = kb.nextInt();
			    		kb.nextLine();
			    		if (userInput >= 1 || userInput <= 3)
			            {
			                inputError = false;
			            }
			    	
				    	
				    	
				    }
				    
				    
				    
				    	
				    
				   
				    switch (userInput) {
					case 1:
						
						double lowerbond =0.0;
						double upperbond=0.0;
						System.out.println("\nEnter DR interval like [x,y]: ");
						
						
						System.out.println("\nEnter the lower bond x: ");
						lowerbond =  kb.nextDouble();
						System.out.println("\nEnter the upper bond y: ");
						upperbond = kb.nextDouble();
						System.out.printf("", priority.intervalDelete(lowerbond, upperbond));
								   	
						break;
					case 2:
						
						priority.printPriority();
						
						break;
					case 3:
				
						System.out.println("\nHave a good day!");
						kb.close();
						System.exit(0);
						break;
				
					
					}
				    
			
			
			
			}while( userInput>0 || userInput<=4 );
			    
				
      }

    




}


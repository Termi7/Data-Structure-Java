/**
* COP 3530: Project 1–Array Searches and Sorts
* <p>
* This class, first read the information of file and copy into the state array .
* as for the input it ask the user for the file name , the choice selection for the menu of option. Also it ask the user to enter name of the state you want to look for .
* for the output it display the welcome message , the menu choice , the different sorting of array class depending of the field and the sorting methode. In the end it display the correlation matrix.
* @author <Aboubacar Abdoulaye Soumana>
* @version <09/17/2021>
*/
package source;
import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
import java.io.*;
//import java.util.InputMismatchException;
import java.util.Scanner;


public class Project1 {

    static boolean isSortedByStateName = false;
    static Scanner kb = new Scanner(System.in) ;
    
    public static void main(String[] args) throws ParseException {
		
    	boolean inputError = false;
		String userInput1 = null;
		int userInput = 0;
    	System.out.println("COP3530 Project 1");
		System.out.println("Instructor: Xudong Liu\n");
		
		System.out.println("Array Searches and Sorts"); 
		
		
		
		
		System.out.print("Please enter the file name:\n ");
		
		String fileName= kb.next();
		//System.out.println(fileName);
		
		while (!fileName.equals("States1.csv")) {
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
		inFile.useDelimiter(",|\n");

		
		
		State states[] =  new State[50];
		int i =0;
		inFile.nextLine();
		while (inFile.hasNext()) {
			states[i] = new State();
			states[i].setStateName(inFile.next()); 
			states[i].setCapitol(inFile.next());
			states[i].setRegion(inFile.next());
			states[i].setUsHouse(inFile.nextInt());
			states[i].setPopulation(inFile.nextInt());
			states[i].setCovid19Cases(inFile.nextInt());
			states[i].setCovid19Deaths(inFile.nextInt());
			states[i].setMedHouseholdIncome(inFile.nextInt());
			states[i].setViolentCrimeRate(inFile.nextFloat());
			i++;
			
		}
		int numElements = 0;
		numElements= i;
		//kb.close();
		System.out.println("There were " + numElements + " state records read.");
		//printStateReport(states, numElements);
		
	
	   
	do {
	     
		try {
		    System.out.println("\n1. Print a state report");
			System.out.println("2. Sort by State name");
			System.out.println("3. Sort by Case Fatality Rate");
			System.out.println("4.Sort by Median Household Income");
			System.out.println("5. Find and print a given state");
			System.out.print("6. Print Spearman’s rho matrix\n");
			System.out.println("7. Quit\n"); 
			
			System.out.print("\n\nEnter your choice: ");
			
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
		    	//System.out.print("Incorect choice.\nPlease choose one correct choice 1-7:");
		    	//userInput= kb.nextInt();
		    	
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
				printStateReport(states, numElements);
				break;
			case 2:
				sortByStateName(states, numElements);
				break;
			case 3:
				sortByCaseFatality(states, numElements);
				break;
			case 4:
				sortByMedianIncome(states, numElements);
				break;
			case 5:
				findAndPrintState(states,numElements);
				break;
			case 6:
				correlationMatrix(states,numElements);
				break;
			case 7:
				System.out.println("\nHave a good day!");
				kb.close();
				System.exit(0);
				break;
		    }
		    
	
		    	    
	
	}while( userInput>0 || userInput<=7 );
	    
	
	
    }
		
		
		
			
		
	 
	
   /**
    * This method display the informations of states object components
    * 
    * 
    *
    *   @param states[] parameter is array object state that contain all information about the states and its field.
    *   @return  no return value
    */
	private static void  printStateReport( State states[], int numElements ) {
		System.out.println("Name       MHI     VCR     CFR     Case Rate      Deaths Rate");
		System.out.println("------------------------------------------------------");
       
		int i=0;
		for (i=0; i<numElements; i++) {
			System.out.printf(states[i].toString());
		}
			
	}
		
	  /**
	    * This method sort the the states names alphabetically by using a the buble sort
	    * 
	    *
	    *
	    * @param states[] parameter is array object state that contain all information about the states and its field.
	    *  @return no return value
	    */	
	private static void  sortByStateName(State states[], int numElements ) {
		//int outer,  inner;
		for(int outer = 0; outer < states.length - 1; outer++) {
			for(int inner = states.length - 1; inner > outer; inner--) {
				if (states[inner].getStateName().compareTo(states[inner - 1].getStateName()) < 0) {
				   State temp = states[inner];
                   states[inner] =states[inner-1];
                   states[inner-1] = temp;}
                   
				
			}
			
			 isSortedByStateName = true;
	
		
		}
		   System.out.println("States sorted by Name.\n");

		
	
		
	

	
	
	
	}
	   /**
	    * This method sort the sort the array by case fatality by using a selection sort
	    * 
	    * 
	    *
	    *  @param states[] parameter is array object state that contain all information about the states and its field.
	    *  @return  no return value
	    */	
	private static void sortByCaseFatality(State states[], int numElements ) {
		for(int outer=0; outer<numElements-1; outer++) {
			int lowest = outer;
			for(int inner=outer+1; inner<numElements; inner++) {
				if(((double)states[inner].getCovid19Deaths()/states[inner].getCovid19Cases()) < ((double)states[lowest].getCovid19Deaths()/states[lowest].getCovid19Cases())) {
					lowest = inner;
					
				}
			}

			if(lowest != outer) {
				State temp = states[lowest];
				 states[lowest] = states[outer];
				 states[outer] = temp;

			}
		}
		 isSortedByStateName = false;
		System.out.println("States sorted by Case Fatality Rate. \n");	
	}
	
	  /**This method sort the array by median income  by using an insertion sort.
	    * 
	    * 
	    *
	    *  @param states[] parameter is array object state that contain all information about the states and its field.
	    *  @return no return value
	    */	
	private static void sortByMedianIncome (State states[], int numElements ) {
		int in, out;
		for(out=1; out<numElements; out++) {
			
        	State temp = states[out];
        	in = out-1;
        	while(in>=0 && states[in].getMedHouseholdIncome() > (temp.getMedHouseholdIncome() )){
        		states[in+1] = states[in]; 
        		in--; 
        	
        	}
        	states[in+1] = temp;
        	

        }
		
		
	    isSortedByStateName = false;
		System.out.println("States sorted by Median Household Income. \n");
	}
	
	
	  /**
	    * This method display the information of the a state base on the user input. This program look  into the array and depending on  the array is sorted it performed a binary search or a sequential  search
	    *  @param states[] parameter is array object state that contain all information about the states and its field.
	    *  @return no return value
	    *  
	    */	
	private static void findAndPrintState (State states[], int numElements ) {
		
		System.out.println("Enter the state name: \n");
		int j=0;
		String sName = kb.next();
		System.out.printf("%s\n",sName);
		if(isSortedByStateName) {
			//sorted binary search
			int lowerBound = 0;
			int upperBound = numElements-1;
			int mid;
			boolean isFound= false;
			System.out.print("Binary search\n");
			while(lowerBound <= upperBound) {
				mid = (lowerBound + upperBound ) / 2;
				if(states[mid].getStateName().compareTo(sName) ==0) {
					 
					states[mid].display();
					isFound= true;
					break;
					// found it
				} else if (states[mid].getStateName().compareTo(sName) > 0){
					upperBound = mid - 1; // it's in lower half
				} else {
					lowerBound = mid + 1; // it's in upper half
				}	
						
				 
			}// end while
            if (isFound){
            	
            }else {
            	
            	System.out.printf("Error: %s not found.\n",sName); 
            }
			
			
		    
		}
		

	    else {
			
			// insorted sequential search
				 
	    	  System.out.print("Sequential search\n");
	    	  
	    	  j=0;
	    	  boolean isfound2= false;
	    	  while(j<states.length) {
	    		  if(states[j].getStateName().compareTo(sName) ==0){
		
			 		   states[j].display();
			 		   isfound2= true;
			 		 
			 		
			 		}
	    		 	  
			 		j++;
			 
	    	  }
			 
			 if ( isfound2) {
				 
			 }
			 else {
				 System.out.printf("Error: %s not found.\n", sName); 
			 
			 }
			 
			 
			 

	    
	    }
		
		
			 
	    
	
		
}	
	
	
	
	  /**
	    * This method find the value of correlation matrix and display it
	    * 
	    * 
	    *
	    *  @param states[] parameter is array object state that contain all information about the states and its field.
	    * @return no return value
	    */	
	private static void  correlationMatrix (State states[], int numElements ) {
		
		
		
		 
		
		
		
		
	
	}
	
	
	
	
	
	
}

																				
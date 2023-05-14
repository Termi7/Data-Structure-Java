/** This class name is State and contain the methods, constructors, to get and set the data of the different fields ofname, capitol, region, US House seats, population, COVID-19 cases, COVID19 deaths, median household income, and violent crime rate.
  *It also contain method to print the states
  *
  * @author <Aboubacar Abdoulaye Soumana>
  * * @version <10/08/2021>
  */
package source;

public class State {
	private String stateName ;
	private String capitol;
	private String region;
	private int    usHouse;
	private int    population;
	private int   covid19Cases  ;
	private int   covid19Deaths;
	private int   medHouseholdIncome;
	private float   violentCrimeRate;
	
	
	public State() {
		
	}
	public State(String stateName, String capitol, String region, int usHouse, int population, int covid19Cases, int covid19Deaths, int medHouseholdIncome,  float violentCrimeRate ) {
		// TODO Auto-generated constructor stub
		
		this.stateName= stateName;
		this.capitol = capitol;
		this.region = region;
		this.usHouse = usHouse;
		this.population = population;
		this.covid19Cases = covid19Cases;
		this.covid19Deaths = covid19Deaths;
		this.medHouseholdIncome = medHouseholdIncome;
		this.violentCrimeRate = violentCrimeRate;
	
	}
	/**
	*This method is the getter of the field name and is use to asses his value
	*   @param no parameter
	*  @return stateName : return the stateName
	*/
	public String getStateName() {
		return stateName;
	}
  /**This method is the setter of the field name and is use to set his value
	*  @param no parameter 
	*  @return no return
	*/
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
  /**This method is a getter of the field capitol and use to access it 
	*@param  no parameter 
	* @return capitol
	*/
	public String getCapitol() {
		return capitol;
	}
  /** This method is the setter of the field capitol and is use to set his value
   * @param capitol
	*
	* @return no return
	*/
	public void setCapitol(String capitol) {
		this.capitol = capitol;
	}
  /**this method is a getter of the field region and use to access it 
	* @param  no parameter
	*  @return no return
	*/
	public String getRegion() {                                                                                                                                                                                                                                      
		return region;
	}
  /**This method is the setter of the field region and is use to set his value
	*@param region
	*
	* @return no return
	*/
	public void setRegion(String region) {
		this.region = region;
	}
  /**This method is a getter of the field usHouse and use to access it 
	*@param no parameter
	*  @return  no return value
	*/
	public int getUsHouse() {
		return usHouse;
	}
  /**This method is the setter of the field UsHouse and is use to set his value
   * @param usHouse
	*
	* @return
	*/
	public void setUsHouse(int usHouse) {
		this.usHouse = usHouse;
	}
  /**
	*This method is a getter of the field population and use to access it 
	*@param no return value
	*   
	*    @return population
	*/
	public int getPopulation() {
		return population;
	}
  /**This method is the setter of the field population and is use to set his value
   * @param population
	*
	* @return no return value
	*/
	public void setPopulation(int population) {
		this.population = population;
	}
  /**This method is a getter of the field covid19Cases and use to access it 
   * @param no parameter
	*
	*  @return  covid19Cases
	*/
	public int getCovid19Cases() {
		return covid19Cases;
	}
  /**This method is the setter of the field Covid19Cases and is use to set his value
   * @param  covid19Cases
	*
	* @return no return
	*/
	public void setCovid19Cases(int covid19Cases) {
		this.covid19Cases = covid19Cases;
	}
  /**This method is a getter of the field covid19Deaths and use to access it 
   * @param no parameter
	*
	*  @return  covid19Deaths
	*/public int getCovid19Deaths() {
		return covid19Deaths;
	}
  /**This method is the setter of the field Covid19Death and is use to set his value
   * @param covid19Deaths
	*
	* @return  no return value
	*/
	public void setCovid19Deaths(int covid19Deaths) {
		this.covid19Deaths = covid19Deaths;
	}
  /**@param no 
	*
	*  @return  edHouseholdIncome
	*/
	public int getMedHouseholdIncome() {
		return medHouseholdIncome;
	}
	/**This method is the setter of the field MedHouseldIncome and is use to set his value
	*   @param medHouseholdIncome
	*   
	*   @return no return
	*/
	public void setMedHouseholdIncome(int medHouseholdIncome) {
		this.medHouseholdIncome = medHouseholdIncome;
	}
	/**This method is a getter of the field violentCrimeRate and use to access it 
	*@param  no parameter
	*  
	*  @return violentCrimeRate
	*/
	public float getViolentCrimeRate() {
		return violentCrimeRate;
	}
  /**This method is the setter of the field violentCrimeRate and is use to set his value
	*@param violentCrimeRate
	*  @return no return value
	*/
	
	public void setViolentCrimeRate(float violentCrimeRate) {
		this.violentCrimeRate = violentCrimeRate;
	}
	
	
	
  /**
	* This method name is toString and display a text containing the different variable in order to display the information of the states
	*
	*   @param no parameter
	*   @return   is string that hold the a text and help display the informations.  String.format("%s  %d   %.1f  %.6f  %.2f   %.2f\n", stateName , medHouseholdIncome , violentCrimeRate , ((double)covid19Deaths/covid19Cases) ,  ((double)covid19Cases*100000/ population) ,((double)covid19Deaths*100000/population)) 
	*/
	public String toString() {
		// TODO Auto-generated method stub
		
		return String.format("%-20s  %5d   %.1f  %.7f  %-10.2f   %.2f", stateName , medHouseholdIncome , violentCrimeRate , ((double)covid19Deaths/covid19Cases) ,  ((double)covid19Cases*100000/ population) ,((double)covid19Deaths*100000/population));
	
	
	
	}
	
  /**
	* This method displays the result of search of the State by using user input. It displays the different field of the state and their values.
	*  @param no parameter 
	*   @return no return values
	*/
	public void display() {
		System.out.printf("Name: %s  \n" , stateName);
		System.out.printf("MHI:  %d \n", medHouseholdIncome);
		System.out.printf("VCR: %.1f \n" , violentCrimeRate);
		System.out.printf("CFR:%.6f \n" , ((double)covid19Deaths/covid19Cases));
		System.out.printf("Case Rate:%.2f \n" , ((double)covid19Deaths/covid19Cases));
		System.out.printf("Death Rate: %.2f \n" , ((double)covid19Deaths*100000/population));
	}
}





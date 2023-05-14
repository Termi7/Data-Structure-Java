/**
* This class contain all the element a class needed to create node
*
* @author <Aboubacar Abdoulaye>
* @version <11/19/2021>
*/
package sources;

public class Node {

    /**
     * The name of the state.
     */
	public String stateName;

    /**
     * The population of the state.
     */
    public double DR;

    /**
     * The left child of this node.
     */
    public Node leftChild;

    /**
     * The right child of this node.
     */
    public Node rightChild;

    /**
	* present the elements of the node
	* 
	* @param String state and double deathRate
	* @return no return
	*/    
    public Node(String state,  double deathRate) {
        stateName = state;
        DR = deathRate;
    }

    /**
	* display all items in the node
	* 
	* @param no parameter
	* @return no return
	*/    
    public void printNode() {
        System.out.printf("%-20s %.2f\n", stateName, DR);
    }

}
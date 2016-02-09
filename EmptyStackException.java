package csc143.data_structures;


/**
 * This class extends DataStructureException and constructs a new exception with the specified detail message.
 * This exception is created (thrown) when a Stack is Empty and methods are trying to be performed on the Stack like 
 * removing an object from the Stack. 
 * 
 * 
 * @author Tiana Greisel
 * @version Learning Activity: Stack/Queue Documentation (Grade Level:  Check)
 *
 */
public class EmptyStackException extends DataStructureException{
	
	
	/**
	 * Constructs a new exception with the specified detail message.  Invokes superclass
	 * constructor. 
	 * 
	 * @param message Detailed message of reason for exception being thrown
	 */
	public EmptyStackException(String message){
		
		super(message);
		
	}

}

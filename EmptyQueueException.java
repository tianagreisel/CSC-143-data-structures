package csc143.data_structures;

/**
 * This class extends DataStructureException and constructs a new exception with the specified detail message.
 * This exception is created (thrown) when a Queue is empty and methods are trying to be performed on the Queue like 
 * removing an object from the Queue. 
 * 
 *  @author Tiana Greisel
 * @version Learning Activity: Stack/Queue Documentation (Grade Level:  Check)
 *
 */
public class EmptyQueueException extends DataStructureException{
	
	/**
	 * Constructs a new exception with the specified detail message.  Invokes superclass
	 * constructor. 
	 * 
	 * @param message Detailed message of reason for exception being thrown
	 */
	public EmptyQueueException(String message){
		super(message);
		
		
	}

}

package csc143.data_structures;


	/**
	 * This class extends Exception and constructs a new exception with the specified detail message.
	 * Created for EmptyQueueException, FullQueueExcpetion, EmptyStackException, and FullStackException.
	 * 
	 * @author Tiana Greisel
	 * @version Learning Activity: Stack/Queue Documentation (Grade Level:  Check)
	 * 
	 */
	public class DuplicateAddedEX extends Exception{
		
		
		/**
		 * Constructs a new exception with the specified detail message.  Invokes superclass
		 * constructor. 
		 * 
		 * @param message Detailed message of reason for exception being thrown
		 */
		public DuplicateAddedEX(String message){
			
			super(message);
			
		
		}
		

	}



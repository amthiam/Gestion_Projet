
package exceptions;

/**
 * Result code of the exceptions
 * @author Felix
 */
public enum ResultCode {
    
    /** Request succeeded */
	SUCCESS(0),
        
        /**
         * Identification error
         */
        IDENTIFICATION_ERROR(1),
        DATABASE_ERROR(2),
    
       
       /** the request has been made with missing parameters */
        WRONG_PARAMETERS_FOR_REQUEST(3),
        
        /** The object to be created in the database is invalid */
        INVALID_OBJECT(4),
        
        /** Error in writing in an external file */
        WRITING_ERROR(5);
	
        private int code;
        
        	ResultCode(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
}

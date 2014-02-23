package exceptions;

/**
 * General class for exceptions in the application
 * @author Felix
 */
public class ProjectException extends Exception {
    
    private static final long serialVersionUID = -4822842236569206129L;
    
    private ResultCode resultCode;
	
	public ProjectException(ResultCode resultCode) {
		super();
		this.resultCode = resultCode;
	}
	
	public ProjectException(ResultCode resultCode, String message) {
		super(message);
		this.resultCode = resultCode;
	}
        
        public ProjectException(ResultCode resultCode, Throwable e) {
		super(e);
		this.resultCode = resultCode;
	}
	
	public ProjectException(ResultCode resultCode, String message, Throwable e) {
		super(message, e);
		this.resultCode = resultCode;
        }
	
	public ResultCode getResultCode() {
		return resultCode;
	}
}

package exceptions;

/**
 * Exception for all methods accessing the database
 *
 * @author Felix
 */
public class DatabaseException extends ProjectException {

    private static final long serialVersionUID = 3116816893227762498L;
   

    public DatabaseException() {
        super(ResultCode.DATABASE_ERROR);
    }

    public DatabaseException(String message) {
        super(ResultCode.DATABASE_ERROR, message);
    }

    public DatabaseException(Throwable e) {
        super(ResultCode.DATABASE_ERROR, e);
    }

    public DatabaseException(ResultCode resultCode) {
        super(resultCode);
    }

    public DatabaseException(ResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public DatabaseException(ResultCode resultCode, Throwable e) {
        super(resultCode, e);
    }

    public DatabaseException(ResultCode resultCode, String message, Throwable e) {
        super(resultCode, message, e);
    }
}

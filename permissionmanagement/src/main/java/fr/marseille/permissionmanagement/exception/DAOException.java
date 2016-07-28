package fr.marseille.permissionmanagement.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class DAOException.
 */
public class DAOException extends ServiceException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new DAO exception.
     */
    public DAOException() {
        super();
    }

    /**
     * Instantiates a new DAO exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new DAO exception.
     *
     * @param message the message
     */
    public DAOException(String message) {
        super(message);
    }

}
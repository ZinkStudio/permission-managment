package fr.marseille.permissionmanagement.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceException.
 */
public class ServiceException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new service exception.
     */
    public ServiceException() {
        super();
    }

    /**
     * Instantiates a new service exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new service exception.
     *
     * @param message the message
     */
    public ServiceException(String message) {
        super(message);
    }

}
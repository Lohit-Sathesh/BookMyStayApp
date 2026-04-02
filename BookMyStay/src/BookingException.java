/**
 * ======================================================================
 * CUSTOM EXCEPTION - BookingException
 * ======================================================================
 * Use Case 9: Error Handling & Validation
 * * Description:
 * A domain-specific exception to handle invalid booking scenarios, 
 * such as invalid room types or zero availability.
 * * @version 9.0
 */
public class BookingException extends Exception {
    public BookingException(String message) {
        super(message);
    }
}
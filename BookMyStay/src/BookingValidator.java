import java.util.Map;

/**
 * ======================================================================
 * CLASS - BookingValidator
 * ======================================================================
 * Use Case 9: Error Handling & Validation
 * * Provides logic to validate booking requests and system constraints 
 * before processing.
 * * @version 9.0
 */
public class BookingValidator {

    /**
     * Validates a booking request against current inventory.
     * @throws BookingException if the room type is invalid or unavailable.
     */
    public void validateBooking(Reservation reservation, RoomInventory inventory) throws BookingException {
        String type = reservation.getRoomType();
        Map<String, Integer> availability = inventory.getRoomAvailability();

        // 1. Check if the room type even exists in our system
        if (!availability.containsKey(type)) {
            throw new BookingException("INVALID ROOM TYPE: " + type + " does not exist.");
        }

        // 2. Check if there is enough inventory
        if (availability.get(type) <= 0) {
            throw new BookingException("SOLD OUT: No " + type + " rooms available.");
        }
    }
}
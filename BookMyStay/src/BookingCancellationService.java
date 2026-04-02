import java.util.Stack;
import java.util.Map;
import java.util.List;

/**
 * ======================================================================
 * CLASS - BookingCancellationService
 * ======================================================================
 * Use Case 10: Booking Cancellation & Inventory Rollback
 * * Handles the safe reversal of confirmed bookings.
 * Uses a Stack to track released Room IDs for efficient rollback.
 * * @version 10.0
 */
public class BookingCancellationService {

    /** Stack to store released room IDs (LIFO rollback) */
    private Stack<String> releasedRoomIds;

    public BookingCancellationService() {
        this.releasedRoomIds = new Stack<>();
    }

    /**
     * Cancels a booking and rolls back the inventory state.
     * @param guestName name of the guest cancelling
     * @param roomType type of room being released
     * @param roomId unique ID assigned during booking
     * @param inventory current system inventory
     * @param history historical record to verify existence
     * @throws BookingException if the reservation cannot be found
     */
    public void cancelBooking(String guestName, String roomType, String roomId,
                              RoomInventory inventory, BookingHistory history) throws BookingException {

        // 1. Validation: Ensure the booking actually exists in history
        boolean exists = history.getHistory().stream()
                .anyMatch(r -> r.getGuestName().equals(guestName) && r.getRoomType().equals(roomType));

        if (!exists) {
            throw new BookingException("CANCELLATION FAILED: No record found for " + guestName);
        }

        // 2. State Reversal: Add Room ID to the rollback stack
        releasedRoomIds.push(roomId);

        // 3. Inventory Restoration: Increment the count
        Map<String, Integer> currentAvailability = inventory.getRoomAvailability();
        inventory.updateAvailability(roomType, currentAvailability.get(roomType) + 1);

        System.out.println("SUCCESS: Booking cancelled for " + guestName +
                ". Room " + roomId + " returned to inventory.");
    }

    public Stack<String> getReleasedRoomIds() {
        return releasedRoomIds;
    }
}
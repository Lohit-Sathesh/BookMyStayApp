import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ======================================================================
 * CLASS - BookingService
 * ======================================================================
 * Use Case 6: Reservation Confirmation & Room Allocation
 * * Description:
 * Processes queued booking requests and performs room allocation.
 * Uses a Set to ensure unique Room IDs and prevent double-booking.
 * * @version 6.0
 */
public class BookingService {

    /** Maps room types to a set of allocated room IDs (uniqueness enforcement) */
    private Map<String, Set<String>> allocatedRooms;

    public BookingService() {
        this.allocatedRooms = new HashMap<>();
        allocatedRooms.put("Single", new HashSet<>());
        allocatedRooms.put("Double", new HashSet<>());
        allocatedRooms.put("Suite", new HashSet<>());
    }

    /**
     * Processes a booking request by assigning a unique Room ID.
     * * @param reservation the request to process
     * @param inventory   the inventory to check and update
     */
    public void processBooking(Reservation reservation, RoomInventory inventory) {
        String type = reservation.getRoomType();
        Map<String, Integer> availability = inventory.getRoomAvailability();

        // 1. Availability Check
        if (availability.getOrDefault(type, 0) > 0) {

            // 2. Room ID Generation (Unique assignment)
            int roomNum = 100 + allocatedRooms.get(type).size() + 1;
            String roomId = type.toUpperCase() + "-" + roomNum;

            // 3. Record Allocation (Uniqueness enforcement)
            allocatedRooms.get(type).add(roomId);

            // 4. Update Inventory (Immediate synchronization)
            inventory.updateAvailability(type, availability.get(type) - 1);

            System.out.println("CONFIRMED: Guest " + reservation.getGuestName() +
                    " assigned to " + roomId);
        } else {
            System.out.println("FAILED: No availability for " + type + " Room.");
        }
    }
}
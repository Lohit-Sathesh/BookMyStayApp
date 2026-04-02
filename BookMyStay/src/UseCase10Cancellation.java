/**
 * ======================================================================
 * MAIN CLASS - UseCase10Cancellation
 * ======================================================================
 * Use Case 10: Booking Cancellation & Inventory Rollback
 * * Demonstrates the rollback mechanism and inventory restoration.
 * * @version 10.0
 */
public class UseCase10Cancellation {

    public static void main(String[] args) {
        System.out.println("=== Book My Stay: Cancellation & Rollback (v10.0) ===");

        // 1. Setup Components
        RoomInventory inventory = new RoomInventory();
        BookingHistory history = new BookingHistory();
        BookingCancellationService cancellationService = new BookingCancellationService();

        // 2. Pre-condition: Assume a confirmed booking exists for "Lohit"
        // (Usually handled by BookingService, but we mock the state here for the demo)
        Reservation confirmedRes = new Reservation("Lohit", "Suite");
        history.recordBooking(confirmedRes);
        inventory.updateAvailability("Suite", 1); // Only 1 left before cancellation

        System.out.println("Initial Suite Availability: " + inventory.getRoomAvailability().get("Suite"));

        // 3. Perform Cancellation
        try {
            cancellationService.cancelBooking("Lohit", "Suite", "SUITE-101", inventory, history);
        } catch (BookingException e) {
            System.err.println(e.getMessage());
        }

        // 4. Verify Rollback
        System.out.println("Final Suite Availability: " + inventory.getRoomAvailability().get("Suite"));
        System.out.println("Released Room IDs Stack: " + cancellationService.getReleasedRoomIds());

        System.out.println("======================================================");
    }
}
/**
 * ======================================================================
 * MAIN CLASS - UseCase6RoomAllocation
 * ======================================================================
 * Use Case 6: Reservation Confirmation & Room Allocation
 * * Description:
 * Demonstrates the full lifecycle from request queuing to 
 * unique room allocation and inventory synchronization.
 * * @version 6.0
 */
public class UseCase6RoomAllocation {

    public static void main(String[] args) {
        System.out.println("=== Book My Stay: Reservation & Allocation (v6.0) ===");

        // 1. Initialize Components
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();
        BookingService bookingService = new BookingService();

        // 2. Simulate Incoming Requests (FIFO)
        queue.addRequest(new Reservation("Alice", "Single"));
        queue.addRequest(new Reservation("Bob", "Single"));
        queue.addRequest(new Reservation("Charlie", "Suite"));

        // 3. Process the Queue
        System.out.println("--- Processing Bookings ---");
        while (queue.hasPendingRequests()) {
            Reservation currentRequest = queue.getNextRequest();
            bookingService.processBooking(currentRequest, inventory);
        }

        // 4. Display Final Inventory State
        System.out.println("\n--- Final Inventory State ---");
        inventory.getRoomAvailability().forEach((type, count) ->
                System.out.println(type + " Rooms remaining: " + count));

        System.out.println("=====================================================");
    }
}
/**
 * ======================================================================
 * CLASS - ConcurrentBookingProcessor
 * ======================================================================
 * Use Case 11: Concurrent Booking Simulation (Thread Safety)
 * * Processes booking requests in a multi-threaded environment.
 * Ensures that shared resources like Inventory are accessed safely.
 * * @version 11.0
 */
public class ConcurrentBookingProcessor implements Runnable {

    private BookingRequestQueue queue;
    private RoomInventory inventory;
    private BookingService bookingService;

    public ConcurrentBookingProcessor(BookingRequestQueue queue,
                                      RoomInventory inventory,
                                      BookingService bookingService) {
        this.queue = queue;
        this.inventory = inventory;
        this.bookingService = bookingService;
    }

    @Override
    public void run() {
        while (true) {
            Reservation request = null;

            // Synchronized block to safely pull from the shared queue
            synchronized (queue) {
                if (queue.hasPendingRequests()) {
                    request = queue.getNextRequest();
                } else {
                    break; // No more requests to process
                }
            }

            if (request != null) {
                // Synchronized block to ensure Atomic check-and-update on Inventory
                synchronized (inventory) {
                    System.out.println(Thread.currentThread().getName() +
                            " is processing request for: " + request.getGuestName());
                    bookingService.processBooking(request, inventory);
                }
            }

            // Small sleep to simulate network/processing delay
            try { Thread.sleep(100); } catch (InterruptedException e) { break; }
        }
    }
}
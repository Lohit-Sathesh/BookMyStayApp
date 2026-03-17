/**
 * ======================================================================
 * MAIN CLASS - UseCase5BookingRequestQueue
 * ======================================================================
 * Use Case 5: Booking Request (First-Come-First-Served)
 * * Description:
 * Demonstrates how booking requests are accepted and queued
 * in a fair and predictable order.
 * * @version 5.0
 */
public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {
        System.out.println("=== Book My Stay: Booking Request Queue (v5.0) ===");

        // 1. Initialize the fair queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // 2. Create booking requests (Simulated incoming requests)
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        // 3. Add requests to the queue (Preserving arrival order)
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // 4. Display queued requests in FIFO order
        while (bookingQueue.hasPendingRequests()) {
            Reservation current = bookingQueue.getNextRequest();
            System.out.println("Processing booking for Guest: " + current.getGuestName() +
                    ", Room Type: " + current.getRoomType());
        }

        System.out.println("==================================================");
    }
}
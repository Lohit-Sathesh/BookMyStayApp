/**
 * ======================================================================
 * MAIN CLASS - UseCase11ConcurrencySimulation
 * ======================================================================
 * Use Case 11: Concurrent Booking Simulation
 * * Demonstrates system stability under multi-threaded load.
 * * @version 11.0
 */
public class UseCase11ConcurrencySimulation {

    public static void main(String[] args) {
        System.out.println("=== Book My Stay: Thread Safety Simulation (v11.0) ===");

        // 1. Setup Shared Resources
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();
        BookingService bookingService = new BookingService();

        // 2. Load the queue with multiple simultaneous requests
        queue.addRequest(new Reservation("User_1", "Single"));
        queue.addRequest(new Reservation("User_2", "Single"));
        queue.addRequest(new Reservation("User_3", "Double"));
        queue.addRequest(new Reservation("User_4", "Single"));
        queue.addRequest(new Reservation("User_5", "Suite"));

        // 3. Create Multiple Worker Threads
        Thread worker1 = new Thread(new ConcurrentBookingProcessor(queue, inventory, bookingService), "Thread-Alpha");
        Thread worker2 = new Thread(new ConcurrentBookingProcessor(queue, inventory, bookingService), "Thread-Beta");

        // 4. Start concurrent processing
        worker1.start();
        worker2.start();

        // 5. Wait for threads to finish
        try {
            worker1.join();
            worker2.join();
        } catch (InterruptedException e) {
            System.err.println("Simulation interrupted.");
        }

        System.out.println("\nFinal Inventory Count (Single): " + inventory.getRoomAvailability().get("Single"));
        System.out.println("=== Concurrency Test Complete ===");
    }
}
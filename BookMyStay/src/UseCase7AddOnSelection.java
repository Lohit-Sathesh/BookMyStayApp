import java.util.List;

/**
 * ======================================================================
 * MAIN CLASS - UseCase7AddOnSelection
 * ======================================================================
 * Use Case 7: Add-On Service Selection
 * * Shows how to extend a reservation with optional features like 
 * Breakfast and WiFi without modifying core booking logic.
 * @version 7.0
 */
public class UseCase7AddOnSelection {

    public static void main(String[] args) {
        System.out.println("=== Book My Stay: Add-On Service System (v7.0) ===");

        // 1. Initialize the Manager
        AddOnServiceManager serviceManager = new AddOnServiceManager();

        // 2. Define Available Services
        Service breakfast = new Service("Buffet Breakfast", 25.0);
        Service wifi = new Service("Premium WiFi", 10.0);
        Service spa = new Service("Spa Access", 50.0);

        // 3. Assume a Reservation ID was generated (e.g., from Use Case 6)
        String reservationId = "SINGLE-101";

        // 4. Guest selects services
        System.out.println("Adding services to Reservation: " + reservationId);
        serviceManager.addServiceToReservation(reservationId, breakfast);
        serviceManager.addServiceToReservation(reservationId, wifi);

        // 5. Display Summary
        List<Service> selected = serviceManager.getServicesForReservation(reservationId);
        System.out.println("Selected Services: " + selected);

        double totalCost = serviceManager.calculateTotalAddOnCost(reservationId);
        System.out.println("Total Additional Cost: $" + totalCost);

        System.out.println("==================================================");
    }
}
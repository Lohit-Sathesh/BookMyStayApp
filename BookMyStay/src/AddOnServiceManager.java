import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ======================================================================
 * CLASS - AddOnServiceManager
 * ======================================================================
 * Use Case 7: Add-On Service Selection
 * * Manages the mapping between Reservation IDs and a list of services.
 * Demonstrates a One-to-Many relationship using Map and List.
 * @version 7.0
 */
public class AddOnServiceManager {

    /** Maps a Reservation/Room ID to a List of selected Services */
    private Map<String, List<Service>> reservationServices;

    public AddOnServiceManager() {
        this.reservationServices = new HashMap<>();
    }

    /**
     * Adds a service to a specific reservation.
     * @param reservationId the unique ID generated in Use Case 6
     * @param service the service to attach
     */
    public void addServiceToReservation(String reservationId, Service service) {
        // If ID isn't in map, create a new list; then add service
        reservationServices.computeIfAbsent(reservationId, k -> new ArrayList<>()).add(service);
    }

    /**
     * Calculates the total cost of all add-ons for a specific reservation.
     */
    public double calculateTotalAddOnCost(String reservationId) {
        List<Service> services = reservationServices.get(reservationId);
        if (services == null) return 0.0;

        double total = 0;
        for (Service s : services) {
            total += s.getPrice();
        }
        return total;
    }

    public List<Service> getServicesForReservation(String reservationId) {
        return reservationServices.getOrDefault(reservationId, new ArrayList<>());
    }
}
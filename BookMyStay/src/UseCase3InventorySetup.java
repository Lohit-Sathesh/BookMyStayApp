import java.util.Map;

/**
 * ======================================================================
 * MAIN CLASS - UseCase3InventorySetup
 * ======================================================================
 * Use Case 3: Centralized Room Inventory Management
 * * Description:
 * This class demonstrates how room availability is managed using a
 * centralized inventory. Room objects are used to retrieve pricing
 * and characteristics.
 * * @version 3.0
 */
public class UseCase3InventorySetup {

    /**
     * Application entry point.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // 1. Initialize Room Domain Models
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // 2. Initialize Centralized Inventory
        RoomInventory inventory = new RoomInventory();

        System.out.println("=== Book My Stay: Centralized Inventory (v3.0) ===");

        // 3. Display data by combining Room details + Inventory state
        Map<String, Integer> currentStats = inventory.getRoomAvailability();

        displayStatus("Single Room", single, currentStats.get("Single"));
        displayStatus("Double Room", doubleRoom, currentStats.get("Double"));
        displayStatus("Suite Room ", suite, currentStats.get("Suite"));

        // 4. Demonstrate a controlled update (Booking a room)
        System.out.println("\n--- Updating Inventory: 1 Suite Booked ---");

        // Updating the count for "Suite" from 2 to 1
        inventory.updateAvailability("Suite", 1);

        System.out.println("New Suite Availability: " + inventory.getRoomAvailability().get("Suite"));
        System.out.println("==================================================");
    }

    /**
     * Helper method to print room details and current availability side-by-side.
     */
    private static void displayStatus(String label, Room room, int count) {
        System.out.print(label + " -> ");
        room.displayRoomDetails();
        System.out.println(" | Available: " + count);
    }
}
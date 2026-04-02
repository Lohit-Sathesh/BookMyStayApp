/**
 * ======================================================================
 * MAIN CLASS - UseCase12Persistence
 * ======================================================================
 * Use Case 12: Data Persistence & System Recovery
 * * Demonstrates saving state, modifying it, and recovering it.
 * * @version 12.0
 */
public class UseCase12Persistence {

    public static void main(String[] args) {
        System.out.println("=== Book My Stay: Persistence & Recovery (v12.0) ===");

        RoomInventory inventory = new RoomInventory();
        PersistenceService persistence = new PersistenceService();

        // 1. Simulate a modified state
        System.out.println("Modifying inventory: Setting Suites to 0...");
        inventory.updateAvailability("Suite", 0);

        // 2. Persist state (Shutdown simulation)
        persistence.saveSystemState(inventory);

        // 3. Reset the live object (Simulate RAM being cleared)
        inventory.updateAvailability("Suite", 5);
        System.out.println("Current Suite count (in-memory reset): " + inventory.getRoomAvailability().get("Suite"));

        // 4. Restore state (Restart simulation)
        System.out.println("--- Restarting System ---");
        persistence.loadSystemState(inventory);

        // 5. Verify Recovery
        System.out.println("Recovered Suite count: " + inventory.getRoomAvailability().get("Suite"));
        System.out.println("====================================================");
    }
}
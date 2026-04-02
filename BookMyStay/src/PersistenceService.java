import java.io.*;
import java.util.Map;

/**
 * ======================================================================
 * CLASS - PersistenceService
 * ======================================================================
 * Use Case 12: Data Persistence & System Recovery
 * * Handles saving and loading the system state to/from a file.
 * Transitioning from in-memory to durable system design.
 * * @version 12.0
 */
public class PersistenceService {

    private static final String SAVE_FILE = "hotel_state.ser";

    /**
     * Serializes the inventory and history into a file.
     */
    public void saveSystemState(RoomInventory inventory) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            oos.writeObject(inventory.getRoomAvailability());
            System.out.println("SYSTEM: State successfully persisted to " + SAVE_FILE);
        } catch (IOException e) {
            System.err.println("SAVE ERROR: Could not persist state: " + e.getMessage());
        }
    }

    /**
     * Deserializes data from the file to restore the system state.
     */
    @SuppressWarnings("unchecked")
    public void loadSystemState(RoomInventory inventory) {
        File file = new File(SAVE_FILE);
        if (!file.exists()) {
            System.out.println("SYSTEM: No persistence file found. Starting with default state.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Map<String, Integer> restoredData = (Map<String, Integer>) ois.readObject();

            // Update the live inventory with persisted values
            restoredData.forEach(inventory::updateAvailability);

            System.out.println("SYSTEM: State restored from " + SAVE_FILE);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("RECOVERY ERROR: Could not restore state: " + e.getMessage());
        }
    }
}
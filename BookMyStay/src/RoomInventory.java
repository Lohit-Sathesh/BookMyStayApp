import java.util.HashMap;
import java.util.Map;

/**
 * ======================================================================
 * CLASS - RoomInventory
 * ======================================================================
 * Use Case 3: Centralized Room Inventory Management
 * * This class acts as the single source of truth for room availability.
 * Room pricing and characteristics are obtained from Room objects, 
 * not duplicated here.
 * * @version 3.1
 */
public class RoomInventory {

    /** Stores available room count for each room type. Key: Room Name, Value: Count */
    private Map<String, Integer> roomAvailability;

    /**
     * Constructor initializes the inventory with default availability values.
     */
    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    /**
     * Initializes room availability data.
     * Centralizes setup instead of using scattered variables.
     */
    private void initializeInventory() {
        roomAvailability.put("Single", 10);
        roomAvailability.put("Double", 5);
        roomAvailability.put("Suite", 2);
    }

    /**
     * Returns the current availability map.
     * @return map of room type to available count
     */
    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    /**
     * Updates availability for a specific room type.
     * @param roomType the room type to update
     * @param count new availability count
     */
    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}
/**
 * ======================================================================
 * MAIN CLASS - UseCase4RoomSearch
 * ======================================================================
 * Use Case 4: Room Search & Availability Check
 * * Description:
 * This class demonstrates how guests can view available rooms without 
 * modifying inventory data. The system enforces read-only access 
 * by design and usage discipline.
 * * @version 4.0
 */
public class UseCase4RoomSearch {

    public static void main(String[] args) {
        // 1. Setup Domain and Inventory
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();
        RoomInventory inventory = new RoomInventory();

        // 2. Initialize the Search Service
        RoomSearchService searchService = new RoomSearchService();

        System.out.println("=== Book My Stay: Room Search System (v4.0) ===");

        // 3. Scenario: Normal Search
        searchService.searchAvailableRooms(inventory, single, doubleRoom, suite);

        // 4. Scenario: Suite becomes unavailable
        System.out.println("\n--- Simulated Action: All Suites Booked Out ---");
        inventory.updateAvailability("Suite", 0);

        // 5. Search again to verify filtering logic
        System.out.println("Updated Search Results:");
        searchService.searchAvailableRooms(inventory, single, doubleRoom, suite);

        System.out.println("===============================================");
    }
}
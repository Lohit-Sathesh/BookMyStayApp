/**
 * ======================================================================
 * MAIN CLASS - UseCase9Validation
 * ======================================================================
 * Use Case 9: Error Handling & Validation
 * * Demonstrates fail-fast validation and graceful error recovery.
 * * @version 9.0
 */
public class UseCase9Validation {

    public static void main(String[] args) {
        System.out.println("=== Book My Stay: Error Handling System (v9.0) ===");

        RoomInventory inventory = new RoomInventory();
        BookingValidator validator = new BookingValidator();

        // Scenario A: A guest tries to book a "Penthouse" (which doesn't exist)
        Reservation invalidTypeRequest = new Reservation("Lohit", "Penthouse");

        // Scenario B: A guest tries to book a "Suite" when inventory is 0
        inventory.updateAvailability("Suite", 0);
        Reservation soldOutRequest = new Reservation("Sathesh", "Suite");

        processWithValidation(invalidTypeRequest, inventory, validator);
        processWithValidation(soldOutRequest, inventory, validator);

        System.out.println("\nSystem Status: Stable. Application continues to run.");
        System.out.println("==================================================");
    }

    private static void processWithValidation(Reservation res, RoomInventory inv, BookingValidator val) {
        try {
            System.out.println("\nValidating request for: " + res.getGuestName() + " (" + res.getRoomType() + ")");
            val.validateBooking(res, inv);
            System.out.println("Validation Passed!");
        } catch (BookingException e) {
            // Graceful handling: we print the error but don't crash the program
            System.err.println("VALIDATION FAILED: " + e.getMessage());
        }
    }
}
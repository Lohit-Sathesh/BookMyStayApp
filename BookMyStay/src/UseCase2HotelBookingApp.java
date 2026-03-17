/**
 * ======================================================================
 * MAIN CLASS - UseCase2RoomInitialization
 * ======================================================================
 * Use Case 2: Basic Room Types & Static Availability
 * * Description:
 * This class demonstrates room initialization using domain models
 * before introducing centralized inventory management.
 * * @version 2.1
 */
public class UseCase2HotelBookingApp {

    /**
     * Application entry point.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // 1. Initialize concrete Room objects using Polymorphism
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // 2. Availability represented using simple variables (Static State)
        int singleRoomAvailability = 10;
        int doubleRoomAvailability = 5;
        int suiteRoomAvailability = 2;

        // 3. Display Output
        System.out.println("=== Hotel Booking System: Room Inventory ===");

        System.out.print("Single Room -> ");
        singleRoom.displayRoomDetails();
        System.out.println(" | Available: " + singleRoomAvailability);

        System.out.print("Double Room -> ");
        doubleRoom.displayRoomDetails();
        System.out.println(" | Available: " + doubleRoomAvailability);

        System.out.print("Suite Room  -> ");
        suiteRoom.displayRoomDetails();
        System.out.println(" | Available: " + suiteRoomAvailability);

        System.out.println("==============================================");
    }
}
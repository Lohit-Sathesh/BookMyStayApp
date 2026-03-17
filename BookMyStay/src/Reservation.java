/**
 * ======================================================================
 * CLASS - Reservation
 * ======================================================================
 * Use Case 5: Booking Request (FIFO)
 * * Description:
 * This class represents a booking request made by a guest.
 * At this stage, a reservation only captures intent, not confirmation.
 * * @version 5.0
 */
public class Reservation {
    private String guestName;
    private String roomType;

    /**
     * Creates a new booking request.
     * @param guestName name of the guest
     * @param roomType requested room type (e.g., "Single")
     */
    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
}
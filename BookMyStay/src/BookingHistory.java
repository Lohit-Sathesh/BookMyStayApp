import java.util.ArrayList;
import java.util.List;

/**
 * ======================================================================
 * CLASS - BookingHistory
 * ======================================================================
 * Use Case 8: Booking History & Reporting
 * * Maintains a persistent record of all confirmed reservations in the 
 * order they were processed.
 * * @version 8.0
 */
public class BookingHistory {
    private List<Reservation> history;

    public BookingHistory() {
        this.history = new ArrayList<>();
    }

    /** Adds a confirmed reservation to the historical record. */
    public void recordBooking(Reservation reservation) {
        history.add(reservation);
    }

    /** Returns the full list of historical bookings. */
    public List<Reservation> getHistory() {
        return new ArrayList<>(history); // Defensive copy
    }
}
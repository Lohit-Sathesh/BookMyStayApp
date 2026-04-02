import java.util.List;

/**
 * ======================================================================
 * CLASS - BookingReportService
 * ======================================================================
 * Use Case 8: Booking History & Reporting
 * * Responsible for generating summaries and analytical reports from 
 * stored booking data.
 * * @version 8.0
 */
public class BookingReportService {

    /**
     * Generates a summary report of all bookings stored in history.
     * @param history the historical record to analyze
     */
    public void generateSummaryReport(BookingHistory history) {
        List<Reservation> records = history.getHistory();

        System.out.println("\n--- FINAL BOOKING SUMMARY REPORT ---");
        System.out.println("Total Confirmed Bookings: " + records.size());
        System.out.println("------------------------------------");

        if (records.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (int i = 0; i < records.size(); i++) {
                Reservation r = records.get(i);
                System.out.println((i + 1) + ". Guest: " + r.getGuestName() +
                        " | Room: " + r.getRoomType());
            }
        }
        System.out.println("------------------------------------");
    }
}
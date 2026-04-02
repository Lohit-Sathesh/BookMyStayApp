public class UseCase8Reporting {

    public static void main(String[] args) {
        System.out.println("=== Book My Stay: History & Reporting (v8.0) ===");

        // 1. Setup Components
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();
        BookingService bookingService = new BookingService();
        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();

        // 2. Simulate Requests
        queue.addRequest(new Reservation("Lohit", "Suite"));
        queue.addRequest(new Reservation("Sathesh", "Single"));

        // 3. Process and Record
        while (queue.hasPendingRequests()) {
            Reservation current = queue.getNextRequest();

            // In a real flow, we check if bookingService.processBooking is successful
            // For this simulation, we record them as they are processed
            bookingService.processBooking(current, inventory);
            history.recordBooking(current);
        }

        // 4. Generate Report for Admin
        reportService.generateSummaryReport(history);

        System.out.println("==================================================");
    }
}


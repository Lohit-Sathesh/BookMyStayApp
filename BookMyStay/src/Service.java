/**
 * ======================================================================
 * CLASS - Service
 * ======================================================================
 * Use Case 7: Add-On Service Selection
 * * Represents an optional service that can be added to a reservation.
 * @version 7.0
 */
public class Service {
    private String serviceName;
    private double price;

    public Service(String serviceName, double price) {
        this.serviceName = serviceName;
        this.price = price;
    }

    public String getServiceName() { return serviceName; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return serviceName + " ($" + price + ")";
    }
}
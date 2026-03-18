/**
 *
 * MAIN CLASS BookMyStayApp
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * Demonstrates attaching optional services
 * to a confirmed reservation.
 *
 * Does NOT affect booking or inventory.
 *
 * @version 7.0
 */

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Add-On Service Selection");

        /*
         * Assume reservation already created
         * from Use Case 6
         */
        String reservationId = "Single-1";

        /*
         * Initialize service manager
         */
        AddOnServiceManager manager =
                new AddOnServiceManager();

        /*
         * Create services
         */
        AddOnService breakfast =
                new AddOnService("Breakfast", 500);

        AddOnService spa =
                new AddOnService("Spa", 1000);

        /*
         * Attach services to reservation
         */
        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, spa);

        /*
         * Calculate total cost
         */
        double totalCost =
                manager.calculateTotalServiceCost(reservationId);

        /*
         * Display result
         */
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}
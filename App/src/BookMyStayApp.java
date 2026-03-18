/**
 *
 * MAIN CLASS BookMyStayApp
 *
 * Use Case 10: Booking Cancellation
 *
 * Description:
 * Demonstrates cancellation of bookings
 * and rollback using stack.
 *
 * @version 10.0
 */

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation");

        /*
         * Initialize inventory
         */
        RoomInventory inventory = new RoomInventory();

        /*
         * Initialize cancellation service
         */
        CancellationService cancellationService =
                new CancellationService();

        /*
         * Simulate confirmed booking
         */
        String reservationId = "Single-1";
        String roomType = "Single";

        cancellationService.registerBooking(
                reservationId,
                roomType
        );

        /*
         * Perform cancellation
         */
        cancellationService.cancelBooking(
                reservationId,
                inventory
        );

        /*
         * Show rollback history
         */
        cancellationService.showRollbackHistory();

        /*
         * Show updated inventory
         */
        int updated =
                inventory.getRoomAvailability().get("Single");

        System.out.println(
                "\nUpdated Single Room Availability: " + updated
        );
    }
}
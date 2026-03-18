import java.util.Scanner;

/**
 *
 * MAIN CLASS BookMyStayApp
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * Demonstrates how user input
 * is validated before booking.
 *
 * The system:
 * - Accepts input
 * - Validates input
 * - Handles errors safely
 *
 * @version 9.0
 */

public class BookMyStayApp {

    public static void main(String[] args) {

        // Display header
        System.out.println("Booking Validation");

        Scanner scanner = new Scanner(System.in);

        // Initialize components
        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator =
                new ReservationValidator();
        BookingRequestQueue queue =
                new BookingRequestQueue();

        try {

            /*
             * Get user input
             */
            System.out.print("Enter guest name: ");
            String name = scanner.nextLine();

            System.out.print(
                    "Enter room type (Single/Double/Suite): "
            );
            String roomType = scanner.nextLine();

            /*
             * Validate input
             */
            validator.validate(name, roomType, inventory);

            /*
             * If valid → create booking request
             */
            Reservation reservation =
                    new Reservation(name, roomType);

            queue.addRequest(reservation);

            System.out.println("Booking request accepted.");

        } catch (InvalidBookingException e) {

            /*
             * Handle validation errors
             */
            System.out.println(
                    "Booking failed: " + e.getMessage()
            );

        } finally {

            /*
             * Cleanup
             */
            scanner.close();
        }
    }
}
/**
 *
 * MAIN CLASS BookMyStayApp
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class demonstrates how booking
 * requests are confirmed and rooms
 * are allocated safely.
 *
 * Booking requests are processed
 * in FIFO order using the booking queue.
 *
 * Inventory is updated immediately
 * after allocation.
 *
 * @version 6.3
 */

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        /*
         * Initialize inventory
         */
        RoomInventory inventory = new RoomInventory();

        /*
         * Initialize booking queue
         */
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        /*
         * Create booking requests
         */
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Single");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        /*
         * Add requests to queue
         */
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        /*
         * Initialize allocation service
         */
        RoomAllocationService allocationService =
                new RoomAllocationService();

        /*
         * Process booking requests in FIFO order
         */
        while (bookingQueue.hasPendingRequests()) {

            Reservation request =
                    bookingQueue.getNextRequest();

            allocationService.allocateRoom(
                    request,
                    inventory
            );
        }
    }
}
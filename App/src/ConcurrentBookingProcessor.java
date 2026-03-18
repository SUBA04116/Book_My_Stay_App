/**
 *
 * CLASS ConcurrentBookingProcessor
 *
 * Use Case 11: Concurrent Booking Simulation
 *
 * Description:
 * Simulates multi-threaded booking processing.
 * Ensures thread-safe access to shared resources.
 *
 * @version 11.0
 */

public class ConcurrentBookingProcessor implements Runnable {

    /**
     * Shared booking queue
     */
    private BookingRequestQueue bookingQueue;

    /**
     * Shared inventory
     */
    private RoomInventory inventory;

    /**
     * Shared allocation service
     */
    private RoomAllocationService allocationService;

    /**
     * Constructor
     */
    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventory inventory,
            RoomAllocationService allocationService) {

        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    /**
     * Thread execution logic
     */
    @Override
    public void run() {

        while (true) {

            Reservation reservation;

            /*
             * CRITICAL SECTION 1:
             * Only one thread can access queue at a time
             */
            synchronized (bookingQueue) {

                if (bookingQueue.isEmpty()) {
                    break;
                }

                reservation = bookingQueue.pollRequest();
            }

            /*
             * CRITICAL SECTION 2:
             * Protect inventory updates
             */
            synchronized (inventory) {
                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}

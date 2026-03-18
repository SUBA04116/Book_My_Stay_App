import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * CLASS BookingRequestQueue
 *
 * Description:
 * Manages booking requests using Queue (FIFO).
 *
 * @version Updated for Use Case 11
 */

public class BookingRequestQueue {

    /**
     * Internal queue storing booking requests
     */
    private Queue<Reservation> queue;

    /**
     * Constructor
     */
    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    /**
     * Adds a booking request to queue
     *
     * @param reservation booking request
     */
    public void addRequest(Reservation reservation) {
        queue.offer(reservation);
    }

    /**
     * Retrieves and removes next request
     *
     * @return next reservation
     */
    public Reservation pollRequest() {
        return queue.poll();
    }

    /**
     * Checks if queue is empty
     *
     * @return true if empty
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
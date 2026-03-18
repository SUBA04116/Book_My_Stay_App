import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * CLASS CancellationService
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * Handles booking cancellations and
 * restores system state safely.
 *
 * Ensures:
 * - Inventory is restored
 * - Room IDs tracked for rollback
 * - Invalid cancellations prevented
 *
 * @version 10.0
 */

public class CancellationService {

    /**
     * Stack storing recently released room IDs
     * (LIFO rollback behavior)
     */
    private Stack<String> releasedRoomIds;

    /**
     * Maps reservation ID → room type
     */
    private Map<String, String> reservationRoomTypeMap;

    /**
     * Initializes structures
     */
    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    /**
     * Registers a confirmed booking
     *
     * @param reservationId confirmed ID
     * @param roomType allocated room type
     */
    public void registerBooking(String reservationId,
                                String roomType) {

        reservationRoomTypeMap.put(reservationId, roomType);
    }

    /**
     * Cancels booking and restores inventory
     *
     * @param reservationId reservation to cancel
     * @param inventory centralized inventory
     */
    public void cancelBooking(String reservationId,
                              RoomInventory inventory) {

        /*
         * Validate reservation existence
         */
        if (!reservationRoomTypeMap.containsKey(reservationId)) {

            System.out.println("Invalid cancellation request.");
            return;
        }

        /*
         * Get room type
         */
        String roomType =
                reservationRoomTypeMap.get(reservationId);

        /*
         * Push to rollback stack
         */
        releasedRoomIds.push(reservationId);

        /*
         * Restore inventory
         */
        int current =
                inventory.getRoomAvailability().get(roomType);

        inventory.updateAvailability(roomType, current + 1);

        /*
         * Remove booking record
         */
        reservationRoomTypeMap.remove(reservationId);

        /*
         * Confirmation message
         */
        System.out.println(
                "Booking cancelled successfully. " +
                        "Inventory restored for room type: " + roomType
        );
    }

    /**
     * Displays rollback history
     */
    public void showRollbackHistory() {

        System.out.println("\nRollback History (Most Recent First):");

        while (!releasedRoomIds.isEmpty()) {

            System.out.println(
                    "Released Reservation ID: "
                            + releasedRoomIds.pop()
            );
        }
    }
}
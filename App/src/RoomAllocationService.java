import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * CLASS RoomAllocationService
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class is responsible for confirming
 * booking requests and assigning rooms.
 *
 * It ensures:
 * - Each room ID is unique
 * - Inventory is updated immediately
 * - No room is double-booked
 *
 * @version 6.3
 */

public class RoomAllocationService {

    /**
     * Stores all allocated room IDs
     * to prevent duplicate assignments.
     */
    private Set<String> allocatedRoomIds;

    /**
     * Stores assigned room IDs by room type.
     *
     * Key   -> Room type
     * Value -> Set of assigned room IDs
     */
    private Map<String, Set<String>> assignedRoomsByType;

    /**
     * Initializes allocation tracking structures.
     */
    public RoomAllocationService() {

        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    /**
     * Confirms a booking request by assigning
     * a unique room ID and updating inventory.
     *
     * @param reservation booking request
     * @param inventory centralized room inventory
     */
    public void allocateRoom(Reservation reservation,
                             RoomInventory inventory) {

        String roomType = reservation.getRoomType();

        int available = inventory.getRoomAvailability().get(roomType);

        /*
         * Check if room is available
         */
        if (available <= 0) {

            System.out.println(
                    "No available rooms for type: " + roomType
            );
            return;
        }

        /*
         * Generate unique room ID
         */
        String roomId = generateRoomId(roomType);

        /*
         * Track allocated room IDs
         */
        allocatedRoomIds.add(roomId);

        /*
         * Store room ID by room type
         */
        assignedRoomsByType
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        /*
         * Update inventory immediately
         */
        inventory.updateAvailability(roomType, available - 1);

        /*
         * Confirm reservation
         */
        System.out.println(
                "Booking confirmed for Guest: "
                        + reservation.getGuestName()
                        + ", Room ID: "
                        + roomId
        );
    }

    /**
     * Generates a unique room ID
     * for the given room type.
     *
     * @param roomType type of room
     * @return unique room ID
     */
    private String generateRoomId(String roomType) {

        int number = 1;

        String roomId;

        do {

            roomId = roomType + "-" + number;
            number++;

        } while (allocatedRoomIds.contains(roomId));

        return roomId;
    }
}
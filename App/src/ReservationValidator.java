import java.util.Map;

/**
 *
 * CLASS ReservationValidator
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * This class validates booking input
 * before processing.
 *
 * All validation logic is centralized here.
 *
 * @version 9.0
 */

public class ReservationValidator {

    /**
     * Validates booking input.
     *
     * @param guestName name of the guest
     * @param roomType requested room type
     * @param inventory centralized inventory
     *
     * @throws InvalidBookingException if validation fails
     */
    public void validate(
            String guestName,
            String roomType,
            RoomInventory inventory
    ) throws InvalidBookingException {

        /*
         * Validate guest name
         */
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException(
                    "Guest name cannot be empty."
            );
        }

        /*
         * Validate room type
         */
        Map<String, Integer> rooms =
                inventory.getRoomAvailability();

        if (!rooms.containsKey(roomType)) {
            throw new InvalidBookingException(
                    "Invalid room type selected."
            );
        }

        /*
         * Validate availability
         */
        if (rooms.get(roomType) <= 0) {
            throw new InvalidBookingException(
                    "No rooms available for selected type."
            );
        }
    }
}

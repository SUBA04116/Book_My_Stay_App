/**
 *
 * MAIN CLASS BookMyStayApp
 *
 * Use Case 4: Room Search & Availability Check
 *
 * Description:
 * This class demonstrates how guests
 * can search for available rooms
 * without modifying inventory data.
 *
 * The system enforces read-only access
 * by design.
 *
 * @version 4.3
 */

public class BookMyStayApp {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        /*
         * Create room domain objects
         */
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        /*
         * Initialize centralized inventory
         */
        RoomInventory inventory = new RoomInventory();

        /*
         * Create search service
         */
        RoomSearchService searchService = new RoomSearchService();

        /*
         * Perform room search
         * (Read-only operation)
         */
        searchService.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}
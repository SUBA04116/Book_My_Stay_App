/**
 *
 * MAIN CLASS BookMyStayApp
 *
 * Use Case 12: Data Persistence & Recovery
 *
 * Description:
 * Demonstrates saving and restoring inventory
 * using file-based persistence.
 *
 * @version 12.0
 */

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("System Recovery");

        /*
         * Initialize inventory
         */
        RoomInventory inventory = new RoomInventory();

        /*
         * Initialize persistence service
         */
        FilePersistenceService persistence =
                new FilePersistenceService();

        String filePath = "inventory.txt";

        /*
         * LOAD existing data (if any)
         */
        persistence.loadInventory(inventory, filePath);

        /*
         * Display inventory
         */
        System.out.println("\nCurrent Inventory:");

        System.out.println("Single: " +
                inventory.getRoomAvailability().get("Single"));

        System.out.println("Double: " +
                inventory.getRoomAvailability().get("Double"));

        System.out.println("Suite: " +
                inventory.getRoomAvailability().get("Suite"));

        /*
         * SAVE current state
         */
        persistence.saveInventory(inventory, filePath);
    }
}